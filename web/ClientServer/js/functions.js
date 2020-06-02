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
				console.log("登录成功,返回登录信息");
				var result=JSON.parse(JSON.stringify(msg));
				console.log(result);
				console.log(result.user);
			}
		}
	);
}
