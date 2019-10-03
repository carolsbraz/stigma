package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_questoesmotivadoras.*
import kotlinx.android.synthetic.main.activity_relato.*

class QuestoesMotivadorasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoesmotivadoras)

        btn_listar_questoes.setOnClickListener {
            val intent = Intent(this, ListarQuestoesActivity::class.java)
            startActivity(intent)
        }
    }

}
