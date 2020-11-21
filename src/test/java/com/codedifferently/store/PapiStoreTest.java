// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
//This is importing the Before from the org.junit package
import org.junit.Before;
//This is importing Test from the org.junit package
import org.junit.Test;

// This is a public class called PapiStoreTest
    public class PapiStoreTest {
        // this is an object papiStore
        PapiStore papiStore;
    //This is annotation runs before each test execution
        @Before
        public void setup(){
            papiStore = new PapiStore();
            //create an active tab for Jamal
            papiStore.createActiveTab("Jamal");
            //create an active tab for Victor
            papiStore.createActiveTab("Victor");
            //this key and value indicates that Jamal owes $0.0 or doesn't owe any money
            papiStore.owesPapiMoney.put("Jamal", 0.0);
            //but victor owes $7.0
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }
        //Annotation for unit testing
        @Test
        //This test is public that doesn't return anything and is called OpenStoreTest. It tests if the openStore method code is working as it should be
        public void OpenStoreTest(){
            //Given
            //reference the object papiStore by calling the method
            papiStore.openStore();

            //When
            //Expected boolean is true
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            //This will assert the actual also is true
            Assert.assertTrue(actual);
        }

        @Test

        public void allowToUseTabTestSuccess(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            //Expected boolean is true
            Boolean expected = true;
            //The boolean actual will check whether or not the name Jamal will be true
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            //This will assert whether the expected and the actual are equal
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            //False is expected
            Boolean expected = false;
            //This will check whether the name Victor is false or not and it is expected to be false
            Boolean actual = papiStore.allowToUseTab("Victor");

            // then
            //We want the boolean to assert it is false
            Assert.assertFalse(actual);
        }
}
