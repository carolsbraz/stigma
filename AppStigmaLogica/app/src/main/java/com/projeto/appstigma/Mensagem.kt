package com.example.stigma

class Mensagem{
    var mensagem : String = ""
    var emocao : String = ""
    var autor : String = ""

    constructor(){
    }

    constructor(mensagem : String, emocao : String, autor : String){
        this.mensagem = mensagem
        this.emocao = emocao
        this.autor = autor
    }
}