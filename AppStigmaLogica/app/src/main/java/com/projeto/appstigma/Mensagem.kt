package com.example.stigma

class Mensagem{
    var mensagem : String = ""
    var emocao : String = ""

    constructor(){
    }

    constructor(mensagem : String, emocao : String){
        this.mensagem = mensagem
        this.emocao = emocao
    }
}