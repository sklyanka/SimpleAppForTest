package com.example.simpleappfortest

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.simpleappfortest.pages.invoke
import com.example.simpleappfortest.pages.mainPage
import com.example.simpleappfortest.pages.rezultPage
import io.qameta.allure.android.annotations.DisplayName
import io.qameta.allure.android.step
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @DisplayName("Проверка результата: Выраженный дефицит массы")
    fun calculateImt_less_16_5() {
        step("Заполнить форму") {
            mainPage.sendDataToCalc(100, 14)
        }
        rezultPage {
            step("Получен верный ИМТ") {
                checkCulculateImt("14")
            }
            step("Получен верный развернутый ответ") {
                checkRezultText("Выраженный дефицит массы")
            }
        }
    }

    @Test
    @DisplayName("Проверка результата: Недостаточная (дефицит) масса тела")
    fun calculateImt_less_18_5() {
        step("Заполнить форму") {
            mainPage.sendDataToCalc(100, 18)
        }
        rezultPage {
            step("Получен верный ИМТ") {
                checkCulculateImt("18")
            }
            step("Получен верный развернутый ответ") {
                checkRezultText("Недостаточная (дефицит) масса тела")
            }
        }
    }

    @Test
    @DisplayName("Проверка результата: Норма")
    fun calculateImt_less_25() {
        step("Заполнить форму") {
            mainPage.sendDataToCalc(102, 23)
        }
        rezultPage {
            step("Получен верный ИМТ") {
                checkCulculateImt("22.1")
            }
            step("Получен верный развернутый ответ") {
                checkRezultText("Норма")
            }
        }
    }
}
