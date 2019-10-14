package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stigma.PrincipalActivity
import com.example.stigma.R
import com.example.stigma.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_configuracoes.*

class ConfiguracoesActivity : AppCompatActivity() {

    var emailLogado = ""
    var idLogado = ""
    var senhaLogado = ""

    var z = ""

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
                idLogado = i.id
                senhaLogado = i.senha

            }
        }

        btn_voltar_6.setOnClickListener {
            finish()
        }

        btn_alterar.setOnClickListener {

            if (txt_editar_senha.text.toString() != senhaLogado){

                val user = FirebaseAuth.getInstance().currentUser

                user?.updatePassword(txt_editar_senha.text.toString())
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            usuarios.child(idLogado).child("nome").setValue(txt_editar_nome.text.toString())
                            usuarios.child(idLogado).child("email").setValue(txt_editar_email.text.toString())
                            usuarios.child(idLogado).child("dataNasc").setValue(txt_editar_dataNasc.text.toString())
                            usuarios.child(idLogado).child("senha").setValue(txt_editar_senha.text.toString())
                            Toast.makeText(
                                baseContext, "Alterações feitas com sucesso.",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    }

            }else{
                usuarios.child(idLogado).child("nome").setValue(txt_editar_nome.text.toString())
                usuarios.child(idLogado).child("email").setValue(txt_editar_email.text.toString())
                usuarios.child(idLogado).child("dataNasc").setValue(txt_editar_dataNasc.text.toString())
                usuarios.child(idLogado).child("senha").setValue(txt_editar_senha.text.toString())
                Toast.makeText(
                    baseContext, "Alterações feitas com sucesso.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        }

        btn_apagar_conf.setOnClickListener {

        }
    }
}
