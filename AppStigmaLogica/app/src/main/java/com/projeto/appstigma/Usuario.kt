package com.example.stigma

class Usuario{
    var nome : String = ""
    var email : String = ""
    var dataNasc : String = ""
    var senha : String = ""

    constructor(){
    }

    constructor(nome : String, email : String, dataNasc : String, senha : String){
        this.nome = nome
        this.email = email
        this.dataNasc = dataNasc
        this.senha = senha
    }
}