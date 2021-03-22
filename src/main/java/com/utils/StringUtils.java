package com.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @类描述：字符串工具类
 * @author 陈金虎 2017年1月16日 下午11:43:50
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

public class StringUtils {

	public static final String EMPTY = "";
	public static final int INDEX_NOT_FOUND = -1;
	private static final int PAD_LIMIT = 8192;

	private static final String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


	/**
	 * 字符串是否包含中文
	 *
	 * @param str 待校验字符串
	 * @return true 包含中文字符 false 不包含中文字符
	 * @throws
	 */
	public static boolean isContainChineseAndSymbol(String str)  {

		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 过滤掉中文
	 * @param str 待过滤中文的字符串
	 * @return 过滤掉中文后字符串
	 */
	public static String filterChinese(String str) {
		// 用于返回结果
		String result = str;
		boolean flag = isContainChinese(str);
		if (flag) {// 包含中文
			// 用于拼接过滤中文后的字符
			StringBuffer sb = new StringBuffer();
			// 用于校验是否为中文
			boolean flag2 = false;
			// 用于临时存储单字符
			char chinese = 0;
			// 5.去除掉文件名中的中文
			// 将字符串转换成char[]
			char[] charArray = str.toCharArray();
			// 过滤到中文及中文字符
			for (int i = 0; i < charArray.length; i++) {
				chinese = charArray[i];
				flag2 = isChinese(chinese);
				if (!flag2) {// 不是中日韩文字及标点符号
					sb.append(chinese);
				}
			}
			result = sb.toString();
		}
		return result;
	}


	/**
	 * 校验一个字符是否是汉字
	 *
	 * @param c
	 *  被校验的字符
	 * @return true代表是汉字
	 */
	public static boolean isChineseChar(char c) {
		try {
			return String.valueOf(c).getBytes("UTF-8").length > 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 验证字符串内容是否包含下列非法字符<br>
	 * `~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆
	 *
	 * @param content
	 *  字符串内容
	 * @return 't'代表不包含非法字符，otherwise代表包含非法字符。
	 */
	public static char validateLegalString(String content) {
		String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
		char isLegalChar = 't';
		L1: for (int i = 0; i < content.length(); i++) {
			for (int j = 0; j < illegal.length(); j++) {
				if (content.charAt(i) == illegal.charAt(j)) {
					isLegalChar = content.charAt(i);
					break L1;
				}
			}
		}
		return isLegalChar;
	}

	/**
	 * 验证是否是汉字或者0-9、a-z、A-Z
	 *
	 * @param c
	 *  被验证的char
	 * @return true代表符合条件
	 */
	public static boolean isRightChar(char c) {
		return isChinese(c) || isWord(c);
	}

	/**
	 * 校验某个字符是否是a-z、A-Z、_、0-9
	 *
	 * @param c
	 *  被校验的字符
	 * @return true代表符合条件
	 */
	public static boolean isWord(char c) {
		String regEx = "[\\w]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher("" + c);
		return m.matches();
	}

	/**
	 * 判定输入的是否是汉字
	 *
	 * @param c
	 *  被校验的字符
	 * @return true代表是汉字
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 校验String是否全是中文
	 *
	 * @param name
	 *  被校验的字符串
	 * @return true代表全是汉字
	 */
	public static boolean checkNameChese(String name) {
		boolean res = true;
		char[] cTemp = name.toCharArray();
		for (int i = 0; i < name.length(); i++) {
			if (!isChinese(cTemp[i])) {
				res = false;
				break;
			}
		}
		return res;
	}




	public static final Long INVITE_START_VALUE = 16796251L;

	private static final String COMMA = ",";
	private static final String[] DUOTRIKEY = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V" };
	private static final String[] CARDINALNUM = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	private static final String[] VIEWCHARS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" , "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V"};
	private static final String[] NUMBERS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


	/**
	 * 通过StringBuffer来组装字符串
	 *
	 * @param strings
	 * @return
	 */
	public static String appendStrs(Object... strings) {
		StringBuffer sb = new StringBuffer();
		for (Object str : strings) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static String join(char[] array, char separator, int startIndex, int endIndex) {
		if (array == null) {
			return null;
		} else {
			int noOfItems = endIndex - startIndex;
			if (noOfItems <= 0) {
				return "";
			} else {
				StringBuilder buf = new StringBuilder(noOfItems * 16);

				for(int i = startIndex; i < endIndex; ++i) {
					if (i > startIndex) {
						buf.append(separator);
					}

					buf.append(array[i]);
				}

				return buf.toString();
			}
		}
	}
	public static String join(char[] array, char separator) {
		return array == null ? null : join((char[])array, separator, 0, array.length);
	}

	/**
	 * 判断所有传入参数是否非空，当传入参数长度为0，或者任意有一个为空，则返回false，所有都非空，则返回true
	 *
	 * @param strArr
	 * @return
	 */
	public static boolean isAllNotEmpty(String... strArr) {
		boolean isAllNotEmpty = true;
		if (strArr == null || strArr.length < 1) {
			isAllNotEmpty = false;
			return isAllNotEmpty;
		}

		for (String str : strArr) {
			if (str == null || str.length() == 0) {
				isAllNotEmpty = false;
				break;
			}
		}
		return isAllNotEmpty;
	}

	/**
	 * 把list按分隔符转换成字符串
	 *
	 * @param strList
	 *            list数据
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String turnListToStr(Collection<String> strList, String separator) {
		String result = "";
		if (strList == null || strList.size() < 1) {
			return result;
		}
		if (separator == null) {
			separator = ",";
		}

		for (String item : strList) {
			result = result + separator + item;
		}
		return result.substring(separator.length());
	}

	/**
	 * 把字符串数组按分隔符转化成字符串
	 *
	 * @param strArr
	 *            字符串数组
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String turnArrayToStr(String separator, String... strArr) {
		String result = "";
		if (strArr == null || strArr.length < 1) {
			return result;
		}
		if (separator == null) {
			separator = ",";
		}

		for (String item : strArr) {
			result = result + separator + item;
		}
		return result.substring(separator.length());
	}

	public static String strToSecret(String str, int left, int right) {
		StringBuffer sb = new StringBuffer();
		int len = str.length() - left - right;
		if (len > 0) {
			sb.append(str.substring(0, left));
			for (int i = 0; i < len; i++) {
				sb.append("*");
			}
			sb.append(str.substring(str.length() - right));
		} else {
			return str;
		}
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str != null && (strLen = str.length()) != 0) {
			for(int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(str.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}



	public static String getNotEmptyString(String str) {
		return isNotEmpty(str) ? str : EMPTY;
	}

	public static String getLastString(String str, int num) {
		int len = str.length();
		if (len <= num) {
			return str;
		} else {
			return str.substring(len - num);
		}
	}

	public static List<String> splitToList(String source, String sep) {
		List<String> result = new ArrayList<String>();
		try {
			if (isBlank(source)) {
				return result;
			}
			String[] tempResult = source.split(sep);
			for (String item : tempResult) {
				result.add(item);
			}
		} catch (Exception e) {

		}
		return result;
	}

	/**
	 * @方法描述：将字符串中的emoji符号转换为*
	 *
	 * @author huyang 2017年4月6日下午12:38:04
	 * @param source
	 *            待处理字符串
	 * @return
	 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
	 */
	public static String filterEmoji(String source) {
		if (source != null) {
			Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
			Matcher emojiMatcher = emoji.matcher(source);
			if (emojiMatcher.find()) {
				source = emojiMatcher.replaceAll("*");
				return source;
			}
			return source;
		}
		return source;
	}

	public static String null2Str(Object str) {
		return (str != null) ? str.toString() : "";
	}

	public static String logisticsInfoDeal(String str) {
		if (str == null || "暂无".equals(str.trim())) {
			return "";
		}
		return str.trim();
	}

	/**
	 * @Title: UrlEncoder
	 * @Description: 字符串编码
	 * @param sStr
	 * @return
	 */
	public final static String UrlEncoder(String sStr) {
		String sReturnCode = "";
		try {
			sReturnCode = URLEncoder.encode(null2Str(sStr), "utf-8");
		} catch (Exception ex) {
		}
		return sReturnCode;
	}

	/**
	 * @Title: UrlDecoder
	 * @Description: 字符串解码
	 * @param sStr
	 * @return
	 */
	public static String UrlDecoder(String sStr) {
		if (isEmpty(sStr)) {
			return "";
		} else {
			String sReturnCode = sStr;
			try {
				sReturnCode = URLDecoder.decode(sStr, "utf-8");
			} catch (Exception e) {
			}
			return sReturnCode;
		}
	}



	/**
	 * 获取唯一编码
	 *
	 * @param userId
	 * @return
	 */
	public static String getUniqueCode(Long userId) {
		return Long.toString((userId +INVITE_START_VALUE ), 64);
	}

	/**
	 * fmai 根据基数产生随机四位数
	 *
	 * @return
	 */
	public static String getFourRandomNum() {
		StringBuilder randomNum = new StringBuilder();
		int length = CARDINALNUM.length;
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			randomNum.append(CARDINALNUM[random.nextInt(length)]);
		}
		return randomNum.toString();
	}


	/**
	 * fmai 根据基数产生随机5位数
	 *
	 * @return
	 */
	public static String getFiveRandomNum() {
		StringBuilder randomNum = new StringBuilder();
		int length = CARDINALNUM.length;
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			randomNum.append(CARDINALNUM[random.nextInt(length)]);
		}
		return randomNum.toString();
	}

	/**
	 * fmai 根据基数产生随机5位数
	 *
	 * @return
	 */
	public static String getRandomNum(int count) {
		StringBuilder randomNum = new StringBuilder();
		int length = NUMBERS.length;
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			randomNum.append(NUMBERS[random.nextInt(length)]);
		}
		return randomNum.toString();
	}



	/**
	 * fmai 根据日期年月日时生成对应的32进制字符串
	 *
	 * @return
	 */
	public static String toBinaryByTime() {
		StringBuilder binary = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		int year = (cal.get(Calendar.YEAR) - 2000) % 32;
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		binary.append(DUOTRIKEY[year]).append(DUOTRIKEY[month]).append(DUOTRIKEY[day]).append(DUOTRIKEY[hour]);
		return binary.toString();
	}



	/**
	 * 首字母大写
	 *
	 * @param s
	 * @return
	 */
	public static String firstCharUpperCase(String s) {
		StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
		sb.append(s.substring(1, s.length()));
		return sb.toString();
	}


	/**
	 * 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
	 *
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}



	/**
	 * 将对象转为字符串
	 *
	 * @param o
	 * @return
	 */
	public static String isNull(Object o) {
		if (o == null) {
			return "";
		}
		String str = "";
		if (o instanceof String) {
			str = (String) o;
		} else {
			str = o.toString();
		}
		return str.trim();
	}



	public static String removeDoubleChar(String str){
		if(str.indexOf("\"")==0) str = str.substring(1,str.length());   //去掉第一个 "
		if(str.lastIndexOf("\"")==(str.length()-1)) str = str.substring(0,str.length()-1);  //去掉最后一个 "
		return str;
	}




	/**
	 * 通过请求参数获取键值对
	 * @param requestParams
	 * @return
	 */
	public static Map<String, String> getRequestParams(Map requestParams) {
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		return params;
	}



	/**
	 * 除去数组中的空值和签名参数
	 * @param sArray 签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}


		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")  || key.equalsIgnoreCase("signInfo")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序
	 *
	 * @param params 需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */

	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());

		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			sb.append(value);
		}
		return sb.toString();
	}


	/**
	 * 以逗号隔开的元素
	 *
	 * @param value
	 * @param i
	 * @return
	 */
	public static String getSpitStr(String value, int i) {
		String values[] = value.split(",", value.length());
		if (i == 0) {
			i = i + 1;
		}
		if (values.length >= i) {
			return values[i - 1];
		} else {
			return values[0];
		}
	}


    /**
     * 拼接get请求的url请求地址
     */
    public static String getRqstUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }


    public static StringBuffer appendSb(String... strs) {
		StringBuffer stringBuffer = new StringBuffer();
		if (strs!= null && strs.length > 0){
			for (int i =0; i< strs.length; i++) {
				stringBuffer.append(strs[i]);
			}
		}
		return stringBuffer;
	}


	/**
	 * 截取一个字符串中两个字符串中间的字符串
	 * @param str
	 * @param strStart
	 * @param strEnd
	 * @return
	 */
	public static String subMidString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
		if (strStartIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
		}
		if (strEndIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
		}
        /* 开始截取 */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;
	}

	public static boolean getClassName(String className) {
		return false;
	}

	/**
	 * Object转换String
	 * @param obj
	 * @return
	 */
	public static String objToString(Object obj){
		if (null != obj) {
			return String.valueOf(obj);
		}else{
			return null;
		}
	}


	public static CharSequence getStringNum(String payNO) {
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(payNO);
		return m.replaceAll("").trim();
	}



	/**
	 * 字符串转换为Ascii
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value,int step)
	{
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(i != chars.length - 1)
			{
				sbu.append((int)chars[i] + step).append(",");
			}
			else {
				sbu.append((int)chars[i] + step);
			}
		}
		return sbu.toString();
	}

	/**
	 * Ascii转换为字符串
	 * @param value
	 * @return
	 */
	public static String asciiToString(String value)
	{
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}


	public static String getSignStr(Map<String,String> paramMap){

		StringBuffer sbfStr = new StringBuffer();
		List<String> list = new ArrayList<String>(paramMap.keySet());
		Collections.sort(list);
		for (String key : list) {
			if (!"sign".equals(key) && isNotBlank(paramMap.get(key))) {
				sbfStr.append(key + "=" + paramMap.get(key) + "&");
			}
		}
		String pendVertContent = sbfStr.toString().substring(0, sbfStr.length() - 1);
		return pendVertContent;
	}


	public static String getRandomStr(int length) {
		int randomNum;
		char randomChar;
		Random random = new Random();
		// StringBuffer类型的可以append增加字符
		StringBuffer str = new StringBuffer();

		for (int i = 0; i < length; i++) {
			// 可生成[0,n)之间的整数，获得随机位置
			randomNum = random.nextInt(base.length());
			// 获得随机位置对应的字符
			randomChar = base.charAt(randomNum);
			// 组成一个随机字符串
			str.append(randomChar);
		}
		return str.toString();
	}

	public static String removeEndStr(StringBuilder sbSelect) {
		if (sbSelect == null) {
			return "";
		}

		return sbSelect.toString().substring(0, sbSelect.toString().length() - 1);

	}



	public static String removeEndStr(StringBuilder sbSelect,String end ) {
		if (sbSelect == null) {
			return "";
		}
		if(sbSelect.toString().endsWith(end)){
			return sbSelect.toString().substring(0, sbSelect.toString().length() - 1);
		}
		return sbSelect.toString();

	}




	public static String removeEndStr(String sbSelect,String end ) {
		if (sbSelect == null) {
			return "";
		}
		if(sbSelect.toString().endsWith(end)){
			return sbSelect.toString().substring(0, sbSelect.toString().length() - 1);
		}
		return sbSelect.toString();

	}


	public static boolean isContainChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}


	public static boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		} else {
			Pattern regex = Pattern.compile("(-)?\\d*(.\\d*)?");
			Matcher matcher = regex.matcher(str);
			return matcher.matches();
		}
	}



	public static boolean isBlank(Object o) {
		return isNull(o).equals("");
	}




	/**
	 *
	 *
	 * @param args
	 */


	public final static String H5_SMS_BEGIN = "验证码是";
	public final  static  String H5_SMS_END = "。";
	public final static int SOURCE_TYPE=0;

	/**
	 * 印度手机号验证  10位 号段开头为6、7、8、9
	 *
	 * @param str 手机号码
	 * @return 检验结果（true：有效 false：无效）
	 */
	public static boolean isPhone(String str) {
		str = str.replace("-","").replace(" ","");
		String phone = isNull(str);

		if (phone.length() == 11) {
			String phonePre = phone.substring(0, 1);
			phone = phone.substring(1);
			if (!"0".equals(phonePre)) {
				return false;
			}
		} else if (phone.length() == 12) {
			String phonePre = phone.substring(0, 2);
			phone = phone.substring(2);
			if (!"91".equals(phonePre)) {
				return false;
			}
		} else if (phone.length() == 13) {
			String phonePre = phone.substring(0, 3);
			phone = phone.substring(3);
			if (!"+91".equals(phonePre)) {
				return false;
			}
		} else if (phone.length() == 10) {

		} else {
			return false;
		}
		Pattern regex = Pattern.compile("^\\d{10}$");
		Matcher matcher = regex.matcher(phone);
		boolean isMatched = matcher.matches();
		if (!isMatched) {
			return false;
		}
		String segment = phone.substring(0, 1);
		String segments = "6,7,8,9";//印度手机号码号段
		if (segments.contains(segment)) {
			return true;
		}
		return false;
	}


	/**
	 * 判断输入的身份证号码是否有效
	 *
	 * @param str 身份证号码
	 * @return 检验结果（true：有效 false：无效）
	 */
	public static boolean isCard(String str) {
		String cardId = isNull(str);
		// 身份证正则表达式(15位)
		Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		// 身份证正则表达式(18位)
		Pattern isIDCard2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
		Matcher matcher1 = isIDCard1.matcher(cardId);
		Matcher matcher2 = isIDCard2.matcher(cardId);
		boolean isMatched = matcher1.matches() || matcher2.matches();
		return isMatched;
	}


	public static boolean isNotBlank(Object o) {
		return !isNull(o).equals("");
	}

	public static String toString(String separate, int... objs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < objs.length; i++) {
			if (i > 0)
				sb.append(separate);
			sb.append(objs[i]);
		}
		return sb.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String toString(Collection list) {
		return toString(list, ",");
	}

	@SuppressWarnings("rawtypes")
	public static String toString(Collection list, String delim) {
		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (Object o : list) {
			if (index > 0) sb.append(delim);
			sb.append(o.toString());
			index++;
		}
		return sb.toString();
	}

	public static String toStringArray(Object... list) {
		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (Object o : list) {
			if (index > 0) sb.append(",");
			sb.append(o.toString());
			index++;
		}
		return sb.toString();
	}

	/**
	 * 判断字符串数组是否包含某个元素
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean isContainString(String[] arr,String targetValue){
		return Arrays.asList(arr).contains(targetValue);
	}



	/**
	 * 首字母转小写
	 * @param s
	 * @return
	 */
	public static String firstToLowerCase(String s){
		if(Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * judge that a String Array whether or not contained equal String
	 *
	 * @param strings
	 *            a string Array
	 * @return return true, contained; return false, not contained
	 */
	public static boolean judgeStrArrayContainsSameStr(String[] strings) {
		int len = strings.length;
		for (int i = 0; i < len; i++) {
			String temp = strings[i];
			for (int j = i + 1; j < len; j++) {
				String string = strings[j];
				if (string.equals(temp)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String clearUnderline(String str) {
		char[] charArr = isNull(str).toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(charArr[0]);
		boolean isClear = false;

		for(int i = 1; i < charArr.length; ++i) {
			if (charArr[i] == '_') {
				isClear = true;
			} else if (isClear && charArr[i] >= 'a' && charArr[i] <= 'z') {
				char c = (char)(charArr[i] - 32);
				sb.append(c);
				isClear = false;
			} else {
				sb.append(charArr[i]);
			}
		}

		return sb.toString();
	}


	/**
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
	 *
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) throws Exception {
		if (version1 == null || version2 == null) {
			throw new Exception("compareVersion error:illegal params.");
		}
		String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
		String[] versionArray2 = version2.split("\\.");
		int idx = 0;
		int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
		int diff = 0;
		while (idx < minLength
				&& (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
				&& (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
			++idx;
		}
		//如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
		diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
		return diff;
	}
	/**
	 * <b>功能描述: 数字版本号转换</b>
	 * @author : guqy
	 * <b>创建日期 :</b>
	 * @date 2020/5/27 14:39
	 * @param version
	 * @return java.lang.String
	 * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
	 */
	public static String transferVersion(String version) {
		int length = version.length();
		char[] chars = version.toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(chars[0]).
		append(".").append(chars[2]).
		append(".").append(chars[length -1]);
		return sb.toString();
	}




}
