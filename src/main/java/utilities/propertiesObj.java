package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesObj {

	public Properties pro = null;
	public BufferedReader reader=null;
	
	public  Properties getPropertyObj() throws IOException {
		try {
		pro =new Properties();
		reader = new BufferedReader( new FileReader("src//main//java//utilities//google.properties"));
		pro.load(reader);		
		}
		catch(Exception e) {
			e.printStackTrace();
			reader.close();
		}
		return pro;
	}
	
}
