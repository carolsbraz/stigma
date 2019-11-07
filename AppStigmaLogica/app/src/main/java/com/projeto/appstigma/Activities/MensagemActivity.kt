package com.projeto.appstigma.Activities

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stigma.R
import com.projeto.appstigma.Utils.mensagensList
import kotlinx.android.synthetic.main.activity_mensagem.*
import kotlinx.android.synthetic.main.custom_modal_mensagem.view.*
import java.util.*

class MensagemActivity : AppCompatActivity() {

    val context: Context = this
    var emocao = ""
    var lastSort = ""
    var autorSort = ""
    var mensagemSort = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_mensagem)

        btn_muitofeliz2.setOnClickListener {
            emocao = "muitofeliz"
        }
        btn_feliz2.setOnClickListener {
            emocao = "feliz"
        }
        btn_neutro2.setOnClickListener {
            emocao = "neutro"
        }
        btn_triste2.setOnClickListener {
            emocao = "triste"
        }
        btn_muitotriste2.setOnClickListener {
            emocao = "muitotriste"
        }
        btn_cansado2.setOnClickListener {
            emocao = "cansado"
        }

        btn_abrirMensagem.setOnClickListener {
            if (emocao != "") {
                do {
                    var i = (0..mensagensList.size).random()
                    if (mensagensList[i].emocao == emocao && mensagensList[i].mensagem != lastSort) {
                        mensagemSort = mensagensList[i].mensagem
                        autorSort = mensagensList[i].autor
                    } else {
                        mensagemSort == ""
                    }
                } while (mensagemSort == "")
                val dialog: Dialog = Dialog(context)
                val view = layoutInflater.inflate(R.layout.custom_modal_mensagem, null)
                dialog.setContentView(view)
                view.txt_mensagem_modal.text = mensagemSort
                view.txt_autor_modal.text = autorSort
                if (emocao == "muitofeliz") {
                    view.img_emocao.setImageResource(R.drawable.happy2)
                }
                if (emocao == "feliz") {
                    view.img_emocao.setImageResource(R.drawable.happy)
                }
                if (emocao == "neutro") {
                    view.img_emocao.setImageResource(R.drawable.shocked)
                }
                if (emocao == "triste") {
                    view.img_emocao.setImageResource(R.drawable.sad)
                }
                if (emocao == "muitotriste") {
                    view.img_emocao.setImageResource(R.drawable.sad2)
                }
                if (emocao == "cansado") {
                    view.img_emocao.setImageResource(R.drawable.bad)
                }
                dialog.show()
                lastSort = mensagemSort
                mensagemSort = ""
                view.btn_random.setOnClickListener {
                    do {
                        var i = (0..mensagensList.size).random()
                        if (mensagensList[i].emocao == emocao && mensagensList[i].mensagem != lastSort) {
                            mensagemSort = mensagensList[i].mensagem
                            autorSort = mensagensList[i].autor
                        } else {
                            mensagemSort == ""
                        }
                    } while (mensagemSort == "")

                    view.txt_mensagem_modal.text = mensagemSort
                    view.txt_autor_modal.text = autorSort
                    lastSort = mensagemSort
                    mensagemSort = ""
                }
            } else {
                Toast.makeText(
                    baseContext, "Selecione uma emocao.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btn_voltar_2.setOnClickListener {
            finish()
        }
    }

    fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start

}
