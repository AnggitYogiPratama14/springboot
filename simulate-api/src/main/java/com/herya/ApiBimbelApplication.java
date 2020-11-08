package com.herya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class ApiBimbelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBimbelApplication.class, args);

		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://83.136.216.29:3306/u5543928_webbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "u5543928_adminweb", "smayani1234");
			System.out.println("Connection is successful !!!!");
		} catch(Exception e){
			e.printStackTrace();
		}
	}


}
