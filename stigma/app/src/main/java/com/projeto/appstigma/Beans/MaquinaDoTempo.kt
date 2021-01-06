package com.example.stigma

class MaquinaDoTempo {
    var id: String = ""
    var relato: String = ""
    var emocao: String = ""
    var usuario: String = ""
    var data: String = ""

    constructor() {
    }

    constructor(id: String, relato: String, emocao: String, usuario: String, data: String) {
        this.id = id
        this.relato = relato
        this.emocao = emocao
        this.usuario = usuario
        this.data = data
    }
}