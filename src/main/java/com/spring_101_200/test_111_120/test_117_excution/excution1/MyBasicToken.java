package com.spring_101_200.test_111_120.test_117_excution.excution1;

import org.aspectj.weaver.patterns.BasicToken;
import org.aspectj.weaver.patterns.Pointcut;

public class MyBasicToken {

    private String value;
    private boolean isIdentifier;
    private String literalKind;

    private int start;
    private int end;

    public static MyBasicToken makeOperator(String value, int start, int end) {
        return new MyBasicToken(value.intern(), false, null, start, end);
    }

    public static MyBasicToken makeIdentifier(String value, int start, int end) {
        return new MyBasicToken(value, true, null, start, end);
    }

    public static MyBasicToken makeLiteral(String value, String kind, int start, int end) {
        return new MyBasicToken(value, false, kind.intern(), start, end);
    }


    private MyBasicToken(String value, boolean isIdentifier, String literalKind, int start, int end) {
        this.value = value;
        this.isIdentifier = isIdentifier;
        this.literalKind = literalKind;
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }
    public String getFileName() { return "unknown"; }

    public String getString() {
        return value;
    }

    public boolean isIdentifier() {
        return isIdentifier;
    }

    public Pointcut maybeGetParsedPointcut() {
        return null;
    }



    public String toString() {
        String s;
        if (isIdentifier) s = value;
        else s = "'" + value + "'";

        return s + " " + " " + isIdentifier +" " + start + ":" + end;
    }
    public String getLiteralKind() {
        return literalKind;
    }

}
