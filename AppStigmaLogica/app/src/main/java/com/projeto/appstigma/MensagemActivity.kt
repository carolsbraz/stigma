package com.projeto.appstigma

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_mensagem.*

class MensagemActivity : AppCompatActivity() {

    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_mensagem)

        btn_abrirMensagem.setOnClickListener{
            val dialog: Dialog = Dialog(context)
            val view = layoutInflater.inflate(R.layout.custom_modal_mensagem, null)
            dialog.setContentView(view)
            dialog.show()
        }

        btn_voltar_2.setOnClickListener {
            finish()
        }
    }
}
