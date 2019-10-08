package com.example.stigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.AvatarActivity
import com.projeto.appstigma.Passo1Activity
import com.projeto.appstigma.usuarios
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_cadastro)
        auth = FirebaseAuth.getInstance()
        buttonCadastrar.setOnClickListener {

            val nome = txt_nome.text.toString()
            val dataNasc = txt_dataNasc.text.toString()
            val email = txt_email.text.toString()
            val senha = txt_senha.text.toString()
            val confSenha = txt_confSenha.text.toString()


            if (senha != confSenha) {
                txt_confSenha.error = "As senhas não coincidem"
                txt_senha.error = "As senhas não coincidem"
            } else {

                if (nome.isNotEmpty() && email.isNotEmpty() && dataNasc.isNotEmpty() && senha.isNotEmpty() && confSenha.isNotEmpty()) {

                    auth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = Usuario(usuarios.push().key!!, nome, email, dataNasc, senha)
                                usuarios.child(user.id).setValue(user)
                                auth.signInWithEmailAndPassword(email, senha)
                                    .addOnCompleteListener(this) { task ->
                                        if (task.isSuccessful) {
                                            val intent = Intent(this, Passo1Activity::class.java)
                                            startActivity(intent)
                                            this.finish()
                                        } else {
                                            Toast.makeText(
                                                baseContext, "Authentication failed.",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                            } else {
                                Toast.makeText(
                                    baseContext, "Falhou.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }

            }

        }

        btn_avatar.setOnClickListener {
            val intent = Intent(this, AvatarActivity::class.java)
            startActivity(intent)
        }

    }


}
