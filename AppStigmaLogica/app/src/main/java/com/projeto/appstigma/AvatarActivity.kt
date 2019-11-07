package com.projeto.appstigma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stigma.CadastroActivity
import com.example.stigma.R
import kotlinx.android.synthetic.main.activity_avatar.*

class AvatarActivity : AppCompatActivity() {

    var avatar = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_avatar)
        avatar_boy1.setOnClickListener {
            avatar = "avatar_boy1"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy2.setOnClickListener {
            avatar = "avatar_boy2"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy3.setOnClickListener {
            avatar = "avatar_boy3"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy4.setOnClickListener {
            avatar = "avatar_boy4"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy5.setOnClickListener {
            avatar = "avatar_boy5"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy6.setOnClickListener {
            avatar = "avatar_boy6"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy7.setOnClickListener {
            avatar = "avatar_boy7"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy8.setOnClickListener {
            avatar = "avatar_boy8"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_boy9.setOnClickListener {
            avatar = "avatar_boy9"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl1.setOnClickListener {
            avatar = "avatar_girl1"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl2.setOnClickListener {
            avatar = "avatar_girl2"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl3.setOnClickListener {
            avatar = "avatar_girl3"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl4.setOnClickListener {
            avatar = "avatar_girl4"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl5.setOnClickListener {
            avatar = "avatar_girl5"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
        avatar_girl6.setOnClickListener {
            avatar = "avatar_girl6"
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("avatar", avatar)
            startActivity(intent)
        }
    }
}
