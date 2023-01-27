import java.sql.*;
import java.sql.ResultSet;
import javax.swing.*;

public class JdbcConn{
	public static String User="",Pass="",Nam="",Ag="",Prof="";
	String Ustring,Pstring;
	byte flag=0;
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public void getConnection(){
	try {
		
		String username="root";
		String password="1234";
		String url="jdbc:mysql://localhost:3306/mydatabase";	
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn=DriverManager.getConnection(url,username,password);
		stmt=conn.createStatement();	
	}
	catch(Exception e){
		System.err.println("Cannot connect to database server"+e);
		close();
	}
	}
	
	public void insert(){
	try{			
		getConnection();
		JFrame frame=new JFrame();
		String searchUser="select * from register where Username=?";
		pstmt=conn.prepareStatement(searchUser);
		pstmt.setString(1,User);
		rs=pstmt.executeQuery();
		if(rs.next()){
			JOptionPane.showMessageDialog(frame,"The Username Already Exists!","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
		String QryString="insert into register (Name,Age,Profession,Username,Password) values (?,?,?,?,?)";
		pstmt=conn.prepareStatement(QryString);
		pstmt.setString(1,Nam);
		pstmt.setString(2,Ag);
		pstmt.setString(3,Prof);
		pstmt.setString(4,User);
		pstmt.setString(5,Pass);
		pstmt.executeUpdate();
		
		JOptionPane.showMessageDialog(frame,"Registration Successful!","Message",JOptionPane.INFORMATION_MESSAGE);
		Register.p2.setVisible(false);
		LoginPage.p1.setVisible(true);

		}
	}
	catch(SQLException ex){
		System.out.println("SQLException: "+ex.getMessage());
		System.out.println("SQLSet: "+ex.getSQLState());
		System.out.println("VendorError: "+ex.getErrorCode());
		close();
	}
	}

	public void compare(){
		try{
			getConnection();
			JFrame frame=new JFrame();		
			String searchUser="select * from register where Username=? and Password=?";
			pstmt=conn.prepareStatement(searchUser);
			pstmt.setString(1,User);
			pstmt.setString(2,Pass);
			rs=pstmt.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(frame,"Login Successful!","Message",JOptionPane.INFORMATION_MESSAGE);
				LoginPage.p1.setVisible(false);
				Main.inst();
				Main.p6.setVisible(true);
				
			}
			else
				JOptionPane.showMessageDialog(frame,"Invalid Username or Password!","Error",JOptionPane.ERROR_MESSAGE);			
		}
		catch(SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
			close();
		}
	}

	public void update(){
		try{
			getConnection();
			JFrame frame=new JFrame();
			String QryString="update register set Name=?,Age=?,Profession=?,Password=? where Username=?";
			pstmt=conn.prepareStatement(QryString);
			pstmt.setString(1,Nam);
			pstmt.setString(2,Ag);
			pstmt.setString(3,Prof);
			pstmt.setString(4,Pass);
			pstmt.setString(5,User);
			pstmt.executeUpdate();
		
			JOptionPane.showMessageDialog(frame,"Profile updated successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
			Register.p2.setVisible(false);
			Main.p6.setVisible(true);
		}
		catch(SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
			close();
		}
	}

	public void getData(){
		try{
			getConnection();
			String searchUser="select * from register where Username=? and Password=?";
			pstmt=conn.prepareStatement(searchUser);
			pstmt.setString(1,User);
			pstmt.setString(2,Pass);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Nam=rs.getString(1);
				Ag=rs.getString(2);
				Prof=rs.getString(3);
				User=rs.getString(4);
				Pass=rs.getString(5);
			}
			
		}
		catch(SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
			close();
		}
	}

	public void close(){
		if(rs!=null){
			try{
				rs.close();
			}
			catch (SQLException SQLex){}//ignore
			rs=null;
		}
		if(stmt!=null){
			try{
				stmt.close();
			}
			catch (SQLException SQLex){}//ignore
			stmt=null;
		}
		if(conn!=null){
			try{
				conn.close();
			}
			catch(Exception e){}//ignore close errors
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}
			catch(Exception e){}//ignore close errors
		}
	}
}
