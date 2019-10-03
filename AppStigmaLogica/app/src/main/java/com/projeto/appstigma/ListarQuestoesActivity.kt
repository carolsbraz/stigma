package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_desafio.*
import kotlinx.android.synthetic.main.activity_listar_questoes.*

class ListarQuestoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_listar_questoes)

        btn_voltar_5.setOnClickListener{
            finish()
        }

    }



}
