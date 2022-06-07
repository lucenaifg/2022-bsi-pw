function exemplo01(){

    let url =  "http://localhost:8080/api/ok"

    fetch(url)
        .then(function (response) {
            console.log(response);
            alert('retorno ok!')
        })
        .catch(function (error) {
            console.error(error);
            alert('retorno com erro!')
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
        .then(function(pessoa) { // recebendo o dado da resposta
            console.log(pessoa)
            alert(JSON.stringify(pessoa));
        })
        .catch(function(error) {
            console.error(error);
        });
}


function exemplo03(){

    let url = "http://localhost:8080/api/aula04/list"


    var request = new Request(url, {
        method: 'GET',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        })
    });

    fetch(request)
        .then(response => response.json())
        .then(function(list) {
            console.log(list);
            alert(JSON.stringify(list));
        })
        .catch(function(error) {
            console.error(error);
        });
}