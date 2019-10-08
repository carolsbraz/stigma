package com.example.stigma

class Usuario{
    var id : String = ""
    var nome : String = ""
    var email : String = ""
    var dataNasc : String = ""
    var senha : String = ""

    constructor(){
    }

    constructor(id : String, nome : String, email : String, dataNasc : String, senha : String){
        this.id = id
        this.nome = nome
        this.email = email
        this.dataNasc = dataNasc
        this.senha = senha
    }
}