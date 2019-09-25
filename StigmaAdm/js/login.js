function login() {

    var adm = {
        email: $('#email').val(),
        senha: $('#senha').val()
    }

    console.log(adm.email);
    console.log(adm.senha);

    db.child("administradores").on('value', function (snapshot) {


        snapshot.forEach(function (item) {


            if (item.val().email == adm.email && item.val().senha == adm.senha) {

                if (item.val().aprovado == "true") {

                    firebase.auth().signInWithEmailAndPassword(adm.email, adm.senha).catch(function (error) {
                        // Handle Errors here.
                        var errorCode = error.code;
                        var errorMessage = error.message;
                        // ...
                    });

                    console.log("oi bb");

                    window.location.href = "principal.html";



                }
            }

        });

    });



}
