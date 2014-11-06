<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>DiscussNote</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
  
<div id="main_container">
	<div class="parrot"><img src="images/arrow.jpg" alt="" title=""></div>
	
	<div class="main_content">
	
    	<div id="header">
        	<div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0"></a></div>
        </div>	
			
        <div class="top_center_box"></div>
		
        <div class="center_box">
		
            <div id="menu_tab"></div> 
			  
            <div class="middle_box">
            	<div class="middle_box_text_content">
                	<div class="middle_box_title"></div>
						<p class="middle_text">
                   			师生讨论笔记提供给您一个进行多人讨论的平台，能够记录每次讨论的纪要，形成一个具有时间轴的话题，并提供历史讨论查询，统一话题讨论查询。
						</p>
                </div>
            </div>
			 
            <div class="left_content">
            	<div class="calendar_box">
                	<div class="calendar_box_content">
					<br>
                	 <p><span>功能简介</span><br><br>
                   						  –学生记录师生每次讨论的纪要，和所达成的一致性结论；<br>
                   						  –后续讨论的内容和结论需要与之前的讨论建立起追溯关系(例如针对同一个问题的多次讨论)，可以标注出历次讨论的矛盾和不一致之处；<br>
										  –可随时查阅历史讨论纪要，以讨论主题或时间或地点为索引建讨论链条<br>
                                          –1对多的讨论可在多个学生的笔记之间进行分享和同步。 
					</p>	
                	</div>
                </div>
				
				<br><br><br>
            </div><!--end of left content-->
			
			<div id="right_content">
				<form method="post" action="login.action" name="login" class="login" >
					<img src="images/xuxian.jpg" alt="" title=""  >
					
					<h2>Members Login</h2>
					<label>name</label>
					<input name="username" type="text" tabindex="1" id="username" /><br class="spacer" />
					<label>password</label>
					<input name="password" type="text" tabindex="2" id="password" /><br class="spacer" />
					<input name="" type="image" src="images/login_btn.gif" tabindex="3" title="Login" class="loginBtn"/>
					<a href="Register1.jsp" title="register">register now</a> <br class="spacer" />
					<a><strong><font size="3" color="red"><s:property value="message" /></font></strong></a> <br class="spacer" />
					<img src="images/xuxian.jpg" alt="" title="" >
				</form>
			</div>
			
			<div id="footer"></div>
		</div> <!--end of center box-->
	</div> <!--end of main content-->
</div> 
<!--end of main container-->
</body>


</body>
</html>
