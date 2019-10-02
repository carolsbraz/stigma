package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.activity_relatos_diarios.*

class ListarRelatosActivity : AppCompatActivity() {

    var emailLogado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_relatos_diarios)

        btn_voltar_3.setOnClickListener {
            finish()
        }

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList){
            if(i.email == emailLogado){
                txt_nome_usuario.text = i.nome

            }
        }

        val relatoAdapter = RelatoAdapter(this)

        list_view_relatos.adapter = relatoAdapter

        for (r in relatosList){
            if(r.usuario == emailLogado){

                relatoAdapter.addAll(r)
            }
        }




    }
}
