function checkData() {
    var num1 = $('#num1').val();
    var num2 = $('#num2').val();

    if ($.isNumeric(num1) && $.isNumeric(num2)) {
        sendPostRequest(num1, num2);
    } else {
      alert("Inserire solo numeri");
      return false;
    }
    return false;
}


function sendPostRequest(val1, val2) {

    let num = {val1: val1, val2: val2};
    console.log(JSON.stringify(num));

    $.ajax({
        url: '/form',
        type: 'POST',
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(num),
        success: function (result) {
            $('#result').text(result.result);

        },
        error: function () {
            alert('Errore nella richiesta POST.');
        }
    });
}

    function calcAvg() {
        $.ajax({
                url: '/avg',
                type: 'GET',
                dataType: "json",
                success: function (data) {
                    $('#avg').text(data.avg);
                },
                error: function () {
                    alert('Errore nella richiesta GET.');
                }
            });
    }
//    function listData() {
//            $.ajax({
//                    url: '/listFileData',
//                    type: 'GET',
//                    success: function (data) {
//                        $('#listData').text(data);
//
//                    },
//                    error: function () {
//                        alert('Errore nella richiesta GET (file).');
//                    }
//                });
//    }