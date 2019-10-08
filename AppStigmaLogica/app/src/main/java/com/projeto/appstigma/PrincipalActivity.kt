package com.example.stigma


import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.projeto.appstigma.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.custom_modal_sair.view.*

class PrincipalActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    val context: Context = this

    var emailLogado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_principal)

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                txt_nome_logado.text = i.nome
            }
        }

        btn_tela_relato.setOnClickListener {
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

        btn_config.setOnClickListener {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }

        btn_sair.setOnClickListener {
            val dialog: Dialog = Dialog(context)
            val view = layoutInflater.inflate(R.layout.custom_modal_sair, null)
            dialog.setContentView(view)
            dialog.show()

            view.btn_sair_modal.setOnClickListener {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            view.btn_cancelar_modal.setOnClickListener {
                dialog.dismiss()
            }
        }

        btn_config.setOnClickListener {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }


    }
}
