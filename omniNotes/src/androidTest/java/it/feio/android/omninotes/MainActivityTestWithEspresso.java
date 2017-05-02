package it.feio.android.omninotes;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestWithEspresso {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTestWithEspresso() {
        ViewInteraction viewInteraction = onView(
                allOf(withId(R.id.fab_expand_menu_button),
                        withParent(withId(R.id.fab)),
                        isDisplayed()));
        viewInteraction.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_note),
                        withParent(withId(R.id.fab)),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.detail_title),
                        withParent(allOf(withId(R.id.title_wrapper),
                                withParent(withId(R.id.detail_tile_card)))),
                        isDisplayed()));
        editText.perform(replaceText("Test "), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                withId(R.id.detail_content));
        editText2.perform(scrollTo(), replaceText("Only for UI testing with Espresso\n"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());


    }

}
