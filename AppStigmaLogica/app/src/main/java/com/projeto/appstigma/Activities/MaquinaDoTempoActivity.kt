package com.projeto.appstigma.Activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.PrincipalActivity
import com.example.stigma.R
import com.example.stigma.toString
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Adapters.MaquinaAdapter
import com.projeto.appstigma.Utils.maquinaDoTempoList
import com.projeto.appstigma.Utils.usuariosList
import kotlinx.android.synthetic.main.activity_maquina_do_tempo.*
import kotlinx.android.synthetic.main.activity_relatos_diarios.txt_nome_usuario
import java.text.SimpleDateFormat
import java.util.*

class MaquinaDoTempoActivity : AppCompatActivity() {

    var emailLogado = ""
    val context: Context = this
    var anoatual = ""
    var anorelato = ""
    var avatar : String? = ""
    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_maquina_do_tempo)

        btn_voltar_maquina.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                avatar = i.avatar
                nome = i.nome
            }
        }

        if (user != null) {
            txt_nome_usuario.text = nome
            if (avatar == "avatar_boy1") {
                img_avatar_5.setBackgroundResource(R.drawable.boy1)
            }
            if (avatar == "avatar_boy2") {
                img_avatar_5.setBackgroundResource(R.drawable.boy2)
            }
            if (avatar == "avatar_boy3") {
                img_avatar_5.setBackgroundResource(R.drawable.boy3)
            }
            if (avatar == "avatar_boy4") {
                img_avatar_5.setBackgroundResource(R.drawable.boy4)
            }
            if (avatar == "avatar_boy5") {
                img_avatar_5.setBackgroundResource(R.drawable.boy5)
            }
            if (avatar == "avatar_boy6") {
                img_avatar_5.setBackgroundResource(R.drawable.boy6)
            }
            if (avatar == "avatar_boy7") {
                img_avatar_5.setBackgroundResource(R.drawable.boy7)
            }
            if (avatar == "avatar_boy8") {
                img_avatar_5.setBackgroundResource(R.drawable.boy8)
            }
            if (avatar == "avatar_boy9") {
                img_avatar_5.setBackgroundResource(R.drawable.boy9)
            }
            if (avatar == "avatar_girl1") {
                img_avatar_5.setBackgroundResource(R.drawable.girl1)
            }
            if (avatar == "avatar_girl2") {
                img_avatar_5.setBackgroundResource(R.drawable.girl2)
            }
            if (avatar == "avatar_girl3") {
                img_avatar_5.setBackgroundResource(R.drawable.girl3)
            }
            if (avatar == "avatar_girl4") {
                img_avatar_5.setBackgroundResource(R.drawable.girl4)
            }
            if (avatar == "avatar_girl5") {
                img_avatar_5.setBackgroundResource(R.drawable.girl5)
            }
            if (avatar == "avatar_girl6") {
                img_avatar_5.setBackgroundResource(R.drawable.girl6)
            }
        } else {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (avatar == "") {
            val intent = Intent(this, MaquinaDoTempoActivity::class.java)
            finish()
            startActivity(intent)
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
