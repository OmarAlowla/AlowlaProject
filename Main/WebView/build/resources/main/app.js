const cookiesToCheck = ['areas', 'cats', 'SearchArray'];
const instructions = [];

$("#expand").click(function (e) {
    e.preventDefault();
    showMore();
});

function showMore() {
    $("#expand > svg").toggleClass("fa-bars fa-bars-staggered");
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

for (let i = 0; i < 10; i++) {
    cookiesToCheck.push("randomArray" + i);
}

for (let i = 0; i < cookiesToCheck.length; i++) {
    cookiesToCheck[i] = checkAndLogCookie(cookiesToCheck[i]);
}

$('.RandomCont').html(" ");

for (let i = 3; i < cookiesToCheck.length; i++) {
    const cookieInfo = cookiesToCheck[i].replaceAll('+', ' ').split(' ,');
    const [name, img, cat, area, yt] = cookieInfo;
    const element = `
        <article class="recipe">
            <div class="pizza-box">
                <img src="${img}" width="1500" height="1368" alt="">
            </div>
            <div class="recipe-content">
                <p class="recipe-tags">
                    <span class="recipe-tag-cat">${cat}</span>
                    <span class="recipe-tag-area">${area}</span>
                </p>
    
                <h1 class="recipe-title"><a>${name}</a></h1>
    
    
                <button class="recipe-save flex" type="button" onclick="window.location.href='${yt}'">
                    <i class="fa-solid fa-play"></i>
                </button>
            </div>
        </article>
    `;
    $('.RandomCont').append(element);
}


$('.searchWrap').html(" ");


const originalArray = cookiesToCheck[2].replaceAll('+', ' ').split(',');


const splitArray = [];
const subArrayLength = 5;
for (let i = 0; i < originalArray.length; i += subArrayLength) {
    const subArray = originalArray.slice(i, i + subArrayLength);
    splitArray.push(subArray);
}

splitArray.forEach(subArray => {
    const [name, img, cat, area, yt] = subArray;
    if (img == '' ||img == ' ' || subArray == '' || subArray == ' ') {
    }
    else{
        const element = `
        <article class="recipe">
            <div class="pizza-box">
                <img src="${img}" width="1500" height="1368" alt="">
            </div>
            <div class="recipe-content">
                <p class="recipe-tags">
                    <span class="recipe-tag-cat">${cat}</span>
                    <span class="recipe-tag-area">${area}</span>
                </p>

                <h1 class="recipe-title"><a>${name}</a></h1>

                <button class="recipe-save flex" type="button" onclick="window.location.href='${yt}'">
                    <i class="fa-solid fa-play"></i>
                </button>
            </div>
        </article>
    `;

    $('.searchWrap').append(element);
    }
});

const parseAndAppendOptions = (targetClass, data) => {
    const items = data.split(',null')[0].split(',');
    $(`.${targetClass}`).html(" ");
    items.forEach(item => $(`.${targetClass}`).append(`<option value='${item}'>${item}</option>`));

};

parseAndAppendOptions("area-select", cookiesToCheck[0]);
parseAndAppendOptions("cats-select", cookiesToCheck[1]);


$(`.area-select`).on('change', function () {
    var selectValue = $(this).val();
    $(".recipe").show();
    $('.recipe-tag-area').each(function () {
        var tagText = $(this).text();
        var parent = $(this).closest('.recipe');
        if (tagText == selectValue) {
            $(parent).show();
            console.log("true");
        } else {
            $(parent).hide();
        }
    });
});

$(`.cats-select`).on('change', function () {
    var selectValue = $(this).val();
    $(".recipe").show();
    $('.recipe-tag-cat').each(function () {
        var tagText = $(this).text();
        var parent = $(this).closest('.recipe');
        if (tagText == selectValue) {
            $(parent).show();
        } else {
            $(parent).hide();
        }
    });
});
$('#showAll').click(function (e) {
    e.preventDefault();
    $(".recipe").show();
});