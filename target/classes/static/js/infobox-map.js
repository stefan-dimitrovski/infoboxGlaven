var mymap = L.map('mapid').setView([41.996243, 21.428146], 13);
//pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg'
}).addTo(mymap);

var myObj;
var cafe = [];
var fast_food = [];
var restaurant = [];
var global = this;
var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        myObj = JSON.parse(this.responseText);
        for (let i = 0; i < myObj.length; i++) {
            if (myObj[i].amenity == "cafe") {
                cafe.push(myObj[i]);
            } else if (myObj[i].amenity == "fast_food") {
                fast_food.push(myObj[i]);
            } else if (myObj[i].amenity == "restaurant") {
                restaurant.push(myObj[i]);
            }
        }
    }
};
xmlhttp.open("GET", "https://raw.githubusercontent.com/P1ayer4312/testingStuff/main/leaflet/proekt_public_content.json", true);
xmlhttp.send();
var layerGroup = L.layerGroup().addTo(mymap);
var myIcon = L.divIcon({className: 'my-div-icon', html: '<b>Hello!</b>'});
L.marker([41.9768128, 21.4444199], {icon: myIcon}).addTo(mymap);

function addMarkers() {
    // remove all the markers in one go
    layerGroup.clearLayers();
    if (document.getElementById('choosePlace').value == "cafe") {
        for (let i = 0; i < cafe.length; i++) {
            L.marker([cafe[i].lat, cafe[i].lon]).on('click', function () {
                showInfo(cafe[i])
            }).addTo(layerGroup);
        }
    } else if (document.getElementById('choosePlace').value == "fast_food") {
        for (let i = 0; i < fast_food.length; i++) {
            L.marker([fast_food[i].lat, fast_food[i].lon]).on('click', function () {
                showInfo(fast_food[i])
            }).addTo(layerGroup);
        }
    } else if (document.getElementById('choosePlace').value == "restaurant") {
        for (let i = 0; i < restaurant.length; i++) {
            L.marker([restaurant[i].lat, restaurant[i].lon]).on('click', function () {
                showInfo(restaurant[i])
            }).addTo(layerGroup);
        }
    }
}

var localization = {
    id: "ID_TEMP: ",
    lat: "LAT_TEMP: ",
    lon: "LOT_TEMP: ",
    amenity: "AMENITY_TEMP: ",
    name: "Name: ",
    cuisine: "Cuisine: ",
    addr_street: "Street: ",
    addr_postcode: "Postcode: ",
    building: "Building: ",
    addr_city: "City: ",
    opening_hours: "Opening hour: ",
    internet_access: "Internet access: ",
    addr_housenumber: "House number: ",
    phone: "Phone: ",
    smoking: "Smoking: ",
    outdoor_seating: "Outdoor seating: ",
    website: "Website: ",
    takeaway: "Takeaway: ",
    wheelchair: "Wheelchair: ",
    operator_: "Operator: ",
    email: "Email: ",
    delivery: "Delivery: ",
    drive_through: "Drive trough: ",
    organic: "Organic: ",
    capacity: "Capacity: ",
    payment_mastercard: "Mastercard: "
};

function showInfo(place) {
    var infoArea = document.getElementById("infoArea");
    infoArea.innerHTML = "";
    for (let i in place) {
        // Komentiraj go ovoj if za debug-iranje
        if (i == "id" || i == "lat" || i == "lon" || i == "amenity") continue;
        if (place[i] != null) {
            if (i == "website") {
                infoArea.innerHTML += "<b>" + localization[i] + "</b><a href=" + place[i] + "target=\"_blank\">" + place[i] + "</a><br>";
            } else {
                infoArea.innerHTML += "<b>" + localization[i] + "</b>" + place[i] + "<br>";
            }
        }
    }
}

//L.marker(${userLocation[0]}, fast_food[i].lon]).addTo(mymap);
alert([[${test}]]);