package com.spring_101_200.test_111_120.test_113_conversion.spel;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * http://itmyhome.com/spring/expressions.html
 */
public class TestSpel {


    @Test
    public void test11_math_2() {
        ExpressionParser parser = new SpelExpressionParser();
        int two = parser.parseExpression("2 + 3  * 4").getValue(Integer.class); // 2
        System.out.println(two);
    }


    @Test
    public void test11_math_1() {
        ExpressionParser parser = new SpelExpressionParser();
        int two = parser.parseExpression("(21 + 3) * 4").getValue(Integer.class); // 2
        System.out.println(two);
    }

    @Test
    public void test1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }


    @Test
    public void test1_1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("toUpload('Hello World')");
        String message = (String) exp.getValue(new StringTest2());
        System.out.println(message);
    }

    @Test
    public void test2() {
        ExpressionParser parser = new SpelExpressionParser();
        String randomPhrase = parser.parseExpression(
                "random number is #{T(java.lang.Math).round(30d)} ",
                new TemplateParserContext()).getValue(String.class);
        System.out.println(randomPhrase);

    }


    @Test
    public void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        tesla.setPlaceOfBirth(new PlaceOfBirth("Smiljan"));
        StandardEvaluationContext context = new StandardEvaluationContext(tesla);
        String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
        System.out.println(city); // Smiljan
        tesla.setPlaceOfBirth(null);
        city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
        System.out.println(city); // null - does not throw NullPointerException!!!
    }


    @Test
    public void test19_bean_ref_1() {
        ExpressionParser parser = new SpelExpressionParser();
        Tesla tesla = new Tesla();
        StandardEvaluationContext societyContext = new StandardEvaluationContext(tesla);
        parser.parseExpression("Name").setValue(societyContext, "IEEE");
        societyContext.setVariable("queryName", "Nikola Tesla");
        String expression = "isMember(#queryName)? #queryName + ' is a member of the ' " +
                "+ Name + ' Society' : #queryName + ' is not a member of the ' + Name + ' Society'";
        String queryResultString = parser.parseExpression(expression)
                .getValue(societyContext, String.class);
        System.out.println(queryResultString);
    }


    @Test
    public void test4() {
        ExpressionParser parser = new SpelExpressionParser();

        String name = parser.parseExpression("null?:'Unknown'").getValue(String.class);

        System.out.println(name); // Unknown
    }


    @Test
    public void test5() {
        ExpressionParser parser = new SpelExpressionParser();

// invokes getBytes().length
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);
    }

    @Test
    public void test6() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
    }


    @Test
    public void test7() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        System.out.println(name);


        Expression exp1 = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp1.getValue(context, Boolean.class); // evaluates to true
        System.out.println(result);
    }

    class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }

    @Test
    public void test8() {
        Simple simple = new Simple();

        simple.booleanList.add(true);

        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        ExpressionParser parser = new SpelExpressionParser();
// false is passed in here as a string. SpEL and the conversion service will
// correctly recognize that it needs to be a Boolean and convert it
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");

// b will be false
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);
    }

    class Demo {
        public List<String> list = new ArrayList<>();


        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    @Test
    public void test9() {
// - auto null reference initialization
// - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);

        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[2]");

        Demo demo = new Demo();

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        demo.setList(a);

        Object o = expression.getValue(demo);
        System.out.println(o);

// demo.list will now be a real collection of 4 entries
// Each entry is a new empty String
    }


    @Test
    public void test10_1() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        System.out.println(numbers);


    }

    @Test
    public void test10() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        System.out.println(numbers);

        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
        System.out.println(listOfLists);

        // evaluates to a Java map containing the two entries
        Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(context);

        System.out.println(JSON.toJSONString(inventorInfo));
        Map mapOfMaps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);
        System.out.println(JSON.toJSONString(mapOfMaps));

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
        System.out.println(Arrays.toString(numbers1));

// Array with initializer
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        System.out.println(Arrays.toString(numbers2));

// Multi dimensional array
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
        for (int i = 0; i < numbers3.length; i++) {
            System.out.println(Arrays.toString(numbers3[i]));
        }


        // string literal, evaluates to "bc"
        String c = parser.parseExpression("'abc'.substring(2, 3)").getValue(String.class);

        System.out.println(c);
// evaluates to true
        boolean isMember = parser.parseExpression("isMember('Mihajlo Pupin')").getValue(
                new StringTest(), Boolean.class);
        System.out.println(isMember);


        // evaluates to true
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        System.out.println(trueValue);

// evaluates to false
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        System.out.println(falseValue);

