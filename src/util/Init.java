package util;

import service.SFileIO;
import service.SLoginRegister;

public class Init {

	public Init() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//首先初始化数据库
		//然后启动服务
		SLoginRegister.startService();
		SFileIO.startService();
	}
	
	
	private static void initDB(){
		//init DB by sql/sql.init
	}

}
