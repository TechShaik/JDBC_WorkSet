package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionHandling {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/learn_jdbc";
		String un="root";
		String pass="shaik@1.";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your acc : ");
		int my_acc=sc.nextInt();
		System.out.println("Enter amount to send : ");
        int amnt=sc.nextInt();
		System.out.println("Enter creider acc : ");
        int c_acc=sc.nextInt();
        System.out.println();
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con=DriverManager.getConnection(url,un,pass);
				con.setAutoCommit(false);
				String deposit="update bank set balance=balance+? where acc=? ";
				String withdraw="update bank set balance=balance-? where acc=?";
				PreparedStatement pd=con.prepareStatement(deposit);
				PreparedStatement pw=con.prepareStatement(withdraw);
				pd.setInt(1, amnt);
				pd.setInt(2, c_acc);
				pw.setInt(1, amnt);
				pw.setInt(2, my_acc);
				int depAffect=pd.executeUpdate();
				int creAffec=pw.executeUpdate();
				 if(creAffec>0 && depAffect>0) {
					 con.commit();
					 System.out.println("Transaction Successfull..!!!!");
				 }else {
					 con.rollback();
					 System.out.println("Transaction failed");
				 }
				sc.close();
				pd.close();
				pw.close();
				con.close();
			} catch (SQLException e) {
 				
                
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
