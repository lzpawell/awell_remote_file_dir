package file;

import java.io.File;
import java.util.List;

public class FileListManager {
	
	private static IFileManager fileManager;
	static{
		fileManager = new NoMappingFileManager();
	}
	
	
	/*
	 * 从指定的用户文件目录中加载文件目录
	 */
	public static List<File> getFileList(String userId, String path){
		return fileManager.getDir(userId, path);
	}
	
	
	
	/*
	 * 为指定的用户路径下创建文件（夹）
	 */
	public static File createFile(String userId, String path){
		return null;
	}
	
	
	/*
	 * 从指定的文件夹中删除文件
	 */
	
}
