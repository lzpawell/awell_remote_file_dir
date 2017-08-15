package service;

import bean.User;

public class SLoginRegister {

	private static final int PORT = 12580;
	
	public SLoginRegister() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 登录注册服务监听， 从这里启动对端口12580的监听
	 * 并且处理登录注册相关的巴拉巴拉，
	 * 采用NIO作为数据传输方式
	 */
	public static boolean startService(){
		return true;
	}
	
	
	/*
	 * 登录调用存储过程procedure_login来验证账户密码
	 * return : util.Error中的某个标志
	 */
	private static int login(User user){
		return 0;
	}
	
	/*
	 * 注册调用存储过程procedure_register
	 * return : util.Error中的某个标志
	 */
	private static int register(User user){
		return 0;
	}
}
