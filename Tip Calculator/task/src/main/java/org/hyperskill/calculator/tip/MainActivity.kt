package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var cost: EditText
    lateinit var slide: com.google.android.material.slider.Slider
    lateinit var outPut: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cost = findViewById(R.id.edit_text)
        slide = findViewById(R.id.slider)
        outPut = findViewById(R.id.text_view)
        cost.doAfterTextChanged { update() }
        slide.addOnChangeListener { _, _, _ -> update() }
    }
    private fun update() {
        outPut.text = if (cost.text.isBlank()) ""
                      else "Bill value: ${cost.text}, tip percentage: ${slide.value.toInt()}%"
    }
}