var timer;
$(window).ready(function(){
	var i = 5;
	timer = setInterval(function(){
		if(i > 0){
			i--;
			$("#seconds").text(i);
		}else{
			clearInterval(timer);
			history.back();
		}
	}, 1000);
});

$(function(){
	$(".back").click(function(){
		clearInterval(timer);
		history.back();
	});
});