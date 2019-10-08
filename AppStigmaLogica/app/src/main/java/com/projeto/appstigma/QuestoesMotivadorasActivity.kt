package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stigma.R
import com.example.stigma.Relato
import com.example.stigma.Resposta
import com.example.stigma.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_questoesmotivadoras.*
import kotlinx.android.synthetic.main.activity_relato.*
import java.util.*

class QuestoesMotivadorasActivity : AppCompatActivity() {

    var emocao = ""
    var questaoSort = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_questoesmotivadoras)

        btn_muitofeliz1.setOnClickListener {
            emocao = "muitofeliz"
        }
        btn_feliz1.setOnClickListener {
            emocao = "feliz"
        }
        btn_neutro1.setOnClickListener {
            emocao = "neutro"
        }
        btn_triste1.setOnClickListener {
            emocao = "triste"
        }
        btn_muitotriste1.setOnClickListener {
            emocao = "muitotriste"
        }
        btn_cansado1.setOnClickListener {
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

                }while (txt_pergunta.text.equals(""))

            } else {
                Toast.makeText(
                    baseContext, "Selecione uma emocao.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        btn_responder.setOnClickListener{

            if(txt_pergunta.text != "" && txt_pergunta.text != "Gere uma pergunta acima!" && txt_resposta.text.isNotEmpty()){

                val resp = Resposta(respostas.push().key!!, txt_pergunta.text.toString(), emocao, txt_resposta.text.toString(), FirebaseAuth.getInstance().currentUser!!.email.toString())
                respostas.child(resp.id).setValue(resp)

                val intent = Intent(this, ListarQuestoesActivity::class.java)
                startActivity(intent)

                this.finish()

            }else{

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
