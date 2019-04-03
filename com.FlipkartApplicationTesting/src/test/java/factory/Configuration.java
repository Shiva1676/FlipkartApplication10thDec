/**
 * 
 */
package factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Lenovo
 *
 */
public class Configuration {

	Properties pro;

	public Configuration() {

		String path = System.getProperty("user.dir") + "/Configuration/config.properties";

		try {
			File src = new File(path);

			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
		} catch (Exception e) {

			System.out.println("================Unable to load config file===============");

			System.out.println(e.getMessage());

		}

	}

	public String getBrowser() {

		return pro.getProperty("browser");
	}

	public String getURL() {

		return pro.getProperty("url");
	}

}
