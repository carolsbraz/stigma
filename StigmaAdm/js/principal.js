var nomeclick;

$(document).ready(function () {

    console.log("entrou");

    $("table").delegate('tr', 'click', function () {
        console.log("clicou")

        $(this).find('td').each(function (i) {
            $th = $("thead th")[i];

            if (jQuery($th).text() == "Nome") {
                $("#modal-nome").val($(this).html());
                nomeclick = $(this).html();
            }

            if (jQuery($th).text() == "Email") {
                $("#modal-email").val($(this).html());
            }

            $("#informacoes").modal();
        });
    });

    carregar();

    console.log("saiu");

});

function carregar() {
    var userList = document.getElementById('usersList')

    db.child("administradores").on('value', function (snapshot) {

        usersList.innerHTML = '';
        snapshot.forEach(function (item) {

            //var td = document.createElement('td');
            //td.append(document.createTextNode(item.val().nome + item.val().email + item.val().pedido));
            //usersList.appendChild(td);

            var tr = document.createElement('tr');
            var td1 = document.createElement('td');
            var td2 = document.createElement('td');
            var td3 = document.createElement('td');


            td1.append(item.val().nome);

            td2.append(item.val().email);

            if (item.val().aprovado == "false") {
                td3.append("Em aguardo");
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);

                userList.appendChild(tr);
            }
        });

    });

}

function aprovar() {

    console.log("oi eu to aqui")

    db.child("administradores").on('value', function (snapshot) {

        usersList.innerHTML = '';
        snapshot.forEach(function (item) {


            var nome = item.val().nome;
            var aprovado = item.val().aprovado;

            if (nomeclick == nome && aprovado == "false") {

                var email = item.val().email;
                var senha = item.val().senha;


                console.log(nomeclick);
                console.log(email);
                console.log(senha);
                console.log(aprovado);


                firebase.auth().createUserWithEmailAndPassword(email, senha).catch(function (error) {
                    // Handle Errors here.
                    var errorCode = error.code;
                    var errorMessage = error.message;
                    // ...
                });
                db.child("administradores").child(nomeclick).child("aprovado").set("true");

            }

        });

    });

    $('#informacoes').modal('hide')

    carregar();


}
