package xl.co.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class Application {

	public static void main(String[] args)  throws  Exception{
		//SpringApplication.run(Application.class, args);

		String url_local = "jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV";
		Connection con = DriverManager.getConnection(url_local, "XLUATCONF03", "XLUATCONF03123");
		System.out.println("connection success ..........");
	}

}