// evaluates to true
        //     boolean trueValue = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);

    }

    @Test

    public void test11_and() {
        ExpressionParser parser = new SpelExpressionParser();
        // -- AND --

// evaluates to false
        boolean falseValue = parser.parseExpression("true and false").getValue(Boolean.class);

// evaluates to true
        String expression = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        boolean trueValue = parser.parseExpression(expression).getValue(new StringTest(), Boolean.class);

        System.out.println(trueValue);
    }

    @Test

    public void test11_or() {
        ExpressionParser parser = new SpelExpressionParser();
// -- OR --

// evaluates to true
        boolean trueValue1 = parser.parseExpression("true or false").getValue(Boolean.class);

// evaluates to true
        String expression = "!isMember('Nikola Tesla') or isMember('Albert Einstein')";
        boolean trueValue = parser.parseExpression(expression).getValue(new StringTest(), Boolean.class);
        System.out.println(trueValue);

    }

    @Test

    public void test11_not() {
        // -- NOT --
        ExpressionParser parser = new SpelExpressionParser();
        // evaluates to false
        boolean falseValue1 = parser.parseExpression("!true").getValue(Boolean.class);

        // -- AND and NOT --
        String expression = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        boolean falseValue = parser.parseExpression(expression).getValue(new StringTest(), Boolean.class);
        System.out.println(falseValue);
    }


    @Test

    public void test11_math_3() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int position = 0;
        System.out.println(list.get(position++));
        System.out.println(list.get(position));
        System.out.println(position);
    }


    @Test

    public void test11_math() {
        // -- NOT --
        ExpressionParser parser = new SpelExpressionParser();

        String testString = parser.parseExpression(
                "'test' + ' ' + 'string'").getValue(String.class); // test string

// Subtraction
        int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4

        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000

// Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6

        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); // 24.0

// Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2

        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0

// Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3

        int one2 = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1

// Operator precedence
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
    }


    @Test
    public void test12() {
        Inventor inventor = new Inventor();
        StandardEvaluationContext inventorContext = new StandardEvaluationContext(inventor);
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("Name").setValue(inventorContext, "Alexander Seovic2");
        System.out.println(inventor.getName());
// alternatively
        String aleks = parser.parseExpression(
                "Name = 'Alexandar Seovic'").getValue(inventorContext, String.class);
        System.out.println(inventor.getName());

    }


    @Test
    public void test13_type() {
        ExpressionParser parser = new SpelExpressionParser();
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);

        Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);

        boolean trueValue = parser.parseExpression(
                "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class);
        System.out.println(dateClass);
    }

    @Test
    public void test14_constructor() {
        ExpressionParser p = new SpelExpressionParser();
        Inventor einstein = p.parseExpression(
                "new com.spring_101_200.test_111_120.test_113_conversion.spel.Inventor('Albert Einstein', 'German')")
                .getValue(Inventor.class);

        System.out.println(JSON.toJSONString(einstein));
    }

    @Test
    public void test15_variable() {
        ExpressionParser parser = new SpelExpressionParser();
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        StandardEvaluationContext context = new StandardEvaluationContext(tesla);
        context.setVariable("newName", "Mike Tesla");

        parser.parseExpression("Name = #newName").getValue(context);

        System.out.println(tesla.getName()); // "Mike Tesla"

    }

    @Test
    public void test16_this_root() {
        // create an array of integers
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

// create parser and set variable primes as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("primes", primes);

// all prime numbers > 10 from the list (using selection ?{...})
// evaluates to [11, 13, 17]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);
        System.out.println(primesGreaterThanTen);

    }


    @Test
    public void test17_method() throws Exception {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        context.registerFunction("reverseString",
                StringTest.class.getDeclaredMethod("reverseString", new Class[]{String.class}));

        String helloWorldReversed = parser.parseExpression(
                "#reverseString('hello')").getValue(context, String.class);
        System.out.println(helloWorldReversed);
    }

    @Test
    public void test18_bean_ref() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new MyBeanResolver());

// This will end up calling resolve(context,"foo") on MyBeanResolver during evaluation
        Object bean = parser.parseExpression("@foo").getValue(context);
        System.out.println(bean);
    }


    @Test
    public void test19_bean_ref() {
        ExpressionParser parser = new SpelExpressionParser();
        String falseString = parser.parseExpression(
                "false ? 'trueExp' : 'falseExp'").getValue(String.class);
        System.out.println(falseString);
    }


    @Test
    public void test20_Elvis() {

        ExpressionParser parser = new SpelExpressionParser();

        String name = parser.parseExpression("null?:'Unknown'").getValue(String.class);

        System.out.println(name); // Unknown

    }

    @Test
    public void test20_Elvis_1() {
        ExpressionParser parser = new SpelExpressionParser();

        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        StandardEvaluationContext context = new StandardEvaluationContext(tesla);

        String name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, String.class);

        System.out.println(name); // Nikola Tesla

        tesla.setName(null);

        name = parser.parseExpression("Name?:'Elvis Presley'").getValue(context, String.class);

        System.out.println(name); // Elvis Presley

    }


    @Test
    public void test21_anquandaohang() {
        ExpressionParser parser = new SpelExpressionParser();

        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");
        tesla.setPlaceOfBirth(new PlaceOfBirth("Smiljan"));

        StandardEvaluationContext context = new StandardEvaluationContext(tesla);

        String city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);
        System.out.println(city); // Smiljan

        tesla.setPlaceOfBirth(null);

        city = parser.parseExpression("PlaceOfBirth?.City").getValue(context, String.class);

        System.out.println(city); // null - does not throw NullPointerException!!!
    }


}
