package com.projeto.appstigma

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.ProgressBar
import androidx.appcompat.widget.SwitchCompat
import com.example.stigma.Desafio
import com.example.stigma.DesafioConcluido
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_desafios.*

class DesafioActivity : AppCompatActivity() {

    var somaValores = 0
    var jafeito = 0
    var emailLogado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_desafios)

        val desafioAdapter = DesafioAdapter(this)

        list_view_desafios.adapter = desafioAdapter


        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (r in desafiosListReverse) {
            desafioAdapter.addAll(r)
            somaValores += r.valor.toInt()
        }

        for (d in desafiosConcluidosList) {
            if (d.usuario == emailLogado) {
                jafeito += d.valor.toInt()
            }
        }

        var porcentagem = (jafeito * 100)/somaValores

        txt_pontos.text = "$porcentagem%"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            pb_desafios.setProgress(porcentagem, true)
        }

        btn_voltar_4.setOnClickListener {
            finish()

        }

    }
}


