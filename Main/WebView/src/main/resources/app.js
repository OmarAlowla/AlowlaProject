$("#expand").click(function (e) { 
    e.preventDefault();
    showMore();
});
$(".small .recipe-desc").click(function (e) { 
    e.preventDefault();
    showMore();
    
});
function  showMore(){
    $("#expand > svg").toggleClass("fa-bars");
    $("#expand > svg").toggleClass("fa-bars-staggered");

    $("#mealCont").toggleClass("small");
    $("#mealCont").toggleClass("big");
}