package com.projeto.appstigma

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.R
import com.example.stigma.toString
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_maquina_do_tempo.*
import kotlinx.android.synthetic.main.activity_relatos_diarios.txt_nome_usuario
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MaquinaDoTempoActivity : AppCompatActivity() {

    var emailLogado = ""
    val context: Context = this
    var anoatual = ""
    var anorelato = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_maquina_do_tempo)

        btn_voltar_maquina.setOnClickListener {
            finish()
        }

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                txt_nome_usuario.text = i.nome

            }
        }

        val maquinaAdapter = MaquinaAdapter(this)

        list_view_maquina.adapter = maquinaAdapter

        val date = getCurrentDateTime()
        anoatual = date.toString("yyyy")

        txt_data_maquina.text = anoatual

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            for (r in maquinaDoTempoList) {
                if (r.usuario == emailLogado) {

                    var dr = r.data

                    var quebrou = dr.split("/")

                    anorelato = quebrou[2]

                    if (anoatual == anorelato) {
                        maquinaAdapter.addAll(r)
                    }

                }
            }
        }
    }
}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}
