package id.co.xl.checkbalancebj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.Connection;
import java.sql.DriverManager;

@EnableAsync
@SpringBootApplication(scanBasePackages = {
		"id.co.xl.checkbalancebj"
})
public class Application {

	public static void main(String[] args)  {
				SpringApplication.run(Application.class, args);

		/*ini adalah contoh koneksi ke DB*/
		/*String url_local = "jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV";
		Connection con = DriverManager.getConnection(url_local, "XLUATCONF03", "XLUATCONF03123");
		System.out.println("connection estabilished ..........");
*/



	}

}
