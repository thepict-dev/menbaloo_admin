// AOS
AOS.init();
// 네비 엑티브
var pageUrl = window.location.href; 
$(window).on('load', function(){ 
    $('.nav').siblings('a').removeClass('active');
    if (pageUrl.indexOf('business') > -1) {
        $('.nav').eq(0).addClass('active');
    } else if (pageUrl.indexOf('faq') > -1) {
        $('.nav').eq(1).addClass('active');
    } else if (pageUrl.indexOf('notice') > -1) {
        $('.nav').eq(2).addClass('active');
    } else if (pageUrl.indexOf('account') > -1) {
        $('.nav').eq(3).addClass('active');
    } else if (pageUrl.indexOf('noti') > -1) {
        $('.nav').eq(4).addClass('active');
    };
});
// 헤더 스크롤
let scrUp ="";
let scrDown ="";

$(window).scroll(function() {
    setTimeout(function(){
        scrUp = $(window).scrollTop();
    }, 10);
    setTimeout(function(){
        scrDown = $(window).scrollTop();
    }, 20);

    setTimeout(function(){
        if(scrUp > scrDown){
            $("header").css('top', 0);
        }
        if(scrUp < scrDown){
            $("header").css('top', '-140px');
        }
    }, 20);
});

// 모바일 네비
$(".mbHeader > button").click(function(){
    $(".mbNav").fadeToggle().css("display", "flex");
});

//팝업존 스와이퍼
$(function(){
    //main visual slide
    var mainSlide = new Swiper('.swiper', {
        autoplay: {
            delay: 2000 // 자동으로 화면 전환
        },
        slidesPerView: 1,	// 화면에 보여주는 이미지 개수
        loop: true,	// 무한 루프 적용
        pagination: {	// 하단에 점 표시 적용
            el: '.swiper-pagination',
            clickable: 'true',
        },
        speed: 1000,
    });
});
// 명산리스트 스와이퍼
// 명산리스트 스와이퍼
$(function(){
    //main visual slide
    var subSlide = new Swiper('.swiper02', {
        autoplay: {
            delay: 1000 // 자동으로 화면 전환
        },
        pagination: false,
        slidesPerView: 4.5,	// 화면에 보여주는 이미지 개수
        loop: true,	// 무한 루프 적용
        speed: 1000,
        breakpoints: {
            0: {
            	slidesPerGroup : 1,
                slidesPerView: 1.7,
                spaceBetween: 20,
            },
            769: {
              slidesPerGroup : 1,
              slidesPerView: 2.5,  //브라우저가 768보다 클 때
              spaceBetween: 20,
            },
            1025: {
              slidesPerGroup : 1,
              slidesPerView: 3.5,  //브라우저가 1024보다 클 때
              spaceBetween: 20,
            },
        }
    });
});
// 탭


// 모바일 셀렉트 탭
// for (const option of document.querySelectorAll(".custom-option")) {
//     option.addEventListener('click', function() {
//         if (!this.classList.contains('selected')) {
//             this.parentNode.querySelector('.custom-option.selected').classList.remove('selected');
//             this.classList.add('selected');
//             this.closest('.select').querySelector('.select__trigger span').textContent = this.textContent;
//         }
//     })
// }

// 탭 클릭 컨텐츠 슬라이드 업
// $('.tabNav > li').click(function(){
//     $('.intro').css('top', '0');
// })