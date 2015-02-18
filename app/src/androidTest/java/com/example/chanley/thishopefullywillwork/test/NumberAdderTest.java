package com.example.chanley.thishopefullywillwork.test;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.chanley.thishopefullywillwork.NumberAdder;

import junit.framework.TestCase;

public class NumberAdderTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    @SmallTest
    public void testNumerAdder_addTwoNumbers() {
        int result = NumberAdder.addTwoNumbers(3, 3);
        assertEquals("Test for 2+2", 4, NumberAdder.addTwoNumbers(2, 2));
        assertEquals("Test for 20+50", 70, NumberAdder.addTwoNumbers(20, 50));
        assertEquals("Test for 100+252", 352, NumberAdder.addTwoNumbers(100, 252));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
