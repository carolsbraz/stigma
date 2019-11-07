package com.projeto.appstigma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.PrincipalActivity
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_passo2.*

class Passo2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_passo2)

        btn_right_passo2.setOnClickListener {
            val intent = Intent(this, Passo1Activity::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_left_passo2.setOnClickListener {
            val intent = Intent(this, Passo3Activity::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_pular_tutorial.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}
