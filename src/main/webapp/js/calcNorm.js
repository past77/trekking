
function caculateNorm()){

    $.post(
        "/norm",
        function(result){
            $('#def_value').html(result);
            $('.plate_table tbody').text("");
        }
    );
}

function calculateNorm(){
    $.post(
        "/nutrition_tracker/norm",
        function(result){
            $('#def_value').html(result);
            $('.plate_table tbody').text("");
        }
    );
}