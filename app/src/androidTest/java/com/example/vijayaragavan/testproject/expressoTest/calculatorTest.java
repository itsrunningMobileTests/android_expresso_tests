package com.example.vijayaragavan.testproject.expressoTest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.vijayaragavan.testproject.HomePageActivity;
import com.example.vijayaragavan.testproject.LoginActivity;
import com.example.vijayaragavan.testproject.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//import com.example.vijayaragavan.testproject.expressoTest.Page.ScreenshotActivityTestRule;
import com.example.vijayaragavan.testproject.expressoTest.Page.SpoonScreenshotAction;
import com.squareup.spoon.Spoon;

/**
 * Created by sripadmasudha on 14/03/17.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class calculatorTest  {

    @Rule
    public final ActivityTestRule<HomePageActivity> main = new ActivityTestRule(HomePageActivity.class);

    private float num1;
    private float num2;
    private float dexpected;
    private String operator;
    public HomePageActivity activity;


    @Before
    public void variableInit(){
        num1 = (float) 32;
        num2 = (float) 45.09;
        activity = main.getActivity();
        setText(num1,num2);

    }

    @Test
    public void testSum()
    {
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText(String.valueOf(num1+num2))));

    }

    @Test
    public void testSub()
    {
        num1 = (float) 23.00;
        num2 = (float) 10.05;
        setText(num1,num2);


        Spoon.screenshot(activity, "start_sub");
        onView(withId(R.id.btnSub)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText(String.valueOf(num1-num2))));
        Spoon.screenshot(activity, "End_sub");
    }

    @Test
    public void testMultiplication()
    {
        num1 = (float) 23.00;
        num2 = (float) 10.05;
        setText(num1,num2);
        dexpected =num1*num2;

        onView(withId(R.id.btnMul)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText(String.valueOf(num1*num2))));

    }


    @Test
    public void testDiv()
    {
        num1 = (float) 23.00;
        num2 = (float) 10.05;
        setText(num1,num2);
        dexpected =num1/num2;
        onView(withId(R.id.btnDiv)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText(String.valueOf(dexpected))));
    }

    public void setText(float dparam1, float dparam2)
    {

        onView(withId(R.id.etNum1)).perform(clearText());
        onView(withId(R.id.etNum1)).perform(typeText(String.valueOf(dparam1)));
        onView(withId(R.id.etNum2)).perform(clearText());
        onView(withId(R.id.etNum2)).perform(typeText(String.valueOf(dparam2)));

    }


}
