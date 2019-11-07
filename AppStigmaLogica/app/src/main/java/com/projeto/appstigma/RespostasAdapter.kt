package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.stigma.R
import com.example.stigma.Resposta

class RespostasAdapter(contexto: Context) : ArrayAdapter<Resposta>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view_respostas, parent, false)
        }

        val item = getItem(position)

        val txt_questao = v.findViewById<TextView>(R.id.txt_questao_item2)
        val txt_resposta = v.findViewById<TextView>(R.id.txt_resposta_item2)
        val txt_emocao = v.findViewById<TextView>(R.id.txt_emocao_item2)

        txt_questao.text = item?.questao.toString()
        txt_resposta.text = item?.resposta.toString()
        txt_emocao.text = item?.emocao.toString()

        return v;
    }
}