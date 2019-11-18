package com.projeto.appstigma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stigma.R
import com.example.stigma.Resposta
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Utils.questoesList
import com.projeto.appstigma.Utils.respostas
import kotlinx.android.synthetic.main.activity_questoesmotivadoras.*
import java.util.*

class QuestoesMotivadorasActivity : AppCompatActivity() {

    var emocao = ""
    var questaoSort = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_questoesmotivadoras)

        btn_muitofeliz1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2_2)
            btn_feliz1.setBackgroundResource(R.drawable.happy)
            btn_neutro1.setBackgroundResource(R.drawable.shocked)
            btn_triste1.setBackgroundResource(R.drawable.sad)
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2)
            btn_cansado1.setBackgroundResource(R.drawable.bad)
            emocao = "muitofeliz"
        }
        btn_feliz1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2)
            btn_feliz1.setBackgroundResource(R.drawable.happy_2)//trocar background
            btn_neutro1.setBackgroundResource(R.drawable.shocked)
            btn_triste1.setBackgroundResource(R.drawable.sad)
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2)
            btn_cansado1.setBackgroundResource(R.drawable.bad)
            emocao = "feliz"
        }
        btn_neutro1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2)
            btn_feliz1.setBackgroundResource(R.drawable.happy)
            btn_neutro1.setBackgroundResource(R.drawable.shocked_2)
            btn_triste1.setBackgroundResource(R.drawable.sad)
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2)
            btn_cansado1.setBackgroundResource(R.drawable.bad)
            emocao = "neutro"
        }
        btn_triste1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2)
            btn_feliz1.setBackgroundResource(R.drawable.happy)
            btn_neutro1.setBackgroundResource(R.drawable.shocked)
            btn_triste1.setBackgroundResource(R.drawable.sad_2)//trocar background
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2)
            btn_cansado1.setBackgroundResource(R.drawable.bad)
            emocao = "triste"
        }
        btn_muitotriste1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2)
            btn_feliz1.setBackgroundResource(R.drawable.happy)
            btn_neutro1.setBackgroundResource(R.drawable.shocked)
            btn_triste1.setBackgroundResource(R.drawable.sad)
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2_2)//trocar background
            btn_cansado1.setBackgroundResource(R.drawable.bad)
            emocao = "muitotriste"
        }
        btn_cansado1.setOnClickListener {
            btn_muitofeliz1.setBackgroundResource(R.drawable.happy2)
            btn_feliz1.setBackgroundResource(R.drawable.happy)
            btn_neutro1.setBackgroundResource(R.drawable.shocked)
            btn_triste1.setBackgroundResource(R.drawable.sad)
            btn_muitotriste1.setBackgroundResource(R.drawable.sad2)
            btn_cansado1.setBackgroundResource(R.drawable.bad_2)//trocar background*/
            emocao = "cansado"
        }

        btn_gerar_questao.setOnClickListener {
            if (emocao != "") {
                do {
                    var i = (0..questoesList.size).random()
                    if (questoesList[i].emocao == emocao && questoesList[i].questao != questaoSort) {
                        questaoSort = questoesList[i].questao
                        txt_pergunta.text = questaoSort
                    } else {
                        txt_pergunta.text = ""
                    }
                } while (txt_pergunta.text.equals(""))
            } else {
                Toast.makeText(
                    baseContext, "Selecione uma emocao.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btn_responder.setOnClickListener {
            if (txt_pergunta.text != "" && txt_pergunta.text != "Gere uma pergunta acima!" && txt_resposta.text.isNotEmpty()) {
                val resp = Resposta(
                    respostas.push().key!!,
                    txt_pergunta.text.toString(),
                    emocao,
                    txt_resposta.text.toString(),
                    FirebaseAuth.getInstance().currentUser!!.email.toString()
                )
                respostas.child(resp.id).setValue(resp)
                val intent = Intent(this, ListarQuestoesActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
            }
        }

        btn_listar_respostas.setOnClickListener {
            val intent = Intent(this, ListarQuestoesActivity::class.java)
            startActivity(intent)
        }

        btn_voltar_6.setOnClickListener {
            finish()
        }
    }

    fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start
}
