$(document).ready(function () {

    console.log("entrou");

    $("table").delegate('tr', 'click', function () {
        console.log("clicou")

        $(this).find('td').each(function (i) {
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

    db.child("questoes").on('value', function (snapshot) {

        usersList.innerHTML = '';
        snapshot.forEach(function (item) {

            //var td = document.createElement('td');
            //td.append(document.createTextNode(item.val().nome + item.val().email + item.val().pedido));
            //usersList.appendChild(td);

            var tr = document.createElement('tr');
            var td1 = document.createElement('td');
            var td2 = document.createElement('td');

            td1.append(item.val().emocao);

            td2.append(item.val().mensagem);


            tr.appendChild(td1);
            tr.appendChild(td2);


            userList.appendChild(tr);

        });

    });

}

function cadastroEvento() {

    var mensagem = {
        emocao: $('#emocao').val(),
        mensagem: $('#mensagem').val()
    };

    let dados = {
        emocao: mensagem.emocao,
        mensagem: mensagem.mensagem
    };

    db.child("questoes").push().set(dados);
    console.log(dados);

}
