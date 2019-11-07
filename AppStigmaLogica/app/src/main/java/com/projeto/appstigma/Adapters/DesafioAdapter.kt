package com.projeto.appstigma.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import com.example.stigma.Desafio
import com.example.stigma.DesafioConcluido
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Utils.desafiosConcluido
import com.projeto.appstigma.Utils.desafiosConcluidosList

class DesafioAdapter(contexto: Context) : ArrayAdapter<Desafio>(contexto, 0) {

    var emailLogado = ""

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
        val txt_valor = v.findViewById<TextView>(R.id.txt_valor)
        val st_concluido = v.findViewById<SwitchCompat>(R.id.st_concluido)

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (d in desafiosConcluidosList) {
            if (d.usuario == emailLogado && item?.desafio.toString() == d.desafio) {
                st_concluido.isChecked = true
                st_concluido.isClickable = false
            }
        }

        st_concluido.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (st_concluido.isChecked()) {
                val desafio =
                    DesafioConcluido(item?.desafio.toString(), emailLogado, item?.valor.toString())
                desafiosConcluido.push().setValue(desafio)
                st_concluido.isClickable = false
            } else {
                st_concluido.isChecked = false
                st_concluido.isClickable = true
            }
        })

        val x = item?.valor.toString()

        txt_titulo_desafio.text = item?.titulo.toString()
        txt_desafio.text = item?.desafio.toString()
        txt_valor.text = "Complete e consiga: $x pontos"

        return v;
    }
}