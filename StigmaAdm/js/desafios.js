$(document).ready(function() {

    console.log("entrou");

    $("table").delegate('tr', 'click', function() {
        console.log("clicou")

        $(this).find('td').each(function(i) {
            $th = $("thead th")[i];

            if (jQuery($th).text() == "Emoção") {
                $("#modal-emocao").val($(this).html());
                nomeclick = $(this).html();
            }

            if (jQuery($th).text() == "Mensagems") {
                $("#modal-mensagem").val($(this).html());
            }

            $("#mensagem").modal();
        });
    });

    carregar();

    console.log("saiu");

});

function carregar() {
    var userList = document.getElementById('usersList')

    db.child("desafios").on('value', function(snapshot) {

        usersList.innerHTML = '';
        snapshot.forEach(function(item) {

            //var td = document.createElement('td');
            //td.append(document.createTextNode(item.val().nome + item.val().email + item.val().pedido));
            //usersList.appendChild(td);

            var tr = document.createElement('tr');
            var td1 = document.createElement('td');
            var td2 = document.createElement('td');
            var td3 = document.createElement('td');
            var td4 = document.createElement('td');

            td1.append(item.val().emocao);
            td2.append(item.val().titulo);
            td3.append(item.val().desafio);
            td4.append(item.val().valor);


            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);

            userList.appendChild(tr);

        });

    });

}

function cadastroEvento() {

    var mensagem = {
        emocao: $('#emocao-cad-desafio').val(),
        titulo: $('#titulo-cad-desafio').val(),
        mensagem: $('#desafio-cad-desafio').val(),
        valor: $('#valor-cad-desafio').val()
    };

    console.log(mensagem.emocao + mensagem.mensagem)

    let dados = {
        emocao: mensagem.emocao,
        titulo: mensagem.titulo,
        desafio: mensagem.mensagem,
        valor: mensagem.valor
    };

    db.child("desafios").push().set(dados);
    console.log(dados);

}