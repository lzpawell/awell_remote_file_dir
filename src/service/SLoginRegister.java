package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

import org.json.JSONObject;

import com.google.gson.Gson;

import bean.User;
import util.SQLHelper;

public class SLoginRegister {

	private static final int PORT = 12580;
	
	private static final int PARA_LOGIN = 0;
	private static final int PARA_REGISTER = 1;
	
	
	public SLoginRegister() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 登录注册服务监听， 从这里启动对端口12580的监听
	 * 并且处理登录注册相关的巴拉巴拉，
	 * 采用NIO作为数据传输方式
	 */
	public static boolean startService(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//創建ss
				try {
					ServerSocket serverSocket = new ServerSocket(PORT);
					
					Socket socket = null;
					while ((socket = serverSocket.accept()) != null) {
						new WorkerThread(socket).start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();
		return true;
	}
	
	
	private static final Gson gson = new Gson();
	
	private static class WorkerThread extends Thread{
		
		private Socket socket;
		
		public WorkerThread(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			
			BufferedReader reader = null;
			BufferedWriter writer = null;
			
			try {
				
				System.out.println("aowu");
				
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("utf-8")));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("utf-8")));
				
				String string = reader.readLine().trim();
				
				System.out.println(string);
				
				RequestPara para = gson.fromJson(string, RequestPara.class);
				
				JSONObject responsePara = null;
				
				if(para.getType() == PARA_LOGIN){
					responsePara = SQLHelper.checkUser(para.user);
				}else if(para.getType() == PARA_REGISTER){
					responsePara = SQLHelper.register(para.user);
				}
				
				
				System.out.println(responsePara.toString());
				
				writer.write(responsePara.toString());
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(reader != null)
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	
	
	private static class RequestPara{
		private int type;
		private User user;
		
		public int getType() {
			return type;
		}
		
		public User getUser() {
			return user;
		}
	}
}
