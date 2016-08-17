package com.android.sample.espressouitestsample.mainscreen;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android.sample.espressouitestsample.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Test for the MainActivity screen
 *
 * todo 3 Android Instrumentation tests are located in the app/src/androidTest/java folder and this is the location where you will be writing your tests.
 *
 * todo 4 Espresso tests are written based on what user might do while interacting with your app. Basically, you:

 Locate the desired UI element
 Interact with the UI element or check its state.

 * todo 5 Espresso tests are composed of three major components which are:

 ViewMatchers: These are collection of objects used to find the desired view in the current view hierarchy.
 They are passed to the onView method to locate and return the desired UI element.

 ViewActions: They are used to perform actions such click on views. They are passed to the ViewInteraction.perform() method.

 ViewAssertions: They are used to assert the state of the currently selected view.
 They can be passed to the ViewInteraction.check() method.

 onView(withId(R.id.my_view))            // withId(R.id.my_view) - ViewMatcher
 .perform(click())                  // click() - ViewAction
 .check(matches(isDisplayed()));   //matches(isDisplayed()) - ViewAssertion

 todo 6 To ensure that espresso works as expected on your test device or emulator, turn off animations on your device.
 Window animation scale
 Transition animation scale
 Animator duration scale
 */

/**
 * todo 7 man hình này gồm 2 nút : sign up và sign in
 *
 * todo 8: bây giờ test that the SignUp screen shows up when the SignUp button is clicked.
 *
 * todo 9:  The first thing to notice here are the annotations:
 @RunWith(AndroidJUnit4.class): Tags the class as an Android JUnit4 class. Espresso unit test should be written as a JUnit 4 test class.

 @LargeTest: Qualifies a test to run in >2s execution time, makes use of all platform resources, including external communications. Other test qualifiers are @SmallTest and @MediumTest.

 @Rule: ActivityTestRule and ServiceTestRule are JUnit rules part of the Android Testing Support Library and they provide more flexibility and reduce the boilerplate code required in tests.
 These rules provides functional testing of a single activity or service respectively.

 @Test: Each functionality to be tested must be annotated with this. The activity under test will be launched before each of the test annotated with @Test.
 *
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenTest {
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule = new
            ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * todo  - To test that the Signup screen shows up when the Signup button is clicked, we do the following:
     Locate the Signup button using the withId ViewMatcher.
     Perform a click() action on the button.
     Assert that the Signup screen is displayed.
     */
    @Test
    public void clickSignUpButton_opensSignUpScreen() {
        /**
         * todo : withId(int id): return Matcher<View>:  attempts to look up resource name of the given id and use an R.id.myView style description with describeTo.
         * todo : onView(Matcher<View> viewMatcher):  return ViewInteraction - Creates a ViewInteraction for a given view.
         * todo : perform(ViewAction... viewActions): return ViewInteraction - method này nằm trong class ViewInteraction cho nền nhờ 2 cái return đằng trước ta được 1 obj ViewInteraction gọi method này
         *
         * todo: click - là 1 ViewActions - Returns an action that clicks the view.
         * -> tổng hợp lại đoạn method sau: kiếm matcher với id là button_sign_up, trở thành ViewInteraction,
         * và view đó làm hành động là click
         */
        //click on the sign up button
        // withId là kiem VIew tương ứng với id, còn onVIew thì chuyển thành View để ta sử dụng (vd ta gán hành động ) bằng click()
        // TODO: 8/15/16 11 kiểm tra nhấn nút
        onView(withId(R.id.button_sign_up))
                .perform(click());

        // todo - lúc này sẽ qua screen mới

        // TODO: 8/15/16 12 kiểm tra khi nhấn nút, nó phải hiện màn hình sign up
        //check if the sign up screen is displayed by asserting that the first name edittext is displayed

        /**
         * todo - check(): nằm trong class ViewInteraction, check(ViewAssertion viewAssert)
         * Checks the given ViewAssertion on the the view selected by the current view matcher.
         *
         * todo: ViewAssertion là class xử lý state của view
         * todo: matches(Matcher<? super View> viewMatcher): return ViewAssertion
         * Returns a generic ViewAssertion that asserts that a view exists in the view hierarchy
         * and is matched by the given view matcher.
         *
         * isDescendantOfA: Returns a matcher that matches Views based on the given ancestor type.
        * tức là return tất cả matchers là con của layout_sign_up
         *
         * allOf() methods to combine multiple matchers
         *
         *
         *
         * dầu tiên là isDisplayed() return matcher dang display trong screen này -> theo app của ta thì có 4 cái
         * isDescendantOfA() là return matcher là con của viewgroup có id là ... -> cũng 4 cái
         *
         * allof: kết hợp 2 cái matcher trên ta được 4 cái view
         *
         * check match: kiểm tra cái view first name có tồn tại trong 4 cái view ko ....
         *
         */

        // tức là kiểm tra ô first name có đang nằm trong tổng cái view hiện tại đang display ko
        onView(withId(R.id.edit_text_first_name))
                // isDisplayed: Returns a matcher that matches Views that are currently displayed on the screen to the user.
                .check(matches(allOf(isDescendantOfA(withId(R.id.layout_sign_up)), isDisplayed())));
    }

    @Test
    public void clickLoginButton_openLoginScreen() {
        //locate and click on the login button
        onView(withId(R.id.button_login)).perform(click());

        //check that the login screen is displayed
        onView(withId(R.id.edit_text_email)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_login)), isDisplayed())));
    }
}
