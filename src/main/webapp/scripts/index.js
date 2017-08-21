var SUCCESS = 0;
var ERROR = 1;

//网页加载后执行的方法
$(function(){
//	console.log('start!');
	//先检查用户名，密码格式
	$('#login').click(loginAction);
	$('.username').on('blur',checkName)
					.on('focus', function(){
						$('.username').empty()
					});
	$('.pwd').on('blur',checkPassword)
					.on('focus',function(){
						$('.pwd').empty()
					});
	
	$('#vlogin').click(visitorLogin);
})

function checkName(){
	var name = $('.username').val();
	if(name == ''){
		$('#errorMsg').empty().append('用户名不能为空');
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(reg.test(name)){
		$('#errorMsg').empty();
		return true;
	}
	$('#errorMsg').empty().append('3~10个字符串');
	return false;
}

function checkPassword(){
	var password = $('.pwd').val();
	if(password == ''){
		$('#errorMsg').empty().append('密码不能为空');
		return false;
	}
	var reg = /^\w{3,16}$/;
	if(reg.test(password)){
		$('#errorMsg').empty();
		return true;
	}
	$('#errorMsg').empty().append('3~16个字符串');
	return false;
}

function loginAction(){
//	console.log('loginAction');
	var adminCode = $('.username').val();
	var password = $('.pwd').val();
	
	var nameOk = checkName();
	var pwdOk = checkPassword();
	if(!nameOk || !pwdOk){
		return false;
	}
}

function visitorLogin(){
	console.log("visitorLogin");
	location.href="/Examination/online-test/visitorLogin.html";
}