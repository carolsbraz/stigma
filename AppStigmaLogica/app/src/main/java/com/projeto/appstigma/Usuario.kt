package com.example.stigma

class Usuario{
    var id : String = ""
    var nome : String = ""
    var email : String = ""
    var dataNasc : String = ""
    var senha : String = ""
    var avatar : String? = ""

    constructor(){
    }

    constructor(id : String, nome : String, email : String, dataNasc : String, senha : String, avatar : String?){
        this.id = id
        this.nome = nome
        this.email = email
        this.dataNasc = dataNasc
        this.senha = senha
        this.avatar = avatar
    }
}