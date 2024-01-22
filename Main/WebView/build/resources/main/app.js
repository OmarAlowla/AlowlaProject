$(document).ready(function () {
    $(".expand-trigger").click(function (e) {
        e.preventDefault();
        showMore.call(this);
    });

    $(".small .recipe-desc").click(function (e) {
        e.preventDefault();
        showMore.call(this);
    });

    function showMore() {
        $("#expand > svg").toggleClass(function () {
            return $(this).hasClass("fa-bars") ? "fa-bars-staggered" : "fa-bars";
        });

        $("#mealCont").toggleClass("small big");
    }

    function getCookie(cookieName) {
        const cookies = document.cookie.split('; ');

        for (const cookie of cookies) {
            const [name, value] = cookie.split('=');

            if (name === cookieName) {
                return decodeURIComponent(value);
            }
        }

        return null;
    }

    function checkAndLogCookie(cookieName) {
        const cookieValue = getCookie(cookieName);

        if (cookieValue !== null) {
            return cookieValue;
        } else {
            console.log(`Cookie "${cookieName}" not found.`);
            return null;
        }
    }

    const cookiesToCheck = ['areas', 'cats', 'randomArray'];



    for (let i = 0; i < cookiesToCheck.length; i++) {
        
        cookiesToCheck[i] = checkAndLogCookie(cookiesToCheck[i]);
    }
    var areas = cookiesToCheck[0].split(',null');
    areas = areas[0].split(',');
    console.log(areas[0]);
    $(".area-select").html(" ");
    for (let i = 0; i < areas.length; i++) {
        $(".area-select").append("<option value='"+areas[i]+"'>"+areas[i]+"</option>");
    }
    var cats = cookiesToCheck[1].split(',null');
    cats = cats[0].split(',');
    
    $(".area-select").html(" ");
    for (let i = 0; i < cats.length; i++) {
        console.log(cats[i]);
        $(".cats-select").append("<option value='"+cats[i]+"'>"+cats[i]+"</option>");
    }
});
