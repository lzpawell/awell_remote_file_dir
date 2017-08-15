package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.rmi.CORBA.Util;

import org.json.JSONObject;

import bean.User;

public class SQLHelper {
	
	public SQLHelper() {
		// TODO Auto-generated constructor stub
	}

	
	private boolean initDB(){
		return true;
	}
	
	/*
	 * 登录调用存储过程procedure_login来验证账户密码
	 * return : util.Error中的某个标志
	 */
	public static JSONObject checkUser(User user){
		JSONObject result = new JSONObject();

		String sql = String.format("select * from awell_remote_file_dir.user where user_id='%s';", user.getUserId());
		
		try {
			Connection connection = DBPool.getDBConnection();
			ResultSet resultSet = connection.createStatement().executeQuery(sql);
			
			if(resultSet.next() == false){
				result.put("result", util.Error.ERR_USER_NOT_FOUND);
			}else{
				if(resultSet.getString("password").equals(user.getPassword()) ){
					result.put("nickname", resultSet.getString("nickname"));
					result.put("result", util.Error.NO_ERROR);		
				}else{
					result.put("result", util.Error.ERR_PASSWD_ERROR);					
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			result.put("result", util.Error.ERR_UNKNOWN);
		}
		
		return result;
	}
	
	
	/*
	 * 注册调用存储过程procedure_register
	 * return : util.Error中的某个标志
	 */
	public static JSONObject register(User user){
		JSONObject result = new JSONObject();

		String sql = String.format("select * from awell_remote_file_dir.user where user_id='%s';", user.getUserId());
		
		try {
			Connection connection = DBPool.getDBConnection();
			ResultSet resultSet = connection.createStatement().executeQuery(sql);
			
			if(resultSet.next() == false){
				//没有这个用户，可以新建
				sql = String.format("insert into awell_remote_file_dir.user (user_id, password, nickname) values('%s', '%s', '%s');", user.getUserId(), user.getPassword(), user.getNickname());
				
				try {
					connection.createStatement().executeUpdate(sql);
					
					result.put("nickname", user.getNickname());
					result.put("result", util.Error.NO_ERROR);
				} catch (Exception e) {
					result.put("result", util.Error.ERR_UNKNOWN);
				}
			}else{
				result.put("result", util.Error.ERR_USER_IS_EXIST);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			result.put("result", util.Error.ERR_UNKNOWN);
		}
		
		return result;
	}
}
