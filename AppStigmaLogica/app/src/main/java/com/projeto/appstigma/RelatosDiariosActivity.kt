package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_relatos_diarios.*

class RelatosDiariosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatos_diarios)


        btn_voltar_3.setOnClickListener {
            finish()
        }




    }
}
