package login;
import java.sql.Connection;  
//import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
  
public class mysqltest {  
    // ������̬ȫ�ֱ���  
    static Connection conn;  
  
    static Statement st;  
  
    public static void main(String[] args) 
    {
    	mysqltest sql=new mysqltest();
    }
    public mysqltest(){ 
//    	query();
//        insert();   //������Ӽ�¼  
//        update();   //���¼�¼����  
//        query();
//        delete("\'Gernet\'");   //ɾ����¼  
//        query();    //��ѯ��¼����ʾ  
    }  
      
    /* �������ݼ�¼���������������ݼ�¼��*/  
    public static boolean insert(String str1,String str2) {  
          
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
  
        try {  
            String sql = "INSERT INTO member(username, password)"  
                    + " VALUES ('"+str1+"','"+str2+"')";  // �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    // ��������ִ�о�̬sql����Statement����  
              
            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���  
              
            System.out.println("��member���в��� " + count + " ������"); //�����������Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
            return true;
              
        } catch (SQLException e) {  
            System.out.println("��������ʧ��" + e.getMessage());  
            return false;
        }  
    }  
     
    public static String Check (String str){
    	 conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
         try {  
             String sql = "select *from member where username='"+str+"'";     // ��ѯ���ݵ�sql���  
             st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
               
             ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
             String pw=new String();
             while (rs.next()) { // �ж��Ƿ�����һ������  
                 pw = rs.getString("password");
                 System.out.println(pw);
             }  
             conn.close();   //�ر����ݿ�����    
             return pw;
               
         } catch (SQLException e) {  
             System.out.println("��ѯ����ʧ��");
             return null;
         }  
    }
    //public static void getInformation(String str,String name,String age,String gender,String motto,String lastlogin){
    public static void getInformation(String str,inform i){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
        	 System.out.println(str);
        	 String sql = "select *from information where name='"+str+"'";     // ��ѯ���ݵ�sql���  
             st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            System.out.println(sql);  
            while (rs.next()) { // �ж��Ƿ�����һ������  
                  
            	 i.name=rs.getString("name");
                 i.age=String.valueOf(rs.getInt("age"));
                 i.gender=rs.getString("gender");
                 i.motto=rs.getString("motto");
                 i.lastlogin=rs.getString("lastlogin");
//                 System.out.println(name);
//                 System.out.println(age);
//                 System.out.println(motto); 
              
            }
            System.out.println(sql);  
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("��ѯ����ʧ��");  
        }
    }
    
    
    public static void getDiaryInform(String str,diaryInform di){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
        	di.name=str;
        	 String sql = "select title,time from diary where name='"+str+"'";     // ��ѯ���ݵ�sql���  
             st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            System.out.println(sql); 
            di.number=0;
            while (rs.next()) { // �ж��Ƿ�����һ������  
            	 di.time[di.number]=rs.getString("time");
            	 System.out.println( di.time[di.number]);
            	 di.title[di.number]=rs.getString("title");
            	 System.out.println( di.title[di.number]);
            	 di.number++;
//                 System.out.println(name);
//                 System.out.println(age);
//                 System.out.println(motto); 
              
            }
            System.out.println(sql);  
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("��ѯ����ʧ��");  
        }
    }
    
    
    
    
    public static void getDiary(int i,diaryInform di){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
       	 	 di.selectedTime=di.time[i];
        	 String sql = "select title,text from diary where time='"+di.time[i]+"'and title='"+di.title[i]+"'and name='"+di.name+"'";     // ��ѯ���ݵ�sql���  
             st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            while (rs.next()) { // �ж��Ƿ�����һ������  
            	 di.selectedDiary=rs.getString("text");
            	 di.selectedTitle=rs.getString("title");
            }
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("��ѯ����ʧ��");  
        }
    }
    
    
    
    
    //saveModifiedDiary(name1.getText(),title1.getText(),text1.getText(),tmp_time);
    
    public static void saveModifiedDiary(String n,String title,String text,String time) {  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
        	 Date date = new Date();//���ϵͳʱ��.
             String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
             String now = String.valueOf(nowTime);//��ʱ��ת��
            String sql = "update diary set title='" +title+"',text='"+text+"',time='"+now+"'  where name ='"+n+"' and time='"+time+"'";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("person���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("��������ʧ��");  
        }  
    }  
    
    
    
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/  
    public static void updateLastLogin(String str) {  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
        	 Date date = new Date();//���ϵͳʱ��.
             String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
             String now = String.valueOf(nowTime);//��ʱ��ת��
            String sql = "update information set lastlogin='" +now+"' where name ='"+str+"'";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("person���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("��������ʧ��");  
        }  
    }  
    public static void createInformation(String n){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "insert into information(name) values('"+n+"')";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("person���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("��������ʧ��");  
        } 
    }
    //modifyInformation(age1.getText(),gender1.getText(),motto1.getText());
    public static void modifyInformation(String n,String a,String g,String m){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "update information set age='"+a+"',gender='"+g+"',motto='"+m+" 'where name='"+n+"'";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("person���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("��������ʧ��");  
        } 
    }
    
    
    //saveDiary(name1.getText(),title1.getText(),text1.getText())
    public static void saveDiary(String n,String ti,String te){
    	conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
        	Date date = new Date();//���ϵͳʱ��.
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
            String now = String.valueOf(nowTime);//��ʱ��ת��
            String sql = "insert into diary(name,title,text,time) values('"+n+"','"+ti+"','"+te+"','"+now+"')";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("person���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("��������ʧ��");  
        } 
    }
    
    /* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/  
    public static void query() {  
          
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "select * from person";     // ��ѯ���ݵ�sql���  
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            System.out.println("���Ĳ�ѯ���Ϊ��");  
            while (rs.next()) { // �ж��Ƿ�����һ������  
                  
                // �����ֶ�����ȡ��Ӧ��ֵ   
                int id = rs.getInt("id");  
                String name = rs.getString("name");  
                String age = rs.getString("age"); 
                  
                //����鵽�ļ�¼�ĸ����ֶε�ֵ  
                System.out.println(id+" "+name + " " + age +"\n");  
              
            }  
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��ѯ����ʧ��");  
        }  
    }  
  
    /* ɾ������Ҫ��ļ�¼��������*/  
    public static void delete(String tmp) {  
  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "delete from person  where name = "+tmp;// ɾ�����ݵ�sql���  
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����  
              
            System.out.println("person����ɾ�� " + count + " ������\n");    //���ɾ�������Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("ɾ������ʧ��");  
        }  
          
    }  
      
    /* ��ȡ���ݿ����ӵĺ���*/  
    public static Connection getConnection() {  
        Connection con = null;  //���������������ݿ��Connection����  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/ywd", "root", "123456");// ������������  "root"Ϊ�û�����123456Ϊ����
              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
        }  
        return con; //���������������ݿ�����  
    }  
}  
