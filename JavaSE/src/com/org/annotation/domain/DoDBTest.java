package com.org.annotation.domain;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.org.annotation.db.Constrains;
import com.org.annotation.db.SQLInteger;
import com.org.annotation.db.SQLString;
import com.org.annotation.db.TableName;

/**
 * 参考博客：http://hwy1782.iteye.com/blog/1827161
 *@DEMO:JavaSE
 *@Java：DoAbout.java
 *@Date:2015-1-9下午3:51:21
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
public class DoDBTest {
	public static void main(String[] args) {
		String[] classNames = {"com.org.annotation.entity.Memeber"};
		try{
			for(String className : classNames){
				Class cl = Class.forName(className);
				TableName dbTable = (TableName) cl.getAnnotation(TableName.class);
				if(dbTable == null)
					continue;
				String tableName = dbTable.name();
				if(tableName.length() <= 0){
					tableName = cl.getSimpleName();
				}
				List<String> columnNames = new ArrayList<String>();
				for(Field field : cl.getDeclaredFields()){
					String columnName = "";
					Annotation[] annotations = field.getDeclaredAnnotations();
					if(annotations.length <= 0)
						continue;
					if(annotations[0] instanceof SQLInteger){
						SQLInteger tmpSqlInt = (SQLInteger)annotations[0];
						columnName = tmpSqlInt.name();
						if(columnName.length() <= 0){
							columnName = field.getName()+" integer";
						}
						String constrain = getConstraon(tmpSqlInt.constrain());
						columnName += constrain;
					}
					if(annotations[0] instanceof SQLString){
						SQLString tmpSqlStr = (SQLString)annotations[0];
						columnName = tmpSqlStr.name();
						if(columnName.length() <= 0){
							columnName = field.getName();
						}if(tmpSqlStr.value() > 0){
							columnName += " varchar("+ tmpSqlStr.value()+") ";
						}
						String constrain = getConstraon(tmpSqlStr.constrains());
						columnName += constrain;
					}
					columnNames.add(columnName);
				}
				String sqlCreat = "CREATE TABLE "+ tableName +" ( \n";
				String createCommond = "";
				for(String str : columnNames){
					createCommond += str +",\n";
				}
				sqlCreat += createCommond +" ) ";
				System.out.println(sqlCreat);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @param constrain
	 * @return
	 */
	private static String getConstraon(Constrains constrain) {
		String rst = "";
		if(!constrain.allowNull()){
			rst += " NOT NULL ";
		}
		if(constrain.primaryKey()){
			rst += " primarykey ".toUpperCase();
		}
		if(constrain.unique()){
			rst += " unique ".toUpperCase();
		}
		return rst;
	}
	
}
