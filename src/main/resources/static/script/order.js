
let $username = document.location.search.replace(/^.*?\=/,'');


let $lastChar = $username[$username.length -1];


$username = $username.slice(0, -1)

let $orderTotal = 0
let $role = null;

function getCustomer() {
    $.ajax({
        url: "http://localhost:8080//userByUsername/" + $username
    }).then(function(data) {
        $role= data.role;
        console.log($role);
    });
}

function loadLastCart() {
    $.ajax({
        url: "http://localhost:8080//lastCart/" + $username
    }).then(function(data) {
        $('#cart-tabell').empty();
        for(let i = 0; i< data.length; i++) {
            $('#cart-tabell').append(
                "<tr>" +
                "<td class='col-name'>" + data[i].name + "</td>" +
                "<td class='col-price'>" + data[i].price + " kr" +"</td>" +
                "</tr>")
            $orderTotal = $orderTotal + Number(data[i].price);
        }

        console.log($lastChar);

        if ($lastChar=="C")
            $('#total-orderSida').append($orderTotal);
        else if ($lastChar=="P") {
            $('#total-orderSida').append($orderTotal * 0.9);
            $('#msg-orderSida').append("Premium discount included!");

        }
    });
}

$(document).ready(function() {

    getCustomer();
    loadLastCart();

    $("#back").on('click', function () {
        window.location.href = "customer.html" + "?username=" + $username;

    });

});