# server
        壁纸系统（搭建中）

## 登录成功后

1.  正确地提示√

2.  跳转√

3.  将登录信息更新到登录状态栏√

## 头像以及用户信息的更新 6/8
        不登录就打不开
1. 文字信息的上传

   输入--js获取--发送到controller--存入用户信息表√--返回反馈信息--反馈信息显示在页面 **7/23**

   

   

2. 头像上传使用jquery

   输入--js获取--发送到controller--存入用户信息表--返回反馈信息--反馈信息显示在页面

   存入用户信息表：把头像存储路径存储在数据库表中（**7/23**未测试）

   

   **出现了问题（7/28）**，在`applicationContext.xml`中设置了mapper文件（写有sql的文件）的文件路径，但它只能指定一个dao，而不是对应整个dao中的接口。采用在接口函数上直接写入sql的方法依然需要在`applicationContext.xml`中说明（解决）

   

   测试结果：文字信息正常，存入头像路径到数据库时发生错误，mapper中的path_avatar变量找不到。

3. 信息修改使用jquery(尝试一下)

  >不为空的话就更新：
3. 请用户确认要修改的信息
4. 对密码的安全等级进行验证jquery
## 图片加工
## 图片上传 6/8


## 管理系统
### 图片管理系统

### 用户管理系统

