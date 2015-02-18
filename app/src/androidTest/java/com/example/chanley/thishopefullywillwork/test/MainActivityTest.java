package com.example.chanley.thishopefullywillwork.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chanley.thishopefullywillwork.MainActivity;
import com.example.chanley.thishopefullywillwork.R;

import java.util.Random;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    TextView numberOneLabel, numberTwoLavel, resultTextView, resultLabelTextView;
    EditText firstNumberEditText, secondNumberEditText;
    Button addNumbers;
    View mainActivityView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    /*
    * The setUp() method is run at the beginning of every test. It
    * sets up the testing in environment each time.
    * */

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        activity = getActivity();
        mainActivityView = activity.getWindow().getDecorView();
        //TextViews
        numberOneLabel = (TextView) activity.findViewById(R.id.numberOneLabel);
        numberTwoLavel = (TextView) activity.findViewById(R.id.numberTwoLabel);
        resultTextView = (TextView) activity.findViewById(R.id.resultTextView);
        resultLabelTextView = (TextView) activity.findViewById(R.id.resultLabelTextView);
        //EditTexts
        firstNumberEditText = (EditText) activity.findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) activity.findViewById(R.id.secondNumberEditText);
        //Buttons
        addNumbers = (Button) activity.findViewById(R.id.addNumbers);
    }

    /*
    * testPreConditions is run to ensure all views are on the screen.
    * It is best practise to do this as if this test fails you know
    * that none of your other tests can be vaild. It also ensures you
    * don't have to check the asset each time you create a method
    * */

     @SmallTest
    public void testPreConditions() {
        assertNotNull(numberOneLabel);
        assertNotNull(numberTwoLavel);
        assertNotNull(resultTextView);
        assertNotNull(resultLabelTextView);
        assertNotNull(firstNumberEditText);
        assertNotNull(secondNumberEditText);
        assertNotNull(addNumbers);

    }

    /*There are three types of tests. you have a
    *   SmallTest - takes under .5 of a second
    *   MediumTest - takes between .5 of a second and 2 seconds
    *   LargeTest - takes over 2 seconds
    *
    *   It is best practise to label each of your test with this annotation
    *   above the method. This can be used to run states and allows you to have
    *   have a performance testing in the future.
    * */

    @SmallTest
    public void testTextViewLabel_numberOneLabel() {
        final String expected = "Not First Number";
        final String actual = numberOneLabel.getText().toString();
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testTextViewLabel_numberTwoLavel() {
        final String expected = activity.getString(R.string.secondNumberLabel);
        final String actual = numberTwoLavel.getText().toString();
        assertEquals(expected, actual);
    }

    @SmallTest
    public void testTextViewLabel_resultTextView() {
        final String expected = activity.getString(R.string.result);
        final String actual = resultTextView.getText().toString();
        assertEquals(expected, actual);

    }

    @SmallTest
    public void testTextViewLabel_resultLabelTextView() {
        final String expected = activity.getString(R.string.resultLabel);
        final String actual = resultLabelTextView.getText().toString();
        assertEquals(expected, actual);
    }
    //Button Test
    @SmallTest
    public void testButtonLabel() {
        final String expected = activity.getString(R.string.addNumberButton);
        final String actual = addNumbers.getText().toString();
        assertEquals(expected, actual);
    }

    @SmallTest
    public void test_UI_numberOneLabelParams() {
        ViewAsserts.assertOnScreen(mainActivityView, numberOneLabel);
        final ViewGroup.LayoutParams layoutParams = numberOneLabel.getLayoutParams();
        assertNotNull(layoutParams);
        assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @MediumTest
    public void test_UI_addNumbersParams() {
        ViewAsserts.assertOnScreen(mainActivityView, addNumbers);
        final ViewGroup.LayoutParams layoutParams = addNumbers.getLayoutParams();
        assertNotNull(layoutParams);

        assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @LargeTest
    public void testActivityFunctionally() {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                firstNumberEditText.requestFocus();
            }
        });
        Random randomGenerator = new Random();
        int firstRandomNumber = randomGenerator.nextInt(1000);
        int secondRandomNumber = randomGenerator.nextInt(1000);
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync(String.valueOf(firstRandomNumber));
        getInstrumentation().waitForIdleSync();

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                secondNumberEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync(String.valueOf(secondRandomNumber));
        getInstrumentation().waitForIdleSync();
        TouchUtils.clickView(this, addNumbers);
        String expected = String.valueOf(firstRandomNumber + secondRandomNumber);
        String actual = resultTextView.getText().toString();
        assertEquals(expected, actual);


    }
}