package com.example.stigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Activities.AvatarActivity
import com.projeto.appstigma.Activities.Passo1Activity
import com.projeto.appstigma.Utils.usuarios
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var avatar2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_cadastro)
        auth = FirebaseAuth.getInstance()

        val extras = intent.extras

        if (extras != null) {
            avatar2 = extras.getString("avatar").toString()
            if (avatar2 == "avatar_boy1") {
                btn_avatar.setBackgroundResource(R.drawable.boy1)
            }
            if (avatar2 == "avatar_boy2") {
                btn_avatar.setBackgroundResource(R.drawable.boy2)
            }
            if (avatar2 == "avatar_boy3") {
                btn_avatar.setBackgroundResource(R.drawable.boy3)
            }
            if (avatar2 == "avatar_boy4") {
                btn_avatar.setBackgroundResource(R.drawable.boy4)
            }
            if (avatar2 == "avatar_boy5") {
                btn_avatar.setBackgroundResource(R.drawable.boy5)
            }
            if (avatar2 == "avatar_boy6") {
                btn_avatar.setBackgroundResource(R.drawable.boy6)
            }
            if (avatar2 == "avatar_boy7") {
                btn_avatar.setBackgroundResource(R.drawable.boy7)
            }
            if (avatar2 == "avatar_boy8") {
                btn_avatar.setBackgroundResource(R.drawable.boy8)
            }
            if (avatar2 == "avatar_boy9") {
                btn_avatar.setBackgroundResource(R.drawable.boy9)
            }
            if (avatar2 == "avatar_girl1") {
                btn_avatar.setBackgroundResource(R.drawable.girl1)
            }
            if (avatar2 == "avatar_girl2") {
                btn_avatar.setBackgroundResource(R.drawable.girl2)
            }
            if (avatar2 == "avatar_girl3") {
                btn_avatar.setBackgroundResource(R.drawable.girl3)
            }
            if (avatar2 == "avatar_girl4") {
                btn_avatar.setBackgroundResource(R.drawable.girl4)
            }
            if (avatar2 == "avatar_girl5") {
                btn_avatar.setBackgroundResource(R.drawable.girl5)
            }
            if (avatar2 == "avatar_girl6") {
                btn_avatar.setBackgroundResource(R.drawable.girl6)
            }
        }

        buttonCadastrar.setOnClickListener {

            val nome = txt_nome.text.toString()
            val dataNasc = txt_dataNasc.text.toString()
            val email = txt_email.text.toString()
            val senha = txt_senha.text.toString()
            val confSenha = txt_confSenha.text.toString()
            val extras = intent.extras
            var avatar = extras?.getString("avatar")

            if (senha != confSenha) {
                txt_confSenha.error = "As senhas não coincidem"
                txt_senha.error = "As senhas não coincidem"
            } else {
                if (nome.isNotEmpty() && email.isNotEmpty() && dataNasc.isNotEmpty() && senha.isNotEmpty() && confSenha.isNotEmpty()) {

                    auth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val date = getCurrentDateTime()
                                val dateInString = date.toString("MM/dd")
                                val user =
                                    Usuario(
                                        usuarios.push().key!!,
                                        nome,
                                        email,
                                        dataNasc,
                                        senha,
                                        avatar,
                                        dateInString
                                    )
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
                } else {
                    txt_dataNasc.error =
                        if (txt_dataNasc.text.isEmpty()) "Preencha o campo" else null
                    txt_senha.error = if (txt_senha.text.isEmpty()) "Preencha o campo" else null
                    txt_email.error = if (txt_email.text.isEmpty()) "Preencha o campo" else null
                    txt_nome.error = if (txt_nome.text.isEmpty()) "Preencha o campo" else null
                    txt_confSenha.error =
                        if (txt_confSenha.text.isEmpty()) "Preencha o campo" else null
                }
            }
        }

        btn_avatar.setOnClickListener {
            val intent = Intent(this, AvatarActivity::class.java)
            startActivity(intent)
        }
    }
}
