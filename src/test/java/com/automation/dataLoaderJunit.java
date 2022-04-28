package com.automation;

import org.junit.*;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.util.*;

public class dataLoaderJunit {
      public static String[] Array_1 = {};
      public static String[] Array_2 = { "value0", "value1", "value2" };
      public static String[][] Array_3 = {};
      public static String[][] Array_4 = {
                  { "value00", "value01", "value02" },
                  { "value10", "value11", "value12" },
                  { "value20", "value21", "value22" }
      };

      public static String keyExpr1 = "\\$\\{\\_\\w+\\[(\\d+)\\]\\}";
      public static String keyExpr2 = "\\$\\{\\_\\w+\\[(\\d+)\\]\\[(\\d+)\\]\\}";

      public static String dataLoader1(String[] arrayListItem1, String keyword) {

            if (!keyword.isEmpty() && arrayListItem1.length > 0) {
                  String[] dataSet1;
                  dataSet1 = arrayListItem1;

                  Pattern pattern = Pattern.compile(keyExpr1);
                  Matcher matcher = pattern.matcher(keyword);

                  if (!matcher.matches()) {
                        System.out.print("Keyword wrong: ");
                        return keyword;
                  }

                  else if (Long.parseLong(matcher.group(1)) > arrayListItem1.length)
                  {
                        System.out.print("Value not in array! ");
                        return keyword;
                  }

                  System.out.println("Array [] is status 200");
                  System.out.print("Keyword true: ");
                  return dataSet1[(int) Long.parseLong(matcher.group(1))];

            } else {
                  System.out.println("Array [] is invaild!");
                  return null;
            }

      }

      public static String dataLoader2(String[][] arrayListItem2, String keyword) {

            if (!keyword.isEmpty() && arrayListItem2.length > 0) {
                  String[][] dataSet2 = arrayListItem2;

                  Pattern pattern = Pattern.compile(keyExpr2);

                  Matcher matcher = pattern.matcher(keyword);

                  if (!matcher.matches()) {
                        System.out.print("Keyword wrong: ");
                        return keyword;
                  }

                  else if ((Long.parseLong(matcher.group(1)) > arrayListItem2.length) || (Long.parseLong(matcher.group(2)) > arrayListItem2.length))
                  {
                        System.out.print("Value not in array! ");
                        return keyword;
                  }

                  System.out.println("Array [][] is status 200");
                  System.out.print("Keyword true: ");
                  return dataSet2[(int) Long.parseLong(matcher.group(1))][(int) Long.parseLong(matcher.group(2))];
            
            } else {
                  System.out.println("Array [][] is invaild!");
                  return null;
            }

      }
      
      @Test
      public void testCase_01() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "getDatad");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_02() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[1]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_03() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[0.1]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_04() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[4]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_05() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${getData[0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_06() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[1%]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_07() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[a]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_08() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_09() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[0][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_10() {
            String value = dataLoaderJunit.dataLoader1(Array_2, "${_getData[-1]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_11() {
            String value = dataLoaderJunit.dataLoader1(Array_1, "${_getData[0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_12() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getDatad");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_13() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[1][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_14() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[1%][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_15() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[a][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_16() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${getData[0][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_17() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[0][ ]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_18() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_19() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_GetData[0][0]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_20() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[0][0]d}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_21() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[0][4]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_22() {
            String value = dataLoaderJunit.dataLoader2(Array_4, "${_getData[-1][1]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @Test
      public void testCase_23() {
            String value = dataLoaderJunit.dataLoader2(Array_3, "${_getData[0][1]}");
            System.out.println(value);
            System.out.println("===========***===========");
      }

      @AfterClass
      public static void end_testing() {
            System.out.println("End testing");
      }
}
