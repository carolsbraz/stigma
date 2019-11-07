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
import com.projeto.appstigma.Adapters.RelatoAdapter
import com.projeto.appstigma.Utils.relatosListReverse
import com.projeto.appstigma.Utils.usuariosList
import kotlinx.android.synthetic.main.activity_relatos_diarios.*
import kotlinx.android.synthetic.main.custom_modal_relatos.view.*

class ListarRelatosActivity : AppCompatActivity() {

    var emailLogado = ""
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_relatos_diarios)

        btn_voltar_3.setOnClickListener {
            finish()
        }

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                txt_nome_usuario.text = i.nome
            }
        }

        val relatoAdapter = RelatoAdapter(this)

        list_view_relatos.adapter = relatoAdapter

        for (r in relatosListReverse) {
            if (r.usuario == emailLogado) {
                relatoAdapter.addAll(r)
            }
        }

        list_view_relatos.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            val item = relatoAdapter.getItem(i)
            Toast.makeText(
                baseContext, "clicou",
                Toast.LENGTH_SHORT
            ).show()
            val dialog: Dialog = Dialog(context)
            val view = layoutInflater.inflate(R.layout.custom_modal_relatos, null)
            dialog.setContentView(view)
            view.txt_data_modal.text = item!!.data
            view.txt_relato_modal.text = item!!.relato
            var emocaoRelato = ""
            emocaoRelato = item!!.emocao
            if (emocaoRelato == "muitofeliz") {
                view.img_emocao_modal.setImageResource(R.drawable.happy2)
            }
            if (emocaoRelato == "feliz") {
                view.img_emocao_modal.setImageResource(R.drawable.happy)
            }
            if (emocaoRelato == "neutro") {
                view.img_emocao_modal.setImageResource(R.drawable.shocked)
            }
            if (emocaoRelato == "triste") {
                view.img_emocao_modal.setImageResource(R.drawable.sad)
            }
            if (emocaoRelato == "muitotriste") {
                view.img_emocao_modal.setImageResource(R.drawable.sad2)
            }
            if (emocaoRelato == "cansado") {
                view.img_emocao_modal.setImageResource(R.drawable.bad)
            }
            dialog.show()
        }

    }
}
