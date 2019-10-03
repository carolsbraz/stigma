package com.example.stigma


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.projeto.appstigma.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    var emailLogado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_principal)

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList){
            if(i.email == emailLogado){
                txt_nome_logado.text = i.nome
            }
        }

        btn_tela_relato.setOnClickListener{
            val intent = Intent(this, RelatoActivity::class.java)
            startActivity(intent)
        }

       btn_tela_mensagem.setOnClickListener {
           val intent = Intent(this, MensagemActivity::class.java)
           startActivity(intent)
       }

        btn_tela_questao.setOnClickListener {
            val intent = Intent(this, QuestoesMotivadorasActivity::class.java)
            startActivity(intent)
        }

        btn_tela_desafio.setOnClickListener {
            val intent = Intent(this, DesafioActivity::class.java)
            startActivity(intent)
        }

    }
}
