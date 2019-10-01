package com.example.stigma


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.projeto.appstigma.RelatoActivity
import com.projeto.appstigma.usuariosList
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

            var intent = Intent(this, RelatoActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}
