package com.projeto.appstigma.Activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.PrincipalActivity
import com.example.stigma.R
import com.google.firebase.auth.FirebaseAuth
import com.projeto.appstigma.Adapters.DesafioAdapter
import com.projeto.appstigma.Utils.desafiosConcluidosList
import com.projeto.appstigma.Utils.desafiosListReverse
import com.projeto.appstigma.Utils.usuariosList
import kotlinx.android.synthetic.main.activity_desafios.*

class DesafioActivity : AppCompatActivity() {

    var somaValores = 0
    var jafeito = 0
    var emailLogado = ""
    var porcentagem = 0
    var avatar : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_desafios)

        val desafioAdapter = DesafioAdapter(this)

        list_view_desafios.adapter = desafioAdapter

        val user = FirebaseAuth.getInstance().currentUser
        emailLogado = user!!.email.toString()

        for (i in usuariosList) {
            if (i.email == emailLogado) {
                avatar = i.avatar
            }
        }

        if (user != null) {
            if (avatar == "avatar_boy1") {
                img_avatar_4.setBackgroundResource(R.drawable.boy1)
            }
            if (avatar == "avatar_boy2") {
                img_avatar_4.setBackgroundResource(R.drawable.boy2)
            }
            if (avatar == "avatar_boy3") {
                img_avatar_4.setBackgroundResource(R.drawable.boy3)
            }
            if (avatar == "avatar_boy4") {
                img_avatar_4.setBackgroundResource(R.drawable.boy4)
            }
            if (avatar == "avatar_boy5") {
                img_avatar_4.setBackgroundResource(R.drawable.boy5)
            }
            if (avatar == "avatar_boy6") {
                img_avatar_4.setBackgroundResource(R.drawable.boy6)
            }
            if (avatar == "avatar_boy7") {
                img_avatar_4.setBackgroundResource(R.drawable.boy7)
            }
            if (avatar == "avatar_boy8") {
                img_avatar_4.setBackgroundResource(R.drawable.boy8)
            }
            if (avatar == "avatar_boy9") {
                img_avatar_4.setBackgroundResource(R.drawable.boy9)
            }
            if (avatar == "avatar_girl1") {
                img_avatar_4.setBackgroundResource(R.drawable.girl1)
            }
            if (avatar == "avatar_girl2") {
                img_avatar_4.setBackgroundResource(R.drawable.girl2)
            }
            if (avatar == "avatar_girl3") {
                img_avatar_4.setBackgroundResource(R.drawable.girl3)
            }
            if (avatar == "avatar_girl4") {
                img_avatar_4.setBackgroundResource(R.drawable.girl4)
            }
            if (avatar == "avatar_girl5") {
                img_avatar_4.setBackgroundResource(R.drawable.girl5)
            }
            if (avatar == "avatar_girl6") {
                img_avatar_4.setBackgroundResource(R.drawable.girl6)
            }
        } else {
            finish()
        }

        if (avatar == "") {
            val intent = Intent(this, DesafioActivity::class.java)
            finish()
            startActivity(intent)
        }

        for (r in desafiosListReverse) {
            desafioAdapter.addAll(r)
            somaValores += r.valor.toInt()
        }

        for (d in desafiosConcluidosList) {
            if (d.usuario == emailLogado) {
                jafeito += d.valor.toInt()
            }
        }



        if(somaValores > 0){
            porcentagem = (jafeito * 100) / somaValores
            txt_pontos.text = "$porcentagem%"
        }else{
            txt_pontos.text = "Não há desafios no banco"
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            pb_desafios.setProgress(porcentagem, true)
        }

        btn_voltar_4.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


