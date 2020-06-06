/**
 * 
 */
function regist(){
	$.ajax(
	{
		type:"POST",
		dataType:"JSON",
		async:false,
		url:'http://localhost:8080/server/UserOp/regist.do',
		data:{
			"method":"regist",
			"email":document.getElementById("user_email").value,
			"password":document.getElementById("user_password").value,
			
		},
		success:function(){
			console.log("注册成功，查看数据库");
			window.location.href="http://localhost:8080/server/ClientServer/login.html"; 
		}
	}		
	);
}

/**
 * 注册后把注册成功后的信息填充到登录框
 * @constructor
 */
function Loadusermessage(){
	$.ajax(
	{
		type:"POST",
		dataTyp:"text",
		url:'http://localhost:8080/server/UserOp/fillInputTag.do',
		data:{
			"method":"Loadusermessage",
		},
		success:function(msg){
			var resultOfUser=JSON.parse(msg)
			document.getElementById("user_email").value=msg.email;
			document.getElementById("user_password").value=msg.password;
			//填充输入框

		},
	      error: function(e) {
              console.log("返回错误")
          }
	}		
	);
}


function login(){

	$.ajax(
		{
			type:"POST",
			dataType:"JSON",
			async:false,
			url:'http://localhost:8080/server/UserOp/login.do',
			data:{
				"method":"login",
				"email":document.getElementById("user_email").value,
				"password":document.getElementById("user_password").value,

			},
			success:function(msg){
				var result=JSON.parse(JSON.stringify(msg));
				console.log(result)
				//提示登录成功结果
				alert(result.msg)
				//点击提示里的确定按钮后跳转到网站的首页
				window.location.replace("index.html")
				//首页加载时顺便加载一下登录状态栏
			}
		}
	);
}

/**
 * 首页和其他页面需要加载登录状态时使用该方法
 */
function useCookieToChangePage(){

	$.ajax(
		{
			type:"POST",
			dataTyp:"JSON",
			async:false,
			url:'http://localhost:8080/server/UserOp/loadStatue.do',
			data:{
				"method":"cookieChangePage",
			},
			success:function(msg){
				var jsonResult=JSON.parse(JSON.stringify(msg));//解析一下从servlet中传过来的JSON
				console.log(jsonResult);
				if(jsonResult.email==""||jsonResult.email==null){
					console.log("后台的回复是user,但user中的email是空的")
				}else{
					document.getElementById("loginstatue_before").style.display="none";
					var afterdiv=document.getElementById("loginstatue_after");
					afterdiv.style.display="block";
					var emailspan=document.getElementById("useremai_span");
					emailspan.innerHTML=jsonResult.email;
					var img=document.getElementById("pathofavatar");//获得img标签
					if(jsonResult.path_avatar==null||jsonResult.path_avatar==""){
						img.src="avatar/avatar_deafault.jpg";
					}else{
						img.src=jsonResult.path_avatar;
					}
					console.log("---end-----");
				}
			},
			error: function(e) {
				console.log("返回错误");
			}
		}
	);
}