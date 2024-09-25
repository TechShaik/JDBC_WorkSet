package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessing {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/learn_jdbc";
		String un="root";
		String pass="shaik@1.";
		Scanner sc=new Scanner(System.in);
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection(url,un,pass);
			PreparedStatement prep=con.prepareStatement("insert into emp values (?,?)");
			while(true) {
			System.out.println("Enter id : ");
			int id=sc.nextInt();
			System.out.println("Enter name : ");
			String name=sc.next();		
			prep.setInt(1, id);
			prep.setString(2, name);
			prep.addBatch();
 			System.out.println("Want to enter more details ? select y/n");
			String des=sc.next();
			if(des.equalsIgnoreCase("n")) {
				break;
			}
							
			
			}
			int[] batchResult =prep.executeBatch();
			System.out.println("Data inserted Successfullly "+batchResult.length+" rows effected");
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
