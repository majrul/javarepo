package com.lti.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.RegisterM;

//Data Access Object
//Classes which contain Database interaction
//code in Java are commonly referred to as DAO classes
public class RegisterDao {

	public List<RegisterM> select(String city) {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "select * from TBL_REG where city=?";
		    PreparedStatement st = conn.prepareStatement(sql);
		    st.setString(1, city);
		    ResultSet rs=st.executeQuery();
		    
		    List<RegisterM> list=new ArrayList<>();
		    
		    while(rs.next()){
		    	RegisterM m=new RegisterM();
		    	m.setName(rs.getString("name"));
		    	m.setEmail(rs.getString("email"));
		    	m.setPass(rs.getString("password"));
		    	m.setCity(rs.getString("city"));
		    	
		    	list.add(m);
		    }
		   return list; 
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace(); //actually we should check what the error is
		return null; //instead we should throw user defined exception
	}
	finally {
		try { conn.close(); } catch(Exception e) { }
	}
}
	
	public boolean insert(RegisterM rm) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "insert into TBL_REG values(?,?,?,?)";
		    PreparedStatement st = conn.prepareStatement(sql);
		
		    st.setString(1, rm.getName());
		    st.setString(2, rm.getEmail());
		    st.setString(3, rm.getPass());
		    st.setString(4, rm.getCity());
		    st.executeUpdate();
		    
		    return true;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //actually we should check what the error is
			return false; //instead we should throw user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
