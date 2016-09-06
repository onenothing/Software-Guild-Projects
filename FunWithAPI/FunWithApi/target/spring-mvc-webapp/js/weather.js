

$(document).ready(function (event) {
    
    $('#zip-button').click(function (event) {
        $('#contentRows').text('');
        event.preventDefault();
        var zipCode = $('#add-zip-code').val();
        var openWeather = "http:/" + "/api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&units=imperial&appid=110b4054c57d0a3858e8eb8104e95799";
        $.get(openWeather, function (data, status) {
            fillContents(data, status);
        });
    });
});

function fillContents(data, status) {

    var contentRows = $('#contentRows');
    contentRows.append(data.name + "<br/>");
    contentRows.append(data.main.temp + '°F');
    $.each(data, function (index, openWeather) {
//        var weather = openWeather.weather[0].description;
//        var temp = openWeather.main.temp;
        var divs = '<div>';
//        console.log(openWeather);

//        $('#weather_temp').text(openWeather.main.temp);
//        $('#weather_description').text();
    });
}
