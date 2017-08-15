package file;

import java.io.File;
import java.util.List;

/*
 * 文件位置映射接口
 */
public interface IFileManager {
	boolean createDir(String userId, String rootPath, String dirName);
	
	boolean createFile(String userId, String rootPath, String fileName);

	boolean removeFile(String userId, String path);
	
	List<File> getDir(String userId, String path);
}
