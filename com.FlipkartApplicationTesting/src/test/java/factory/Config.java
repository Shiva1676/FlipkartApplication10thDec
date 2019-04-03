/**
 * 
 */
package factory;

/**
 * @author Lenovo
 *
 */
public class Config {

	public static Configuration getConfig() {

		Configuration config = new Configuration();

		return config;
	}
	
	public static ExcelConfiguration getExcelConfig(){
		
		ExcelConfiguration excel = new ExcelConfiguration();
		
		return excel;
	}

}
