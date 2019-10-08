package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R

class ConfiguracoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_configuracoes)
    }
}
