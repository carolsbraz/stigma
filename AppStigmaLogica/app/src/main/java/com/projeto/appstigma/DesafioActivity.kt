package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_desafios.*

class DesafioActivity : AppCompatActivity() {

    var somaValores = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_desafios)

        val desafioAdapter = DesafioAdapter(this)

        list_view_desafios.adapter = desafioAdapter

        for (r in desafiosListReverse) {
            desafioAdapter.addAll(r)
            somaValores += r.valor.toInt()
        }

        var vs = somaValores.toString()

        txt_pontos.text = "0/$somaValores"

        btn_voltar_4.setOnClickListener {
            finish()
        }


    }
}
