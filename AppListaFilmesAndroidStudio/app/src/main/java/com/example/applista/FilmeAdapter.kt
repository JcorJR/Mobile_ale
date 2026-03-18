
package com.example.applista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmeAdapter(private val lista: MutableList<FilmeSerie>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.tvNome)
        val genero: TextView = view.findViewById(R.id.tvGenero)
        val check: CheckBox = view.findViewById(R.id.checkAssistido)
        val nota: EditText = view.findViewById(R.id.etNota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = lista[position]

        holder.nome.text = item.nome
        holder.genero.text = item.genero

        holder.check.setOnCheckedChangeListener(null)
        holder.check.isChecked = item.assistido

        holder.nota.isEnabled = item.assistido
        holder.nota.setText(item.nota?.toString() ?: "")

        holder.check.setOnCheckedChangeListener { _, checked ->
            item.assistido = checked
            holder.nota.isEnabled = checked
        }
    }
}
