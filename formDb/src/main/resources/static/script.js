function checkData() {
    var num1 = $('#num1').val();
    var num2 = $('#num2').val();

    if ($.isNumeric(num1) && $.isNumeric(num2)) {
        var form = $("form").serializeArray();
        var dataJSON = {};
        $.each(form, function(index, field){
            dataJSON[field.name] = field.value;
        });
        sendPostRequest(dataJSON);
    } else {
      alert("Inserire solo numeri");
      return false;
    }
    return false;
}

function sendPostRequest(dataJSON) {

    $.ajax({
        url: '/form',
        type: 'POST',
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(dataJSON),
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