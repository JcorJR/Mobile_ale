package br.edu.fatecpg.apphello2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // usa o R do seu app

        val etCelsius = findViewById<EditText>(R.id.etCelsius)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnConverter.setOnClickListener {
            val celsiusText = etCelsius.text.toString()
            if (celsiusText.isNotEmpty()) {
                val celsius = celsiusText.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                tvResultado.text = "Resultado: $celsius °C = $fahrenheit °F"
            } else {
                tvResultado.text = "Digite uma temperatura válida!"
            }
        }
    }
}