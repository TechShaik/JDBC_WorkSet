package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Preparedstatement {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/learn_jdbc";
		String un="root";
		String pass="shaik@1.";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id : ");
		int n=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con=DriverManager.getConnection(url,un,pass);
				String query="select * from emp where id=?";
				PreparedStatement prep=con.prepareStatement(query);
                prep.setInt(1, n);  
                ResultSet res=prep.executeQuery();
                while(res.next()) {
                	System.out.println("Name associated with id number "+n+" is : "+res.getString(2));
                }
                sc.close();
                prep.close();
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
