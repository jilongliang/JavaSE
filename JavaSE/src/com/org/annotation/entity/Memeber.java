package com.org.annotation.entity;

import com.org.annotation.db.Constrains;
import com.org.annotation.db.SQLInteger;
import com.org.annotation.db.SQLString;
import com.org.annotation.db.TableName;
/**
 *@Date:2015-1-9
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
@TableName(name="T_Memeber")  
public class Memeber {  
    @SQLString(value=30,constrains=@Constrains(allowNull=false)) private String firstName;  
    @SQLString(10) private String lastName;  
    @SQLInteger private int age;  
    @SQLString(value=10, constrains=@Constrains(primaryKey=true,unique=true)) private String handle;  
    @SQLInteger private int level;  
    public String getFirstName() {  
        return firstName;  
    }  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
    public String getLastName() {  
        return lastName;  
    }  
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getHandle() {  
        return handle;  
    }  
    public void setHandle(String handle) {  
        this.handle = handle;  
    }  
    public int getLevel() {  
        return level;  
    }  
    public void setLevel(int level) {  
        this.level = level;  
    }  
      
}  
