package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stigma.R
import com.example.stigma.Relato
import com.example.stigma.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_relato.*

class RelatoActivity : AppCompatActivity() {

    var auth = FirebaseAuth.getInstance()
    var emocao = ""
    var usuLogado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_relato)

        btn_muitofeliz.setOnClickListener {
            emocao = "muitofeliz"
        }
        btn_feliz.setOnClickListener {
            emocao = "feliz"
        }
        btn_neutro.setOnClickListener {
            emocao = "neutro"
        }
        btn_triste.setOnClickListener {
            emocao = "triste"
        }
        btn_muitotriste.setOnClickListener {
            emocao = "muitotriste"
        }
        btn_cansado.setOnClickListener {
            emocao = "cansado"
        }

        val user = FirebaseAuth.getInstance().currentUser

        btn_salvar.setOnClickListener {

            if (user != null) {

                var rel = txt_relato.text.toString()
                val relato = Relato(rel, emocao,user.email.toString())
                relatos.push().setValue(relato)

                emocao = ""
                txt_relato.text.clear()

                Toast.makeText(
                    baseContext, "Relato realizado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    baseContext, "Não há usuário logado.",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

        btn_voltar_1.setOnClickListener{
            finish()
        }
    }
}
