package com.projeto.appstigma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.stigma.PrincipalActivity
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_passo3.*

class Passo3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_passo3)

        btn_right.setOnClickListener{
            val intent = Intent(this, Passo2Activity::class.java)
            startActivity(intent)
        }

        btn_left.setOnClickListener{
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }


    }
}
