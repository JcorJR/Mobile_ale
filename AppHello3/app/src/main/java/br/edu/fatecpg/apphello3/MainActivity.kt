package br.edu.fatecpg.apphello3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTensao = findViewById<EditText>(R.id.etTensao)
        val etResistencia = findViewById<EditText>(R.id.etResistencia)
        val etCorrente = findViewById<EditText>(R.id.etCorrente)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val tensaoText = etTensao.text.toString()
            val resistenciaText = etResistencia.text.toString()
            val correnteText = etCorrente.text.toString()

            var resultado = ""

            // Caso receba tensão e resistência → calcular corrente
            if (tensaoText.isNotEmpty() && resistenciaText.isNotEmpty() && correnteText.isEmpty()) {
                val v = tensaoText.toDouble()
                val r = resistenciaText.toDouble()
                val i = v / r
                resultado = "Corrente calculada: $i A"
            }
            // Caso receba tensão e corrente → calcular resistência
            else if (tensaoText.isNotEmpty() && correnteText.isNotEmpty() && resistenciaText.isEmpty()) {
                val v = tensaoText.toDouble()
                val i = correnteText.toDouble()
                val r = v / i
                resultado = "Resistência calculada: $r Ω"
            }
            // Caso receba resistência e corrente → calcular tensão
            else if (resistenciaText.isNotEmpty() && correnteText.isNotEmpty() && tensaoText.isEmpty()) {
                val r = resistenciaText.toDouble()
                val i = correnteText.toDouble()
                val v = r * i
                resultado = "Tensão calculada: $v V"
            } else {
                resultado = "Preencha apenas dois campos para calcular o terceiro."
            }

            tvResultado.text = resultado
        }
    }
}