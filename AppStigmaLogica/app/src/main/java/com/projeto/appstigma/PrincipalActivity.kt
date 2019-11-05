package com.example.stigma


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.projeto.appstigma.*
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.custom_modal_sair.view.*
import java.text.SimpleDateFormat
import java.util.*


class PrincipalActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    val context: Context = this
    var emailLogado = ""
    var avatar: String? = ""
    var nome = ""
    var datadecriacao = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_principal)




        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                nome = i.nome
                avatar = i.avatar
                datadecriacao = i.datadecriacao
            }
        }

        setUpPieChartData()



        if (user != null) {
            txt_nome_logado.text = nome

            if (avatar == "avatar_boy1") {
                img_avatar.setImageResource(R.drawable.boy1)
            }
            if (avatar == "avatar_boy2") {
                img_avatar.setImageResource(R.drawable.boy2)
            }
            if (avatar == "avatar_boy3") {
                img_avatar.setImageResource(R.drawable.boy3)
            }
            if (avatar == "avatar_boy4") {
                img_avatar.setImageResource(R.drawable.boy4)
            }
            if (avatar == "avatar_boy5") {
                img_avatar.setImageResource(R.drawable.boy5)
            }
            if (avatar == "avatar_boy6") {
                img_avatar.setImageResource(R.drawable.boy6)
            }
            if (avatar == "avatar_boy7") {
                img_avatar.setImageResource(R.drawable.boy7)
            }
            if (avatar == "avatar_boy8") {
                img_avatar.setImageResource(R.drawable.boy8)
            }
            if (avatar == "avatar_boy9") {
                img_avatar.setImageResource(R.drawable.boy9)
            }

            if (avatar == "avatar_girl1") {
                img_avatar.setImageResource(R.drawable.girl1)
            }
            if (avatar == "avatar_girl2") {
                img_avatar.setImageResource(R.drawable.girl2)
            }
            if (avatar == "avatar_girl3") {
                img_avatar.setImageResource(R.drawable.girl3)
            }
            if (avatar == "avatar_girl4") {
                img_avatar.setImageResource(R.drawable.girl4)
            }
            if (avatar == "avatar_girl5") {
                img_avatar.setImageResource(R.drawable.girl5)
            }
            if (avatar == "avatar_girl6") {
                img_avatar.setImageResource(R.drawable.girl6)
            }
        } else {
            finish()
        }

        if (avatar == "") {
            val intent = Intent(this, PrincipalActivity::class.java)
            finish()
            startActivity(intent)
        }

        btn_tela_relato.setOnClickListener {
            val intent = Intent(this, RelatoActivity::class.java)
            startActivity(intent)
        }

        btn_tela_mensagem.setOnClickListener {
            val intent = Intent(this, MensagemActivity::class.java)
            startActivity(intent)
        }

        btn_tela_questao.setOnClickListener {
            val intent = Intent(this, QuestoesMotivadorasActivity::class.java)
            startActivity(intent)
        }

        btn_tela_desafio.setOnClickListener {
            val intent = Intent(this, DesafioActivity::class.java)
            startActivity(intent)
        }

        btn_config.setOnClickListener {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }

        btn_sair.setOnClickListener {
            val dialog: Dialog = Dialog(context)
            val view = layoutInflater.inflate(R.layout.custom_modal_sair, null)
            dialog.setContentView(view)
            dialog.show()

            view.btn_sair_modal.setOnClickListener {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            view.btn_cancelar_modal.setOnClickListener {
                dialog.dismiss()
            }
        }

        btn_config.setOnClickListener {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_tela_mauqinadotempo.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                val date = getCurrentDateTime()
                val dateInString = date.toString("MM/dd")

                var date2 = datadecriacao



                if( dateInString == date2 ){

                    var intent = Intent(this, MaquinaDoTempoActivity::class.java)
                    startActivity(intent)

                }else{

                    Toast.makeText(
                        baseContext, "Você só pode abrir sua máquina do tempo no seu aniversário de cadastro",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }
        }

    }

    private fun setUpPieChartData() {



        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(25f))
        yVals.add(PieEntry(25f))
        yVals.add(PieEntry(50f))


        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.rgb(182,182,182))
        colors.add(Color.rgb(91,176,196))
        colors.add(Color.rgb(189,120,121))

        dataSet.setColors(colors)
        val data = PieData(dataSet)
        grafico.data = data
        grafico.centerTextRadiusPercent = 0f
        grafico.isDrawHoleEnabled = false
        grafico.legend.isEnabled = false
        grafico.description.isEnabled = false
    }


}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}
