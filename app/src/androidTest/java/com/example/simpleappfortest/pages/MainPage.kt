package com.example.simpleappfortest.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.simpleappfortest.R

val mainPage get() = MainPage()

class MainPage : BasePage {
    val heightInput = withId(R.id.editTextHeight)
    val weightInput = withId(R.id.editTextWeight)
    val calculateBtn = withId(R.id.button)

    fun sendDataToCalc(heigth: Int, weight: Int) {
        heightInput.typeText(heigth.toString())
        weightInput.typeText(weight.toString())
        calculateBtn.click()
    }
}

operator fun MainPage.invoke(function: MainPage.() -> Unit) {
    function()
}