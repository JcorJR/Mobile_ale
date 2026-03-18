package br.edu.fatecpg.apphello
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var etNom: EditText? = null
    private var etIdade: EditText? = null
    private var btnMostrar: Button? = null
    private var tvMensagem: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNom = findViewById<EditText?>(R.id.etNom)
        etIdade = findViewById<EditText?>(R.id.etIdade)
        btnMostrar = findViewById<Button?>(R.id.btnMostrar)
        tvMensagem = findViewById<TextView?>(R.id.tvMensagem)

        btnMostrar!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val nome = etNom!!.getText().toString()
                val idade = etIdade!!.getText().toString()

                val mensagem = "Bem-vindo, " + nome + "! Você tem " + idade + " anos."
                tvMensagem!!.setText(mensagem)
            }
        })
    }
}