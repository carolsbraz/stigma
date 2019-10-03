package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_desafio.*

class DesafioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_desafio)


        btn_voltar_4.setOnClickListener{
          finish()
        }


    }
}
