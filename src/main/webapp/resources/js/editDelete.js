/**
 * Created by jmmodi on 11/15/2015.
 */

$(".delete_button").click(function () {
    var row = $(this).closest("tr");
    var user_id = row.find(".user_id").text();
    var ride_date = row.find(".ride_date").text();
    var ride_time = row.find(".ride_time").text();

    row.remove();

    $.ajax({
        method: "POST",
        url: '/deleteRegistration',
        data: {
            user_id: user_id,
            ride_date: ride_date,
            ride_time: ride_time
        },
        success: function (res) {
        }
    });
});
