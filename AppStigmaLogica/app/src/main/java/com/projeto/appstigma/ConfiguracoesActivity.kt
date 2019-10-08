package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_configuracoes.*

class ConfiguracoesActivity : AppCompatActivity() {

    var emailLogado = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_configuracoes)

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {

                txt_editar_nome.setText(i.nome)
                txt_editar_dataNasc.setText(i.dataNasc)
                txt_editar_email.setText(i.email)
                txt_editar_senha.setText(i.senha)

            }
        }

        btn_voltar_6.setOnClickListener {
            finish()
        }

        btn_alterar.setOnClickListener {



        }
    }
}
