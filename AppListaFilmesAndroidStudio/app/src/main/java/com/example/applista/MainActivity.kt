
package com.example.applista

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val lista = mutableListOf<FilmeSerie>()
    private lateinit var adapter: FilmeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome = findViewById<EditText>(R.id.etNome)
        val genero = findViewById<EditText>(R.id.etGenero)
        val botao = findViewById<Button>(R.id.btnAdicionar)
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = FilmeAdapter(lista)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        botao.setOnClickListener {
            val n = nome.text.toString()
            val g = genero.text.toString()

            if (n.isNotEmpty() && g.isNotEmpty()) {
                lista.add(FilmeSerie(n, g))
                adapter.notifyDataSetChanged()
                nome.text.clear()
                genero.text.clear()
            }
        }
    }
}
