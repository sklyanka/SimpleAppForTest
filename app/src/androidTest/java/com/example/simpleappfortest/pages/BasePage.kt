package com.example.simpleappfortest.pages

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

interface BasePage {
    private fun actionOnView(viewMathcer: Matcher<View>, action: ViewAction) {
        Espresso.onView(viewMathcer).perform(action)
    }

    private fun actionCheckWithText(viewMathcer: Matcher<View>, matcherAction: Matcher<View>) {
        Espresso.onView(viewMathcer).check(matches(matcherAction))
    }

    fun Matcher<View>.click() = apply {
        actionOnView(this, ViewActions.click())
    }

    fun Matcher<View>.typeText(text: String) = apply {
        actionOnView(this, ViewActions.typeText(text))
    }

    fun Matcher<View>.checkWithText(text: String) = apply {
        actionCheckWithText(this, ViewMatchers.withText(text))
    }
}
