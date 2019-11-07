package com.projeto.appstigma.Adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.stigma.R
import com.example.stigma.Relato
import com.projeto.appstigma.Utils.relatos
import com.projeto.appstigma.Utils.relatosList
import com.projeto.appstigma.Utils.relatosListReverse
import kotlinx.android.synthetic.main.custom_modal_deletar.view.*

class RelatoAdapter(contexto: Context) : ArrayAdapter<Relato>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false)
        }

        val item = getItem(position)

        val txt_emocao = v.findViewById<TextView>(R.id.txt_emocao_item)
        val txt_relato = v.findViewById<TextView>(R.id.txt_relato_item)
        val btn_apagar = v.findViewById<ImageButton>(R.id.btn_apagar)

        txt_emocao.text = item?.data.toString()
        txt_relato.text = item?.relato.toString()

        btn_apagar.setOnClickListener {
            val dialog: Dialog = Dialog(context)
            val view2 = LayoutInflater.from(context).inflate(R.layout.custom_modal_deletar, null)
            dialog.setContentView(view2)
            dialog.show()
            view2.btn_sim_modal.setOnClickListener {
                relatos.child(item!!.id).removeValue()
                this.remove(item)
                relatosList.remove(item)
                relatosListReverse.remove(item)
                dialog.dismiss()
                Toast.makeText(
                    context, "Relato excluido.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            view2.btn_nao_modal.setOnClickListener {
                dialog.dismiss()
            }
        }

        return v;
    }
}