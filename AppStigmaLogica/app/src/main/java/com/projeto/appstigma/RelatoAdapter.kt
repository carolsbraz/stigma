package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.stigma.R
import com.example.stigma.Usuario

class RelatoAdapter (contexto : Context) : ArrayAdapter<Usuario>(contexto, 0){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v : View

        if(convertView != null){
            v = convertView
        }else{
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false)
        }

        val item = getItem(position)

        val txt_nome = v.findViewById<TextView>(R.id.txt_nome)
        val txt_email = v.findViewById<TextView>(R.id.txt_email)

        txt_email.text = item?.email.toString()
        txt_nome.text = item?.nome.toString()

        return v;

    }

}