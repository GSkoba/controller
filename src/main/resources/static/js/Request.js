alert("Script in connection");

function requestForServer(method, action, cFunction) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            cFunction(this);
        }
    };
    xhttp.open(method, action, true);
    xhttp.send();
}

function sendRes(xhttp) {

    var text = xhttp.responseText;
    var div = document.createElement("div");
    div.innerText = text;
    document.body.appendChild(div);
}

function controllers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var jsonData = JSON.parse(this.responseText);
            var divData = document.createElement("div");
            divData.innerText = jsonData['data'];
            document.body.appendChild(divData);

            jsonData['controllers'].forEach(function (element) {
                var divController = document.createElement("div");
                divController.innerText = element['id'] + " " + element['name'];
                document.body.appendChild(divController);
            });

            console.log(jsonData);
        }
    };
    xhttp.open("GET", "/controllers?", true);
    xhttp.send();
}
