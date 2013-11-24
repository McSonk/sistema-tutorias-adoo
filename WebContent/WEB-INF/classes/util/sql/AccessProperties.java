package util.sql;

import java.util.HashMap;

public class AccessProperties {

	HashMap<String,String> map;

	public AccessProperties() {
		map = new HashMap<String,String>(4);
		map.put("url", "");
		map.put("driverClassName", "");
		map.put("username", "");
		map.put("password", "");
	}

	private AccessProperties setProperty(String name, String object) {
		map.put(name, object == null?"":object);
		return this;
	}

	private String getProperty(String name) {
		return map.get(name);
	}

	public AccessProperties setUrl(String url) {
		return setProperty("url", url);
	}

	public AccessProperties setDriverClassName(String driverClassName) {
		return setProperty("driverClassName", driverClassName);
	}

	public AccessProperties setUsername(String username) {
		return setProperty("username", username);
	}

	public AccessProperties setPassword(String password) {
		return setProperty("password", password);
	}

	public String getUrl() {
		return getProperty("url");
	}

	public String getDriverClassName() {
		return getProperty("driverClassName");
	}

	public String getUsername() {
		return getProperty("username");
	}

	public String getPassword() {
		return getProperty("password");
	}

	public String toString() {
		return map.toString();
	}

}

