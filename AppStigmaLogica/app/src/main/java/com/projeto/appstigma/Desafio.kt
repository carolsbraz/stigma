package com.example.stigma

class Desafio {
    var emocao: String = ""
    var titulo: String = ""
    var desafio: String = ""
    var valor: String = ""

    constructor() {
    }

    constructor(emocao: String, titulo: String, desafio: String, valor: String) {
        this.emocao = emocao
        this.titulo = titulo
        this.desafio = desafio
        this.valor = valor
    }
}