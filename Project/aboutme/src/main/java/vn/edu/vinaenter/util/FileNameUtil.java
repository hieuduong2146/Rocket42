package vn.edu.vinaenter.util;

import org.apache.commons.io.FilenameUtils;

public class FileNameUtil {
	
	public static String rename(String filname) {
		return FilenameUtils.getBaseName(filname)+ "-" + System.nanoTime() + "." +
				FilenameUtils.getExtension(filname);
	}
}
