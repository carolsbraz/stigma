package com.projeto.appstigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_listar_questoes.*
import kotlinx.android.synthetic.main.activity_listar_questoes.txt_nome_usuario

class ListarQuestoesActivity : AppCompatActivity() {

    var logado = ""

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
    }
}
