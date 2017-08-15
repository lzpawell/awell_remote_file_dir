package file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class NoMappingFileManager implements IFileManager{

	private String rootPath = System.getProperty("java.io.tmpdir");
	
	public NoMappingFileManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createDir(String userId, String path, String dirName) {
		
		//rootPath/userid/rootPath/dirName
		try {
			File file = new File(this.rootPath + File.separator + userId  + File.separator + path, dirName);
			
			if (file.exists() == false) {
				file.mkdirs();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}

	@Override
	public boolean createFile(String userId, String path, String fileName) {
		// TODO Auto-generated method stub
		try{
			File file = new File(this.rootPath + File.separator + userId  + File.separator + path, fileName);
			
			return file.createNewFile();
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeFile(String userId, String path) {
		try {
			File file = new File(this.rootPath + File.separator + userId  + File.separator + path);
			
			if(file.exists()){
				return file.delete();
			}
			
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}

	@Override
	public List<File> getDir(String userId, String path) {
		
		try {
			File file = new File(this.rootPath + File.separator + userId  + File.separator + path);
			
			if(file.exists() && file.isDirectory())
				return Arrays.asList(file.listFiles());
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

}
