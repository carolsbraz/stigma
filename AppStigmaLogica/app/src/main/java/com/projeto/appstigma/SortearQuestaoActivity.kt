package com.projeto.appstigma

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_mensagem.*
import kotlinx.android.synthetic.main.activity_mensagem.btn_voltar_2
import kotlinx.android.synthetic.main.activity_sortear_questao.*

class SortearQuestaoActivity : AppCompatActivity() {

    val context: Context = this

    var emocao = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_sortear_questao)

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

        btn_abrirQuestao.setOnClickListener {

            val intent = Intent(this, QuestoesMotivadorasActivity::class.java)
            startActivity(intent)

        }

        btn_voltar_2.setOnClickListener {
            finish()
        }
    }
}
