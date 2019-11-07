package com.example.stigma

class Resposta {
    var id: String = ""
    var questao: String = ""
    var emocao: String = ""
    var resposta: String = ""
    var usuario: String = ""

    constructor() {
    }

    constructor(id: String, questao: String, emocao: String, resposta: String, usuario: String) {
        this.id = id
        this.questao = questao
        this.emocao = emocao
        this.resposta = resposta
        this.usuario = usuario
    }
}