package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.stigma.Desafio
import com.example.stigma.R
import com.example.stigma.Relato

class DesafioAdapter(contexto: Context) : ArrayAdapter<Desafio>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view_desafio, parent, false)
        }

        val item = getItem(position)

        val txt_titulo_desafio = v.findViewById<TextView>(R.id.txt_titulo_desafio)
        val txt_desafio = v.findViewById<TextView>(R.id.txt_desafio)


        txt_titulo_desafio.text = item?.titulo.toString()
        txt_desafio.text = item?.desafio.toString()

        return v;

    }

}