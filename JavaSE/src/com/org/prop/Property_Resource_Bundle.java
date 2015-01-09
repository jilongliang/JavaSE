package com.org.prop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.PropertyResourceBundle;

/**
 *@Author:jilongliang
 *@Date  :2013-4-18
 *@Project:JavaSE
 *@Class:Property_Resource_Bundle.java
 *@Description:
 */
@SuppressWarnings("all")
public class Property_Resource_Bundle {
	static Property_Resource_Bundle prb=null;// 配置资源文件
	private PropertyResourceBundle bundle; 
    private String URL="";//url
    private String Driver="";//driver
	private static Connection conn = null; // 连接对象
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null;
	
	public static void main(String[] args)throws Exception { 
		System.out.println(new Property_Resource_Bundle().getString("jdbc.url"));
		
	}
	
	
	/**
	 * 私有构造函数,不可实例化
	 */
	private Property_Resource_Bundle() {
		try {
			// 读取配置文件
			bundle = new PropertyResourceBundle(SQLHelper.class.getResourceAsStream("/prop/jdbc.properties"));
			this.URL=getString("jdbc.url");
			this.Driver=getString("jdbc.driver");
			String databese_type = getString("jdbc.dbtype"); // 读取数据库类型
			if (databese_type != null) // 如果类型不为空
			{
				// 设置mysql数据库的驱动程序和连接字符
				if (databese_type.toLowerCase().equals("mysql")) {
					Driver = Driver;
					URL = URL;
				//设置oracle数据库的驱动程序和连接字符
				} else if (databese_type.toLowerCase().equals("oracle")) {
					Driver = Driver;
					URL = URL;
				//设置sqlserver2000数据库的驱动程序和连接字符
				} else if (databese_type.toLowerCase().equals("MSSQL2000")) {
					Driver = Driver;
					URL = URL;
				//设置sqlserver2005数据库的驱动程序和连接字符
				} else if (databese_type.toLowerCase().equals("MSSQL2005")) { 
					Driver = Driver;
					URL = URL;
				}
			}
		} catch (Exception e) {
			System.err.println("SqlManager Error!" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 单态模式获取实例
	 * @return SqlManager对象
	 */
	public static Property_Resource_Bundle createInstance() {
		if (prb == null) {
			prb = new Property_Resource_Bundle();
			prb.initDB();
		}
		return prb;
	}

	/**
	 * 初始化连接参数，由指定的DBType生成
	 */
	public void initDB() {
		try {
			Class.forName(Driver);
		} catch (Exception e) {
			System.err.println("initDB Error!" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("成功加载驱动类！");
	}
	/**
	 * 读取配置文件中的值
	 * 
	 * @param key
	 *            配置文件的key
	 * @return key对应的值
	 */
	private String getString(String key) {
		return this.bundle.getString(key);
	}
	
}
