package com.example.stigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.ConfiguracoesActivity
import com.projeto.appstigma.EsqueciSenha
import com.projeto.appstigma.usuariosList

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var auth = FirebaseAuth.getInstance()

    var emailLogado = ""
    var avatar : String? = ""
    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {

            var email = username.text.toString()
            var senha = password.text.toString()

            if(email.isNotEmpty() && senha.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, PrincipalActivity::class.java)
                            startActivity(intent)
                            this.finish()
                        } else {

                            Toast.makeText(
                                baseContext, "Seus dados estão incorretos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }else{
                username.error = if (username.text.isEmpty()) "Preencha o campo" else null
                password.error = if (password.text.isEmpty()) "Preencha o campo" else null
            }
        }

        btn_esqueceu_senha.setOnClickListener{
            val intent = Intent(this, EsqueciSenha::class.java)
            startActivity(intent)
        }


    }


}
