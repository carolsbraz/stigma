package com.projeto.appstigma.Utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.stigma.LoginActivity
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth

class EsqueciSenha : AppCompatActivity() {

    private val TAG = "EsqueciSenha"

    private var userName: EditText? = null
    private var btn_esqueci_senha: ImageButton? = null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_esqueci_senha)
        iniciar()
    }

    private fun iniciar() {
        userName = findViewById(R.id.username) as EditText
        btn_esqueci_senha = findViewById(R.id.btn_esqueci_senha) as ImageButton
        mAuth = FirebaseAuth.getInstance()
        btn_esqueci_senha!!.setOnClickListener { sendPasswordEmail() }
    }

    private fun sendPasswordEmail() {
        val email = userName?.text.toString()
        if (!TextUtils.isEmpty(email)) {
            mAuth!!
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val message = "email enviado"
                        Log.d(TAG, message)
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        updateUI()
                    } else {
                        Log.w(TAG, task.exception!!.message)
                        Toast.makeText(
                            this,
                            "nenhum usuario encontrado com esse email",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
        } else {
            Toast.makeText(this, "entre com um email valido", Toast.LENGTH_SHORT)
        }
    }

    private fun updateUI() {
        val intent = Intent(this@EsqueciSenha, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
