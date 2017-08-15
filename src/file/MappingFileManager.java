package file;

import java.io.File;
import java.util.List;


/*
 * 为2.0版本生成，使文件名与文件路径分离
 * 使得多个用户的文件可以映射到同一个文件
 */
public class MappingFileManager implements IFileManager{

	public MappingFileManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createDir(String userId, String rootPath, String dirName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createFile(String userId, String rootPath, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFile(String userId, String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<File> getDir(String userId, String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
