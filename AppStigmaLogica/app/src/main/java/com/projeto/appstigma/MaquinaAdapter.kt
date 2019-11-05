package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.stigma.MaquinaDoTempo
import com.example.stigma.R
import com.example.stigma.Relato

class MaquinaAdapter(contexto: Context) : ArrayAdapter<MaquinaDoTempo>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view_maquina, parent, false)
        }

        val item = getItem(position)

        val txt_data = v.findViewById<TextView>(R.id.txt_data_item)
        val txt_relato = v.findViewById<TextView>(R.id.txt_relato_item)

        txt_data.text = item?.data.toString()
        txt_relato.text = item?.relato.toString()

        return v;

    }

}