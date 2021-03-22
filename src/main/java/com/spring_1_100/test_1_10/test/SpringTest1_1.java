package com.spring_1_100.test_1_10.test;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpringTest1_1 {


    /** Default path separator: "/" */
    public static final String DEFAULT_PATH_SEPARATOR = "/";


    private static final int CACHE_TURNOFF_THRESHOLD = 65536;

    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{[^/]+?\\}");



    private static volatile Boolean cachePatterns;

    public static boolean caseSensitive = true;

    private static boolean trimTokens = true;


    private static String pathSeparator = DEFAULT_PATH_SEPARATOR;

    private static final Map<String, String[]> tokenizedPatternCache = new ConcurrentHashMap<String, String[]>(256);

    public static final Map<String, AntPathStringMatcher> stringMatcherCache = new ConcurrentHashMap<String, AntPathStringMatcher>(256);


    public static void main(String[] args) {
        String pattern = "/**/a/**/b";
        String path = "/a/a/b";
        boolean a = doMatch(pattern, path, true, null);
        System.out.println(a);
    }



    //有4个步骤
    //	    1. 分解模式字符串, 分解路径字符串
    //	      2. 第一个while 循环, 用来判断绝对匹配   /xxx/abc ==> /xxx/abc
    //	      3. 第二个while循环两个字符串数组都从最后的下标开始匹配, 直到遇到pattDir为'**'时结束
    //	      4. 第三个while循环, 主要解决有多个'**'字符串.    /**/djdjdjd/**, /a/**/**/b/**/c/**/*.class等
    protected static boolean doMatch(String pattern, String path, boolean fullMatch, Map<String, String> uriTemplateVariables) {
        if (path.startsWith(pathSeparator) != pattern.startsWith(pathSeparator)) {
            return false;
        }
        //  1.1. 分解模式字符串
        String[] pattDirs = tokenizePattern(pattern);
        // 1.2 分解路径字符串
        String[] pathDirs = tokenizePath(path);
        // pattern的可分配下标 pattIdxStart ~ pattIdxEnd
        // path的可分配下标	pathIdxStart ~ pathIdxEnd
        int pattIdxStart = 0;
        int pattIdxEnd = pattDirs.length - 1;
        int pathIdxStart = 0;
        int pathIdxEnd = pathDirs.length - 1;

        // Match all elements up to the first **
        // 2. 第一个while 循环, 用来判断绝对匹配的   /xxx/abc ==> /xxx/abc
        // 两个字符串都从下标0开始, 直到模式字符串遇到**结束
        while (pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            String pattDir = pattDirs[pattIdxStart];
            if ("**".equals(pattDir)) {
                break;
            }
            if (!matchStrings(pattDir, pathDirs[pathIdxStart], uriTemplateVariables)) {
                return false;
            }
            pattIdxStart++;
            pathIdxStart++;
        }
        // pathIdxStart > pathIdEnd, 表示文件路径(path), 已经逐一的匹配到了
        if (pathIdxStart > pathIdxEnd) {
            // 数组中第一个值是pattern，第二个值是path ，后面所有注释都是如此 [/xxx/abc,/xxx/abc]  , [ /xxx/*,/xxx/abc]
            if (pattIdxStart > pattIdxEnd) {
                return (pattern.endsWith(pathSeparator) ? path.endsWith(pathSeparator) :
                        !path.endsWith(pathSeparator));
            }
            // [/xxx/abc/*,/xxx/abc] , [/xxx/abc/ddd,/xxx/abc] && fullMatch = false
            if (!fullMatch) {
                return true;
            }
            // [/*/*/,/abc/] , [/abc/*,/abc/]    &&   fullMatch == true
            if (pattIdxStart == pattIdxEnd && pattDirs[pattIdxStart].equals("*") && path.endsWith(pathSeparator)) {
                return true;
            }
            for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
                // [/*/*/,/abc/] , [/abc/*,/abc ]    &&   fullMatch == true 注意 第二个数组中abc后面没有【/】
                if (!pattDirs[i].equals("**")) {
                    return false;
                }
            }
            // [/abc/**,/abc]  && fullMatch == true
            return true;
        }
        // [/abc/def , /abc/def/ccc ] , [/abc/* , /abc/def/ccc ]
        else if (pattIdxStart > pattIdxEnd) {
            return false;
        }
        // [/abc/** , /abc/def/ccc ] && fullMatch == false
        else if (!fullMatch && "**".equals(pattDirs[pattIdxStart])) {
            return true;
        }

        // 3. 两个字符串数组都从最后的下标开始匹配, 直到遇到pattDir为'**'时结束
        while (pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            String pattDir = pattDirs[pattIdxEnd];
            if (pattDir.equals("**")) {
                break;
            }
            if (!matchStrings(pattDir, pathDirs[pathIdxEnd], uriTemplateVariables)) {
                // [/xxxx/abcd/**/ddd.class,/xxxx/abcd/xxx.class] && fullMatch == true
                return false;
            }
            pattIdxEnd--;
            pathIdxEnd--;
        }
        if (pathIdxStart > pathIdxEnd) {
            for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
                if (!pattDirs[i].equals("**")) {
                    // [/**/xxx/bb, /bb]  && fullMatch == true
                    return false;
                }
            }
            // 这里返回true 一般字符串为
            // [/xxxx/abcd/**/*.class, /xxxx/abcd/xxx.class]  && fullMatch == true
            // 即只有一个**, 而且**没发挥到什么作用
            return true;
        }
        // 4. 第3个while循环, 主要解决有多个'**'字符串.	/**/djdjdjd/**, /a/**/**/b/**/c/**/*.class等
        // 每次下标又从pattIdxStart+1开始
        while (pattIdxStart != pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            int patIdxTmp = -1;
            for (int i = pattIdxStart + 1; i <= pattIdxEnd; i++) {
                if (pattDirs[i].equals("**")) {
                    patIdxTmp = i;
                    break;
                }
            }
            if (patIdxTmp == pattIdxStart + 1) {
                // '**/**' situation, so skip one
                // '**/**' 遇到连续的/**/**就跳过, 因为这没有意义, 一个/**也可以表达多条路径
                pattIdxStart++;
                continue;
            }
            // Find the pattern between padIdxStart & padIdxTmp in str between
            // strIdxStart & strIdxEnd
            // patLength: 两个'**'之间的字符串的长度  /**/a/b/** = 2
            // strLength: 路径还剩多少个没匹配 	/a/b/c/d	如果/a/b都匹配了, 就只剩下/b/c = 2
            int patLength = (patIdxTmp - pattIdxStart - 1);
            int strLength = (pathIdxEnd - pathIdxStart + 1);
            int foundIdx = -1;

            strLoop:
            // 因为已经确定了有 /**/a/b/**这样的模式字符串存在, 中间2长度
            // 如果存在/q/a/b/c/d 有5个长度, 那么就要循环3次
            // 第一次匹配 /a/b => /q/a
            // 第二次	 /a/b => /a/b	=> 这里已经匹配到了, 所以就break了
            // 			 /a/b => /b/c
            // 			 /a/b => /c/d
            // 当然, 如果存在更复杂的如: /**/a/b/**/a/b/**/a/b/**, 外层的while循环就会做3次判断,
            // [/**/a/b/**/a/b/**/a/b/**,/q/q/q/a/b/q/q/q/a/b/q/q/q/a/b/q/q/q/a/b] &&  fullMatch == true
            for (int i = 0; i <= strLength - patLength; i++) {
                for (int j = 0; j < patLength; j++) {
                    String subPat = pattDirs[pattIdxStart + j + 1];
                    String subStr = pathDirs[pathIdxStart + i + j];
                    if (!matchStrings(subPat, subStr, uriTemplateVariables)) {
                        continue strLoop;
                    }
                }
                foundIdx = pathIdxStart + i;
                break;
            }

            if (foundIdx == -1) {
                // [/**/a/b/c/**/c,/q/a/b/c ] &&  fullMatch == true
                return false;
            }

            pattIdxStart = patIdxTmp;
            pathIdxStart = foundIdx + patLength;
        }

        for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
            if (!pattDirs[i].equals("**")) {
                // 实在想不出哪种情况了。以后遇到再来补吧
                return false;
            }
        }
        // 如果上面的都没有返回值  ....就会在此处返回 [/**, /sdjdd/djkd/] &&  fullMatch == true
        return true;
    }



    public static String[] tokenizePattern(String pattern) {
        String[] tokenized = null;
        Boolean cachePatterns = SpringTest1_1.cachePatterns;
        if (cachePatterns == null || cachePatterns.booleanValue()) {
            tokenized = tokenizedPatternCache.get(pattern);
        }
        if (tokenized == null) {
            tokenized = tokenizePath(pattern);
            if (cachePatterns == null && tokenizedPatternCache.size() >= CACHE_TURNOFF_THRESHOLD) {
                deactivatePatternCache();
                return tokenized;
            }
            if (cachePatterns == null || cachePatterns.booleanValue()) {
                tokenizedPatternCache.put(pattern, tokenized);
            }
        }
        return tokenized;
    }

    private static void deactivatePatternCache() {
        cachePatterns = false;
        tokenizedPatternCache.clear();
        stringMatcherCache.clear();
    }

    protected static String[] tokenizePath(String path) {
        return StringUtils.tokenizeToStringArray(path, pathSeparator, trimTokens, true);
    }

    private static boolean matchStrings(String pattern, String str, Map<String, String> uriTemplateVariables) {
        return getStringMatcher(pattern).matchStrings(str, uriTemplateVariables);
    }

    protected static AntPathStringMatcher getStringMatcher(String pattern) {
        AntPathStringMatcher matcher = null;
        Boolean cachePatterns = SpringTest1_1.cachePatterns;
        if (cachePatterns == null || cachePatterns.booleanValue()) {
            matcher = stringMatcherCache.get(pattern);
        }
        if (matcher == null) {
            matcher = new AntPathStringMatcher(pattern, caseSensitive);
            if (cachePatterns == null && stringMatcherCache.size() >= CACHE_TURNOFF_THRESHOLD) {
                // Try to adapt to the runtime situation that we're encountering:
                // There are obviously too many different patterns coming in here...
                // So let's turn off the cache since the patterns are unlikely to be reoccurring.
                deactivatePatternCache();
                return matcher;
            }
            if (cachePatterns == null || cachePatterns.booleanValue()) {
                stringMatcherCache.put(pattern, matcher);
            }
        }
        return matcher;
    }



    protected static class AntPathStringMatcher {

        private static final Pattern GLOB_PATTERN = Pattern.compile("\\?|\\*|\\{((?:\\{[^/]+?\\}|[^/{}]|\\\\[{}])+?)\\}");

        private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";

        private final Pattern pattern;

        private final List<String> variableNames = new LinkedList<String>();

        public AntPathStringMatcher(String pattern) {
            this(pattern, true);
        }

        public AntPathStringMatcher(String pattern, boolean caseSensitive) {
            StringBuilder patternBuilder = new StringBuilder();
            Matcher matcher = GLOB_PATTERN.matcher(pattern);
            int end = 0;
            while (matcher.find()) {
                patternBuilder.append(quote(pattern, end, matcher.start()));
                String match = matcher.group();
                if ("?".equals(match)) {
                    patternBuilder.append('.');
                }
                else if ("*".equals(match)) {
                    patternBuilder.append(".*");
                }
                else if (match.startsWith("{") && match.endsWith("}")) {
                    int colonIdx = match.indexOf(':');
                    if (colonIdx == -1) {
                        patternBuilder.append(DEFAULT_VARIABLE_PATTERN);
                        this.variableNames.add(matcher.group(1));
                    }
                    else {
                        String variablePattern = match.substring(colonIdx + 1, match.length() - 1);
                        patternBuilder.append('(');
                        patternBuilder.append(variablePattern);
                        patternBuilder.append(')');
                        String variableName = match.substring(1, colonIdx);
                        this.variableNames.add(variableName);
                    }
                }
                end = matcher.end();
            }
            patternBuilder.append(quote(pattern, end, pattern.length()));
            this.pattern = (caseSensitive ? Pattern.compile(patternBuilder.toString()) :
                    Pattern.compile(patternBuilder.toString(), Pattern.CASE_INSENSITIVE));
        }

        private String quote(String s, int start, int end) {
            if (start == end) {
                return "";
            }
            return Pattern.quote(s.substring(start, end));
        }

        /**
         * Main entry point.
         * @return {@code true} if the string matches against the pattern, or {@code false} otherwise.
         */
        public boolean matchStrings(String str, Map<String, String> uriTemplateVariables) {
            Matcher matcher = this.pattern.matcher(str);
            if (matcher.matches()) {
                if (uriTemplateVariables != null) {
                    // SPR-8455
                    if (this.variableNames.size() != matcher.groupCount()) {
                        throw new IllegalArgumentException("The number of capturing groups in the pattern segment " +
                                this.pattern + " does not match the number of URI template variables it defines, " +
                                "which can occur if capturing groups are used in a URI template regex. " +
                                "Use non-capturing groups instead.");
                    }
                    for (int i = 1; i <= matcher.groupCount(); i++) {
                        String name = this.variableNames.get(i - 1);
                        String value = matcher.group(i);
                        uriTemplateVariables.put(name, value);
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
    }


}



