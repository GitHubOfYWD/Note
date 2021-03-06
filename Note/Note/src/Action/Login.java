package Action;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.Action;


public class Login implements Action{
	public String username=new String();
	public String password=new String();
	public String message=new String();
	public String newinvitation=new String();
	public List<FavoriteMessage>fm;
	public List<UserTopic> ht;
	public List<UserTopic> it;
	
	
	public void setFm(List<FavoriteMessage> fm){
		this.fm=fm;
	}
	public List<FavoriteMessage> getFm(){
		return this.fm;
	}
	public void setNewinvitation(String newinvitation){
		this.newinvitation=newinvitation;
	}
	public String getNewinvitation(){
		return this.newinvitation;
	}
	public void setIt(List<UserTopic> it){
		this.it=it;
	}
	public List<UserTopic> getIt(){
		return this.it;
	}
	
	public void setHt(List<UserTopic> ht){
		this.ht=ht;
	}
	public List<UserTopic> getHt(){
		return this.ht;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	public String getMessage(){
		return this.message;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}

	/*public String Login(){
		Mysql sql=new Mysql();
		System.out.println(password);
		ht=new ArrayList<UserTopic>();
		it=new ArrayList<UserTopic>();
		if(sql.Login(username,password).equals("success")){
			message="login success";
			if(sql.HasInvitation(username).equals("yes")){
				newinvitation="你收到了新的邀请";
			}
			else{
				newinvitation="";
			}
			System.out.println(message);
			sql.UserTopic(username,ht,it);
			System.out.println("here");
			return "login success";
		}
		else{
			message="the username doesn't exist or the password is not correct";
			return "login fail";
		}
	}*/
	
	public String Register(){
		return "go to register";
	}
	
	public String execute() throws Exception {
		Mysql sql=new Mysql();
		System.out.println(password);
		ht=new ArrayList<UserTopic>();
		it=new ArrayList<UserTopic>();
		if(sql.Login(username,password).equals("success")){
			message="login success";
			if(sql.HasInvitation(username).equals("yes")){
				newinvitation="你收到了新的邀请";
			}
			else{
				newinvitation="";
			}
			System.out.println(message);
			sql.UserTopic(username,ht,it);
			System.out.println("here");
			fm=new ArrayList<FavoriteMessage>();
			sql.ShowFavorite(username,fm);
			return "login success";
		}
		else{
			message="the username doesn't exist or the password is not correct";
			return "login fail";
		}
	}
}

class UserTopic{
	public String username=new String();
	public String host=new String();
	public String topic=new String();
	public String flag=new String();
}
class FavoriteMessage{
	public String username=new String();
	public int id;
	public int parentid;
	public String author=new String();
	public String host=new String();
	public String topic=new String();
	public String message=new String();
	public String time=new String();
}