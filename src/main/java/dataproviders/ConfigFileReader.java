package dataproviders;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.AppConstants;
import enums.DriverType;
import enums.EnvironmentType;
 
public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "src/main/java/config/Configuration.properties";
 
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getUser() {
		String user = properties.getProperty("user");
		if(user != null) return user;
		else throw new RuntimeException("user not specified in the Configuration.properties file.");
	}
	public String getPassword() {
		String password = properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	public String getHomePageUserName() {
		String password = properties.getProperty("homepageusername");
		if(password != null) return password;
		else throw new RuntimeException("homepage user name not specified in the Configuration.properties file.");
	}
	public boolean getBrowserWindowSize() {
		return false;
	}

	public DriverType getBrowser() {
		return DriverType.CHROME;
	}

	public EnvironmentType getEnvironment() {
		return EnvironmentType.LOCAL;
	}
 
}