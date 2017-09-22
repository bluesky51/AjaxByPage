package com.sky.utils;

import java.sql.Connection;
import java.sql.SQLException;
public class ManagerTransactionUtils {


	//ThreadLocal: 线程局部变量(特点：只有线程才可以访问对应线程的变量)
	//线程唯一标识 threadid  threadlocal....
	private static  ThreadLocal<Connection> threadLocal= new ThreadLocal<>();
	
	public static Connection getConnection() {
		//1.一进入先从当前线程中获取该线程局部变量Connection
		Connection connection = threadLocal.get();
		if (connection==null) {
			//从连接池获取连接
			connection  =  C3P0Utils.getConnection();
			//2.把当前线程获取的局部变量存储到当前线程的局部变量
			threadLocal.set(connection);
		}
		return connection;
	}
	public static void  beginTransaction() {
		 try {
			 getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void  commitTransaction() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void  rollBackTransaction() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
