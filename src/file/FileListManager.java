package file;

import java.io.File;
import java.util.List;

public class FileListManager {

	private static IFileManager fileManager;
	static {
		fileManager = new NoMappingFileManager();
	}

	/*
	 * 从指定的用户文件目录中加载文件目录
	 */
	public static List<File> getFileList(String userId, String path) {
		return fileManager.getDir(userId, path);
	}

	/*
	 * 为指定的用户路径下创建文件（夹）
	 */
	public static boolean createFile(String userId, String path, String fileName) {
		// 未完成文件名
		String uFileName = fileName + ".tmp";
		// 创建一个未完成的文件路径
		return fileManager.createFile(userId, path, uFileName);

	}

	/*
	 * 从指定的文件夹中删除文件
	 */
	public boolean removeFile(String userId, String path) {
		return fileManager.removeFile(userId, path);
	}

}
