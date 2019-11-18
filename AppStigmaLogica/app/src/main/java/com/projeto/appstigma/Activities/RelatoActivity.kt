package com.projeto.appstigma.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import com.example.stigma.*
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Utils.maquina
import com.projeto.appstigma.Utils.relatos
import kotlinx.android.synthetic.main.activity_relato.*
import java.text.SimpleDateFormat
import java.util.*
import android.widget.FrameLayout.LayoutParams

class RelatoActivity : AppCompatActivity() {

    var auth = FirebaseAuth.getInstance()
    var emocao = ""

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_relato)


        btn_muitofeliz.setOnClickListener {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2_2)
            btn_feliz.setBackgroundResource(R.drawable.happy)
            btn_neutro.setBackgroundResource(R.drawable.shocked)
            btn_triste.setBackgroundResource(R.drawable.sad)
            btn_muitotriste.setBackgroundResource(R.drawable.sad2)
            btn_cansado.setBackgroundResource(R.drawable.bad)
            emocao = "muitofeliz"
        }


        btn_feliz.setOnClickListener() {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2)
            btn_feliz.setBackgroundResource(R.drawable.happy_2)//trocar background
            btn_neutro.setBackgroundResource(R.drawable.shocked)
            btn_triste.setBackgroundResource(R.drawable.sad)
            btn_muitotriste.setBackgroundResource(R.drawable.sad2)
            btn_cansado.setBackgroundResource(R.drawable.bad)
            emocao = "feliz"
        }
        btn_neutro.setOnClickListener {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2)
            btn_feliz.setBackgroundResource(R.drawable.happy)
            btn_neutro.setBackgroundResource(R.drawable.shocked_2)
            btn_triste.setBackgroundResource(R.drawable.sad)
            btn_muitotriste.setBackgroundResource(R.drawable.sad2)
            btn_cansado.setBackgroundResource(R.drawable.bad)
            emocao = "neutro"
        }
        btn_triste.setOnClickListener {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2)
            btn_feliz.setBackgroundResource(R.drawable.happy)
            btn_neutro.setBackgroundResource(R.drawable.shocked)
            btn_triste.setBackgroundResource(R.drawable.sad_2)//trocar background
            btn_muitotriste.setBackgroundResource(R.drawable.sad2)
            btn_cansado.setBackgroundResource(R.drawable.bad)
            emocao = "triste"
        }
        btn_muitotriste.setOnClickListener {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2)
            btn_feliz.setBackgroundResource(R.drawable.happy)
            btn_neutro.setBackgroundResource(R.drawable.shocked)
            btn_triste.setBackgroundResource(R.drawable.sad)
            btn_muitotriste.setBackgroundResource(R.drawable.sad2_2)//trocar background
            btn_cansado.setBackgroundResource(R.drawable.bad)
            emocao = "muitotriste"

        }
        btn_cansado.setOnClickListener {
            btn_muitofeliz.setBackgroundResource(R.drawable.happy2)
            btn_feliz.setBackgroundResource(R.drawable.happy)
            btn_neutro.setBackgroundResource(R.drawable.shocked)
            btn_triste.setBackgroundResource(R.drawable.sad)
            btn_muitotriste.setBackgroundResource(R.drawable.sad2)
            btn_cansado.setBackgroundResource(R.drawable.bad_2)//trocar background*/
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




