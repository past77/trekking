
function calcNorm()){

    $.post(
        "/norm",
        function(result){
            $('#def_value').html(result);
            $('.plate_table tbody').text("");
        }
    );
}
