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

    var datiModulo = $("form").serializeArray();

    var datiJSON = {};
    $.each(datiModulo, function(index, field){
        datiJSON[field.name] = field.value;
    });

    $.ajax({
        url: '/form',
        type: 'POST',
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(datiJSON),
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