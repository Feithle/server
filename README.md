# server
        壁纸系统（搭建中）

## 登录成功后

1.  正确地提示√

2.  跳转√

3.  将登录信息更新到登录状态栏√

## 头像以及用户信息的更新 
        不登录就打不开
1. 文字信息的上传

   输入--js获取--发送到controller--存入用户信息表--返回反馈信息--反馈信息显示在页面

2. 头像上传使用jquery

   输入--js获取--发送到controller--存入用户信息表--返回反馈信息--反信息显示在页面

   **出现了问题**
   js获取到图片文件后，把文件传送到后台时，后台并没有检测到文件的存在
   
   **解决的方法**
   
   在网上找一个完整的用js上传图片的示例
   
   1.html部分：
   
   ```html
   <form enctype="multipart/form-data" action="/server/UserOp/updateAvatar.do" method="post">
   </form>
   ```
   
   2.文件保存部分：
   
   ```java
   public class Upload {
    
   	public static Map<String, String> upload(HttpServletRequest request,
   			int maxSize, String path) {
   		
   		//以map形式保存数据 key对应保存的是获取界面上的name名称 value保存的是获取界面上的name对应的值
   		Map<String, String> map = new HashMap<String, String>();
   		Part part = null;
   		try {
   			MultipartParser mrequest = new MultipartParser(request, maxSize);
   			mrequest.setEncoding("utf-8");
   			//遍历所有的part组
   			while ((part = mrequest.readNextPart()) != null) {
   				if (part.isFile()) {  //判断是否是文件
    
   					FilePart filepart = (FilePart) part;//转化成文件组
    
   					String fileName = filepart.getFileName();//得到文件名
    
   					if (fileName != null && fileName.length() > 0) {
   						// 取得扩展名
   						String fileExtName = fileName.substring(
   								fileName.lastIndexOf(".") + 1).toLowerCase();
   						// 只上传图片  //判断图片上传的格式是否符合 后缀名是否有效
   						if (fileExtName.equalsIgnoreCase("jpeg")
   								|| fileExtName.equalsIgnoreCase("png")||
   								fileExtName.equalsIgnoreCase("jpg")
   								|| fileExtName.equalsIgnoreCase("gif")
   								|| fileExtName.equalsIgnoreCase("ico")
   								|| fileExtName.equalsIgnoreCase("bmp")
   								|| fileExtName.equalsIgnoreCase("flv")
   								|| fileExtName.equalsIgnoreCase("mp4")
   								|| fileExtName.equalsIgnoreCase("mp3")) {
    
   							
   							/*String newFileName = new Date().getTime() + "."+ fileExtName;//重新改文件名  文件名+扩展名 */							 
   							
   							String newFileName =new Date().getTime() +fileName;//不改图片名字
   							
   							String newPath = path + "/" + newFileName; //文件处理文件上传的路径
   							File newFile = new File(newPath);
   							
   							filepart.writeTo(newFile);  //将文件真正写入到对应的文件夹中
   							
   							//filepart.getName()  得到 request 要接收的参数的名字
   							
   							map.put(filepart.getName(), newFileName);//把文件信息保存到map中
   							map.put("newFile", newFile.toString());
   						} else {
   							map.put("geshi", "geshi");
   							continue;
   						}// 说明上传的不是图片
   					} else {
    
    			     	map.put("yes","yes");
     
   						continue; // 说明没有选择上传图片
   					}
    
   				} else if (part.isParam()) {  //判断是否是参数
   					ParamPart paramPart = (ParamPart) part;
   					map.put(paramPart.getName(), paramPart.getStringValue());
    
   				}
   			}
    
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
   		return map;
   	}
    
   }
   
   ```
   
   3.路径设置
   
   ```java
   String newPath =this.getClass().getResource("/").getPath().split("out")[0]+"web/ClientServer/avatar/"+ newFileName;
   ```


3. 信息修改使用jquery(尝试一下)

  >不为空的话就更新：
3. 请用户确认要修改的信息
4. 对密码的安全等级进行验证jquery
## 图片加工
## 图片上传 




## 管理系统
### 图片管理系统

### 用户管理系统