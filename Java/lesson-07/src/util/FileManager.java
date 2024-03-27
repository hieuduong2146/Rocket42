package util;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static final String FILE_EXISTS = "ERROR ! File exists.";
    public static final String FILE_DELETE = "ERROR ! File not exists.";
    public static final String PATH_NOT_FOLDER = "ERROR ! Path is not folder.";
    public static final String FOLDER_EXISTS = "ERROR ! .";
    public static boolean exists(String path){
        return new File(path).exists();
    }
    public static boolean createNewFile(String path) throws IOException {
        if(exists(path)){
            throw new IllegalStateException(FILE_EXISTS);
        }
        return new File(path).createNewFile();
    }

    public  static boolean delete(String path){
        if (!exists(path)) {
            throw new IllegalStateException(FILE_DELETE);
        }
        return new File(path).delete();
    }

    public static boolean isFile(String path){
        return new File(path).isFile();
    }
    public static boolean isDirectory(String path){
        return new File(path).isDirectory();
    }

    public static String [] list( String path){
        if(!isDirectory(path)){
            throw new IllegalStateException(PATH_NOT_FOLDER);
        }
        return new File(path).list();
    }

    public static boolean mkdirs(String path){
        if(exists(path)){
            throw new IllegalStateException(FOLDER_EXISTS);
        }
        return new File(path).mkdirs();
    }
}
