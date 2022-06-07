function exemplo01(){

    let url =  "http://localhost:8080/api/ok"

    fetch(url)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.error(error);
        });
}

function exemplo02(){

    let url = "http://localhost:8080/api/aula04/save"

    let data = {
        "nome": "Daniel",
        "telefone": "123"
    }

    var request = new Request(url, {
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(data)
    });

    fetch(request)
        .then(response => response.json()) // solicitando o tipo de dado da resposta (promessa)
        .then(function(data) { // recebendo o dado da resposta
            console.log(data)
        })
        .catch(function(error) {
            console.error(error);
        });
}