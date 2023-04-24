let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides((slideIndex += n));
}

function currentSlide(n) {
    showSlides((slideIndex = n));
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");

    if (n > slides.length) {
        slideIndex = 1;
    }

    if (n < 1) {
        slideIndex = slides.length;
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
}



var container = document.getElementById('map');
var options = {
    center: new kakao.maps.LatLng(37.5617825, 126.8353476),
    level: 8
};

var map = new kakao.maps.Map(container, options);


var markerPosition = new kakao.maps.LatLng(37.5617825, 126.8353476);
var marker = new kakao.maps.Marker({
    position: markerPosition
});


marker.setMap(map);