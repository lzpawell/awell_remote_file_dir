package bean;

import org.json.JSONObject;

import com.google.gson.Gson;

public class User {
	
	public User() {
		
	}
	
	
	private String userId;
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getNickname() {
		return nickname;
	}


	private String password;
	private String nickname;
}
