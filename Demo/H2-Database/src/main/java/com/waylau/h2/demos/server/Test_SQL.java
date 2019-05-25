package com.waylau.h2.demos.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * 说明：内嵌模式下的性能测试
 */

public  class Test_SQL{

	private static final Logger logger = LogManager.getLogger();
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;
	String sql = null;
	private Connection conn;
	int count = 0;
	long timeStart = 0;
	long timeEnd = 0;
	long longTime = 0;
	int countLong = 36;


	// 构造方法
	public Test_SQL() throws ClassNotFoundException, SQLException {
		System.err.println("构造方法已经启动");
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
		statement = conn.createStatement();
	}


	// 创建一个数据表
	@Test
	public void Creat_New_Database() throws SQLException {
		try {
			// 创建测试表
			statement.executeUpdate("DROP TABLE IF EXISTS TEST;");

			//  id + name + password + age
			statement.executeUpdate("CREATE TABLE TEST(`id` INT PRIMARY KEY, `name` VARCHAR(255), `password` VARCHAR(255) , `age` VARCHAR(255));");
		} finally {
			if (preparedStatement != null) {
//				System.err.println("preparedStatement.close.....yxb..");
//				preparedStatement.close();
			}
			if (statement != null) {
//				System.err.println("statement.close.....-_-");
//				statement.close();
			}
			if (rs != null) {
//				System.err.println("rs.close...YXB...");
//				rs.close();
			}
		}
	}


	// Select_All
	@Test
	public void Select_All() throws SQLException {
		// QUERY 性能测试
		timeStart = System.currentTimeMillis();

		sql = "SELECT * FROM TEST;";
		rs = statement.executeQuery(sql);


		if (!rs.next()){
			System.err.println("没有查询到数据...............");
		}else {
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		}

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println( "QUERY TIME:" + longTime );
		System.err.println( "rs:" + rs.toString() );
	}


	// Insert__addBatch   性能测试
	@Test
	public void Insert__addBatch() throws SQLException {
		timeStart = System.currentTimeMillis();

		sql = "INSERT INTO TEST VALUES(?,?,?,?);";

		preparedStatement = conn.prepareStatement(sql);

		for (int i=0; i< countLong; i++){
			preparedStatement.setInt(1, i+1);
			preparedStatement.setString(2, "name__"+i);
			preparedStatement.setString(3, "password__"+i);
			preparedStatement.setString(4, "age__"+i);

			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();
		preparedStatement.clearBatch();

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println("INSERT PreparedStatement addBatch TIME--->   " + longTime );
	}




	@Test
	public void Delete_Test() throws SQLException {
		// DELETE 性能测试
		timeStart = System.currentTimeMillis();

		String sql = "DELETE TEST WHERE  NAME='waylau';";
		count = statement.executeUpdate(sql);

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println( "DELETE TIME:" + longTime );
		System.err.println( "count:" + count );
	}


	@Test
	public void Insert_Test() throws SQLException {
		// INSERT Statement 性能测试
		timeStart = System.currentTimeMillis();

		for (int i=0; i< countLong; i++){
			int j = i+1;
			sql = "INSERT INTO TEST VALUES(" + j + ",'waylau','waylau','waylau','waylau','waylau' ,'waylau','waylau','waylau','waylau','waylau');";
			statement.executeUpdate(sql);
		}

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println( "INSERT Statement TIME:" + longTime );
	}



	//  Update_Test
	@Test
	public void Update_Test() throws SQLException {
		// UPDATE 性能测试
		timeStart = System.currentTimeMillis();

		sql = "UPDATE  TEST SET  NAME='waylau';";
		count = statement.executeUpdate(sql);

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println( "UPDATE TIME:" + longTime );
		System.err.println( "count:" + count );
	}





	// INSERT PreparedStatement
	@Test
	public void Insert_2() throws SQLException {
		// INSERT PreparedStatement 性能测试
		timeStart = System.currentTimeMillis();
		sql = "INSERT INTO TEST VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		preparedStatement = conn.prepareStatement(sql);

		for (int i=0; i< countLong; i++){
			preparedStatement.setInt(1, i+1);
			preparedStatement.setString(2, "20000"+1);
			preparedStatement.setString(3, "20000"+1);
			preparedStatement.setString(4, "20000"+1);
			preparedStatement.setString(5, "20000"+1);
			preparedStatement.setString(6, "20000"+1);
			preparedStatement.setString(7, "20000"+1);
			preparedStatement.setString(8, "20000"+1);
			preparedStatement.setString(9, "20000"+1);
			preparedStatement.setString(10, "20000"+1);
			preparedStatement.setString(11, "20000"+1);

			count = preparedStatement.executeUpdate();
			preparedStatement.clearParameters();
		}

		timeEnd = System.currentTimeMillis();
		longTime = timeEnd - timeStart;

		System.err.println( "INSERT PreparedStatement TIME:" + longTime );
	}




}