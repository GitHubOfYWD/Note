<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>讨论</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="main_container">
	<div class="parrot"><img src="images/arrow1.gif" alt="" title=""></div>
	
	<div class="main_content">
	
    	<div id="header">
        	<div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0"></a></div>
        </div>	
			
        <div class="top_center_box"></div>
		
		<div class="center_box">
		
            <div id="menu_tab"></div> 
			
			
			 
			 <div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
                	 <s:form>
						<tr><td><strong><font size="5"><s:property value="topic" /></font></strong></td></tr>
						<!-- <tr><td><strong><font size="5"><s:property value="username" />的观点</font></strong></td></tr> -->
					</s:form>
					
					<s:form>
					<tr><td><s:a href="topic_GoPublish.action?username=%{username}&password=%{password}&topic=%{topic}&host=%{host}&parentid=%{parentid}">增加新的结论</s:a><tr><td>
					</s:form>
					<!--
					<s:form>
					<a><strong><font size="2">邀请组员</font></strong></a> <br class="spacer" />
					</s:form>
					<s:form action="topic_SentInvitation" theme="simple">
					<s:textfield name="username" label="用户：" value="%{username}" style="display:none"/>
					<s:textfield name="password"   value="%{password}" style="display:none"/>
					<s:textfield name="topic" label="话题：" value="%{topic}" style="display:none"/>
					<s:textfield name="host" value="%{host}" style="display:none"/>
					<s:textfield name="author" value="%{author}" style="display:none"/>
					<s:textfield name="parentid" value="%{parentid}" style="display:none"/>
					<s:textfield name="invitename" label="用户名" value=""/>
					<s:submit style="width:100px" value="邀请"/>
					</s:form>
					<s:form>
					<tr><td><strong><font size="3" color="red"><s:property value="message" /></font></strong></td></tr>
					</s:form>	
					  -->			
                </div>
				
            </div><!--end of left content-->
			
            
            
            
            
            <div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
					<s:form>
                	 <s:iterator value="tmm">
                     	  <s:textfield name="parentmessage" value="%{message}" style="display:none"/>
                     	  <tr><td colspan="4"><font size="5" color="red"><s:property value="author"/>&nbsp &nbsp</font><font size="3" color="black"><s:property value="message"/></font></td></tr>
                      	 <tr><td colspan="4">**********************************************************************************************</td></tr>
   					 </s:iterator>	
   					 </s:form>
   					 <form>
	   					 <tr>
      					    <td><s:a href="login.action?username=%{username}&password=%{password}">主页</s:a></td>
      					    <td><a href="javascript:history.go(-1)" target=_self>返回</a></td>
     					  </tr>
							
   					 </form>		
                </div>
				
            </div><!--end of left content-->
			
			
			
			
			<div id="footer"></div>
		</div> <!--end of center box-->
		
	</div> <!--end of main content-->
</div> 
<!--end of main container-->
</body>
</html>
