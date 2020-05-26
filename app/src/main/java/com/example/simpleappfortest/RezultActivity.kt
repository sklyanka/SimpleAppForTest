package com.example.simpleappfortest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rezult.*
import java.text.DecimalFormat


class RezultActivity : AppCompatActivity() {
    companion object {
        const val HEIGHT = "height"
        const val WEIGHT = "weight"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rezult)

        val height = intent.getIntExtra("height", 160).toDouble()
        val weight = intent.getIntExtra("weight", 60).toDouble()

        val imt = weight / (height * height) * 10000
        textViewImt.text = DecimalFormat("#.#").format(imt)

        textViewRezult.text = when {
            imt < 16.5 -> "Выраженный дефицит массы"
            imt >= 16.5 && imt < 18.5 -> "Недостаточная (дефицит) масса тела"
            imt >= 18.5 && imt < 25 -> "Норма"
            imt >= 25 && imt < 30 -> "Избыточная масса тела (предожирение)"
            imt >= 30 && imt < 35 -> "Ожирение первой степени"
            imt >= 35 && imt < 40 -> "Ожирение второй степени"
            imt >= 40 -> "Ожирение третьей степени (морбидное)"
            else -> "Упс, я запутался"
        }
    }

    fun back(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
