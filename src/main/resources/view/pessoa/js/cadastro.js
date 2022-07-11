function getDTO(){
    return {
        "nome": document.getElementById("nomeInput").value,
        "telefone": document.getElementById("telefoneInput").value
    }
}

function getRequest(url, dto){
    return new Request(window.location.origin+url, {
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(dto)
    });
}

function save(){
    fetch(getRequest("/api/pessoa/save", getDTO()))
        .then(response => response.json()) // solicitando o tipo de dado da resposta (promessa)
        .then(function(dto) { // recebendo o dado da resposta
            console.log(dto)
            alert(JSON.stringify(dto));
        })
        .catch(function(error) {
            console.error(error);
        });
}