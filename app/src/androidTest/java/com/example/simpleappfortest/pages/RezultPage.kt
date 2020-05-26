package com.example.simpleappfortest.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.simpleappfortest.R

val rezultPage get() = RezultPage()

class RezultPage : BasePage {
    val imtRezult = withId(R.id.textViewImt)
    val imtRezultText = withId(R.id.textViewRezult)

    fun checkCulculateImt(value: String) {
        imtRezult.checkWithText(value)
    }

    fun checkRezultText(text: String) {
        imtRezultText.checkWithText(text)
    }
}

operator fun RezultPage.invoke(function: RezultPage.() -> Unit) {
    function()
}