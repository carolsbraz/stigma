package com.projeto.appstigma.Activities

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Adapters.RespostasAdapter
import com.projeto.appstigma.Utils.respostasListReverse
import com.projeto.appstigma.Utils.usuariosList
import kotlinx.android.synthetic.main.activity_listar_questoes.*
import kotlinx.android.synthetic.main.activity_listar_questoes.txt_nome_usuario
import kotlinx.android.synthetic.main.custom_modal_questao.view.*

class ListarQuestoesActivity : AppCompatActivity() {

    var logado = ""
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_listar_questoes)

        btn_voltar_5.setOnClickListener {
            finish()
        }

        val user = FirebaseAuth.getInstance().currentUser
        logado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == logado) {
                txt_nome_usuario.text = i.nome
            }
        }

        val respostaAdapter = RespostasAdapter(this)

        list_view_respostas.adapter = respostaAdapter

        for (r in respostasListReverse) {
            if (r.usuario == logado) {
                respostaAdapter.addAll(r)
            }
        }

        list_view_respostas.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            val item = respostaAdapter.getItem(i)
            val dialog: Dialog = Dialog(context)
            val view = layoutInflater.inflate(R.layout.custom_modal_questao, null)
            dialog.setContentView(view)
            view.txt_questao_modal.text = item!!.questao
            view.txt_resposta_modal.text = item!!.resposta
            var emocaoRelato = ""
            emocaoRelato = item!!.emocao
            if (emocaoRelato == "muitofeliz") {
                view.img_emocao_resposta.setImageResource(R.drawable.happy2)
            }
            if (emocaoRelato == "feliz") {
                view.img_emocao_resposta.setImageResource(R.drawable.happy)
            }
            if (emocaoRelato == "neutro") {
                view.img_emocao_resposta.setImageResource(R.drawable.shocked)
            }
            if (emocaoRelato == "triste") {
                view.img_emocao_resposta.setImageResource(R.drawable.sad)
            }
            if (emocaoRelato == "muitotriste") {
                view.img_emocao_resposta.setImageResource(R.drawable.sad2)
            }
            if (emocaoRelato == "cansado") {
                view.img_emocao_resposta.setImageResource(R.drawable.bad)
            }
            dialog.show()
        }
    }
}
