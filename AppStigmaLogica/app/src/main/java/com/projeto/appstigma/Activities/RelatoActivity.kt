package com.projeto.appstigma.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.stigma.*
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Utils.maquina
import com.projeto.appstigma.Utils.relatos
import kotlinx.android.synthetic.main.activity_relato.*
import java.text.SimpleDateFormat
import java.util.*

class RelatoActivity : AppCompatActivity() {

    var auth = FirebaseAuth.getInstance()
    var emocao = ""

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_relato)

        btn_muitofeliz.setOnClickListener {
            emocao = "muitofeliz"
        }
        btn_feliz.setOnClickListener() {
            emocao = "feliz"
        }
        btn_neutro.setOnClickListener {
            emocao = "neutro"
        }
        btn_triste.setOnClickListener {
            emocao = "triste"
        }
        btn_muitotriste.setOnClickListener {
            emocao = "muitotriste"
        }
        btn_cansado.setOnClickListener {
            emocao = "cansado"
        }

        val user = FirebaseAuth.getInstance().currentUser

        val date = getCurrentDateTime()
        val dateInString = date.toString("dd/MM/yyyy")

        btn_salvar.setOnClickListener {
            if (user != null) {
                var rel = txt_relato.text.toString()
                val relato =
                    Relato(relatos.push().key!!, rel, emocao, user.email.toString(), dateInString)
                relatos.child(relato.id).setValue(relato)
                if (ck_add_maquina.isChecked) {
                    maquina.child(relato.id).setValue(relato)
                }
                val intent = Intent(this, ListarRelatosActivity::class.java)
                startActivity(intent)
                Toast.makeText(
                    baseContext, "Relato realizado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    baseContext, "Não há usuário logado.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btn_voltar_1.setOnClickListener {
            finish()
        }

        btn_listar_relatos.setOnClickListener {
            val intent = Intent(this, ListarRelatosActivity::class.java)
            startActivity(intent)
        }
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}

