function cadastro() {

    var adm = {
        email: $('#email').val(),
        senha: $('#senha').val(),
        nome: $('#nome').val()
    }

    let dados = {
        email: adm.email,
        senha: adm.senha,
        nome: adm.nome,
        aprovado: "false"
    };

    if (dados.senha.length >= 6) {

        db.child("administradores").child(dados.nome).set(dados);

        window.location.href = "index.html";

        console.log("cadastrou");
    }


}
