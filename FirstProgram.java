package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstProgram {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/learn_jdbc";
		String un="root";
		String pass="shaik@1.";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con=DriverManager.getConnection(url,un,pass);
				           Statement s=con.createStatement();
				          String q="select * from emp";
				          ResultSet res=s.executeQuery(q);
				           
				          while(res.next() ) {
				        	  System.out.println("Id is: "+res.getInt(1)+" and Name is: "+res.getString(2));
				          }
                              res.close();
                              s.close();
                              con.close();
                              
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
