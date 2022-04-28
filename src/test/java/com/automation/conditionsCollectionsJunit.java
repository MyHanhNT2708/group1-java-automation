package com.automation;

import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class conditionsCollectionsJunit {
      /**
       * Java Conditions Test :-)
       */
      private String contextString = "";
      private commonCollectionMethods colMed;

      public conditionsCollectionsJunit() {
            super();
            contextString = "${_onTestCaseData.[i].[j]}";
            colMed = new common();
      }

      @Before
      public void start_testing() {
            System.out.println("start_testing " + ManagementFactory.getRuntimeMXBean().getName());
      }

      @Test
      // create hashmap
      public void checkMap() {
            // Map<String, String> map = new HashMap<String, String>();

      }

      @Test
      public void testRetrieveDataFromDataSet() throws Exception {
            // create multi dimensional array
            String[][] dataSet = new String[][] {
                        { "TC1", "val1", "val2" },
                        { "TC2", "val3", "val4" },
                        { "TC3", "val5", "val6" }
            };
            contextString = String.format("${_onTestCaseData.[%i].[%j]}", 1, 2);
            int row = 0;
            int col = 0;
            // find substring in string splitted by dot
            String[] contextStringArray = contextString.split("\\.");
            // check if contextStringArray has more than 1 elements
            try
            {
                  if (contextStringArray.length > 1) {
                        // find index of array
                        row = Integer.parseInt(contextStringArray[0]);
                        // find index of array
                        col = Integer.parseInt(contextStringArray[1]);
                        String actual = colMed.getElement(dataSet, row, col);
                        Assert.assertEquals("val2", actual);
                  }
                  else  row = Integer.parseInt(contextStringArray[0]);
            } catch (Exception e) {
                  System.out.println("Invalid indexes");
            }
      }

      @AfterClass
      public static void end_testing() {
            System.out.println("end_testing");
      }
}
