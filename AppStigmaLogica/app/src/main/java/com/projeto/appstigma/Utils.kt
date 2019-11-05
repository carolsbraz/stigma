package com.projeto.appstigma

import com.example.stigma.*
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

var usuariosList = mutableListOf<Usuario>()

var questoesList = mutableListOf<Questao>()

var relatosList = mutableListOf<Relato>()
val relatosListReverse = relatosList.asReversed()

var respostasList = mutableListOf<Resposta>()
var respostasListReverse = respostasList.asReversed()
var mensagensList = mutableListOf<Mensagem>()
var desafiosList = mutableListOf<Desafio>()

var desafiosListReverse = desafiosList.asReversed()

var desafiosConcluidosList = mutableListOf<DesafioConcluido>()

var maquinaDoTempoList = mutableListOf<MaquinaDoTempo>()

var referencia = FirebaseDatabase.getInstance().getReference()
var usuarios = referencia.child("usuarios")
var relatos = referencia.child("relatos")
var questoes = referencia.child("questoes")
var respostas = referencia.child("respostas")
var mensagens = referencia.child("mensagens")
var desafios = referencia.child("desafios")
var desafiosConcluido = referencia.child("desafiosConcluidos")
var maquina = referencia.child("maquinadotempo")

val a = usuarios.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val user: Usuario?
        user = p0.getValue(Usuario::class.java)
        if (user !in usuariosList)
            usuariosList.add(user!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {

        var user : Usuario?
        user = p0.getValue(Usuario::class.java)
        var i = 0

        while (i < usuariosList.size){

            if(user!!.avatar!= usuariosList[i].avatar){
                usuariosList[i].avatar = user!!.avatar
            }
            if(user!!.nome!= usuariosList[i].nome){
                usuariosList[i].nome = user!!.nome
            }
            if(user!!.email!= usuariosList[i].email){
                usuariosList[i].email = user!!.email
            }
            if(user!!.dataNasc!= usuariosList[i].dataNasc){
                usuariosList[i].dataNasc = user!!.dataNasc
            }
            if(user!!.senha!= usuariosList[i].senha){
                usuariosList[i].senha = user!!.senha
            }

            i++
        }

    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        var user: Usuario?
        user = p0.getValue(Usuario::class.java)
        if (user in usuariosList)
            usuariosList.remove(user!!)
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val b = relatos.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val relato:Relato?
        relato = p0.getValue(Relato::class.java)
        if (relato !in relatosList)
            relatosList.add(relato!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        var relato: Relato?
        relato = p0.getValue(Relato::class.java)
        if (relato in relatosList)
            relatosList.remove(relato!!)
        if (relato in relatosListReverse)
            relatosListReverse.remove(relato!!)
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val q = questoes.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val quest: Questao? = p0.getValue(Questao::class.java)
        if (quest !in questoesList)
            questoesList.add(quest!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val r = respostas.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val resp: Resposta? = p0.getValue(Resposta::class.java)
        if (resp !in respostasList)
            respostasList.add(resp!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val m = mensagens.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val mens: Mensagem? = p0.getValue(Mensagem::class.java)
        if (mens !in mensagensList)
            mensagensList.add(mens!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val d = desafios.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val des: Desafio? = p0.getValue(Desafio::class.java)
        if(des !in desafiosList)
            desafiosList.add(des!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val dc = desafiosConcluido.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val des: DesafioConcluido? = p0.getValue(DesafioConcluido::class.java)
        if(des !in desafiosConcluidosList)
            desafiosConcluidosList.add(des!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})

val mt = maquina.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val maq: MaquinaDoTempo? = p0.getValue(MaquinaDoTempo::class.java)
        if(maq !in maquinaDoTempoList)
            maquinaDoTempoList.add(maq!!)
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})