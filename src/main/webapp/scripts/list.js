var hasSubmit = false;

$(function(){
	
	//倒计时功能30分钟
	var time = parseInt(10);
	interval = setInterval(function(){
		time --;
		if(time > 0){
			var hour = parseInt(time / 3600);
		    var minute = parseInt(time / 60);
		    var seconds = parseInt(time % 60);
			$("title").text("倒计时："+hour+":"+minute+":"+seconds);
		}else{
			//倒计时结束，停止倒计时
			clearInterval(interval);
			//强行提交答题结果
			submit();
		}
	},1000);
	
	//Aptitude标签功能
	$("#aptitude").click(function(){
		$(".errorMsg").hide();
		$(".explain_section").hide();
		$(".submit_section").show();
		//更改tab颜色
		$("#aptitude").attr("class", "blueTab");
		$("#result").attr("class", "greenTab");
	});
	//result标签功能
	$("#result").click(function(){
		//先检查所有是否都选
		if(hasSubmit || check() ){
			$(".errorMsg").show();
			$(".explain_section").show();
			$(".submit_section").hide();
			//更改tab颜色
			$("#aptitude").attr("class", "greenTab");
			$("#result").attr("class", "blueTab");
		}
	});
	
	//提交按钮功能
	$(".submit").click(function(){
		if(check()){
	    	//检查无误，停止计时并提交
	    	clearInterval(interval);
	    	submit();
	    }
	});
})

//检查所有题目是否都选
var check = function(){
	var result=[];
	var selectR = [];
    var name="";
    var isCheck=false;
    //先检查所有选项有没有选
    //遍历单选框，多选框，检查是否有漏选
    $(":radio,:checkbox").each(function(){
        var curName=$(this).attr("name");
        var id = $(this).attr("id");
        if(curName!=name){
        	//若有漏选就加入到result中
            if(name!=""&&!isCheck){
                result.push(name);
            }
            name=curName;
            isCheck=false;
        }
        if($(this).prop("checked")){
        	isCheck=true;
        }
    });
    if(name!=""&&!isCheck){
        result.push(name);
    }
    //若有漏选就弹出提示
    if(result.length>0){
    	alert("请填完所有内容!");
        for(var i=0;i<result.length;i++){
//            console.log(result[i]);
            $("."+result[i]).css("color","red");
        }
        return false;
    }
    return true;
};

//提交答题结果
var submit = function(){
	console.log("submit");
	hasSubmit = true;
	var map = {};
    var name="";
    var str = "";
    var i = 1;
    //遍历单选框，多选框，并将选择结果放入到map中
    $(":radio,:checkbox").each(function(){
        var curName=$(this).attr("name");
        var id = $(this).attr("id");
        if($(this).prop("checked")){
        	map[i] = id;
        	i ++;
        }
    });
    //将map转型为json数据
    str = JSON.stringify(map);
//    console.log("selectR :"+selectR);
//    console.log("str :"+str);
    
    //利用ajax向后台传递答题结果
    $.ajax({
    	type:"POST",
    	url:"checkAnswer.html",
    	data:{
    		str : str
    	},
    	dataType:"json",
    	success:function(data){
    		//发送成功
    		//调用showresult并处理返回数据
    		showResult(data.msg);
    	},
    	error:function(){
//    		alert("error");
    		//若发生错误就跳转到error页面
    		window.location.href="error.html";
    	}
    });
};

//展示结果
var showResult = function(str){
	console.log(str);
	$(".explain_section").show();
	var rightNum = str.rightNum;
	var totalNum = str.totalNum;
	var anNum = str.anNum;
	var ja = str.result;
	$(ja).each(function(i, obj){
//		console.log(obj.answer);
		//展示正确结果
		$("#"+obj.title_id+" .an_context").text(obj.rightAnswer);
		//展示解释
		$("#"+obj.title_id+" .ex_context").text(obj.interpret);
		//标出错误选项
		if(obj.userAnswer != null){
			$("#"+obj.title_id+" #msg"+obj.userAnswer).text("X").css({"color":"red","font-weight": "bold"});
		}
	});
	//更改标题
	$("title").text("考试结果 ："+rightNum+"/"+totalNum);
	//更改tab颜色
	$("#aptitude").attr("class", "greenTab");
	$("#result").attr("class", "blueTab");
	//更改note信息
//	$(".note").text("Marks:"+rightNum+"/"+totalNum).css("text-align","center");
	//隐藏之前的无序列表
	$(".note, .info").hide();
	$(".note_section").hide();
	//隐藏提交按钮
	$(".submit_section").hide();
	
	$(".mark_section").show();
	$("#mark").html("Mark:&nbsp;"+rightNum+"/"+totalNum);
	$("#totalNum").html(":&nbsp;"+totalNum);
	$("#anNum").html(":&nbsp;"+anNum);
	$("#unAn").html(":&nbsp;"+(totalNum-anNum));
	
//	var mark = "<tr><td class='note' colspan='2' style='text-align:center'>Marks:"+rightNum+"/"+totalNum+"</td><td></td></tr>";
//	var row1 = "<tr><td>Total number of questions</td><td>:"+totalNum+"</td></tr>";
//	var row2 = "<tr><td>Number of answered questions</td><td>:"+anNum+"</td></tr>";
//	var row3 = "<tr><td>Number of unanswered questions</td><td>："+totalNum-anNum+"</td></tr>";
//	$(".note_table").append(mark);
//	$(".note_table").append(row1);
//	$(".note_table").append(row2);
//	$(".note_table").append(row3);
//	$("#1Row").text("Total number of questions:"+totalNum);
//	$("#2Row").text("Number of answered questions:"+rightNum);
//	$("#3Row").text("Number of unanswered questions:"+totalNum-anNum);
};