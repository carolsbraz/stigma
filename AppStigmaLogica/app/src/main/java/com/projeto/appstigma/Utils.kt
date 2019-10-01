package com.projeto.appstigma

import com.example.stigma.Relato
import com.example.stigma.Usuario
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

var usuariosList = mutableListOf<Usuario>()
var relatosList = mutableListOf<Relato>()

var referencia = FirebaseDatabase.getInstance().getReference()
var usuarios = referencia.child("usuarios")
var relatos = referencia.child("relatos")

val a = usuarios.addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val user: Usuario?
        user = p0.getValue(Usuario::class.java)
        if (user !in usuariosList)
            usuariosList.add(user!!)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
})