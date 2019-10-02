package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.stigma.R
import com.example.stigma.Relato

class RelatoAdapter(contexto: Context) : ArrayAdapter<Relato>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false)
        }

        val item = getItem(position)

        val txt_emocao = v.findViewById<TextView>(R.id.txt_emocao_item)
        val txt_relato = v.findViewById<TextView>(R.id.txt_relato_item)
        val btn_salvar = v.findViewById<Button>(R.id.btn_salvar)

        txt_emocao.text = item?.emocao.toString()
        txt_relato.text = item?.relato.toString()

        btn_salvar.setOnClickListener {
            relatos.removeValue()
        }

        return v;

    }

}