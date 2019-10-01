package com.example.stigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val referencia = FirebaseDatabase.getInstance().getReference()

    var usuarios = referencia.child("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btn_cadastro.setOnClickListener{

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }


    }

}
