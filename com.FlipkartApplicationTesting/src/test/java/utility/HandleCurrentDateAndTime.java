/**
 * 
 */
package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lenovo
 *
 */
public class HandleCurrentDateAndTime {

	public static String getDateAndTime() {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

		Date date = new Date();
		
//		System.out.println("Date and time is:"+ date);

		return dateFormat.format(date);

	}

}
