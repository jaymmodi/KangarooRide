function sendDate() {
    var date = $('#datepicker').val();
    $.ajax({
        method: "GET",
        url: '/getSlots',
        data: {
            date: date,
        },
        success : function(data){
            $('#timeSlots').empty();
            $.each(data, function(key, value) {
                $('#timeSlots')
                    .append($("<option></option>")
                        .attr("value",value)
                        .text(value));
            });
        }
    });
}