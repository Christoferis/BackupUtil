package util;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.RunElement;

//Util class for all of the FileOperation Stuff
public class FileOp {
    
    //Multithread that maybe?
    public static HashSet<File> allSubfiles(File directory) throws Exception{

        if(!directory.isDirectory()){throw new Exception("File Object is not pointing to a directory");}

        HashSet<File> files = new HashSet<>();
        File[] dirFiles = directory.listFiles();

        for (File f : dirFiles){
            if(f.isDirectory()){
                HashSet<File> subfiles = allSubfiles(f);
                files.addAll(subfiles);
            }else{
                files.add(f);
            }
        }
        
        return files;
    }

    public static HashSet<File> youngestFiles(long date, HashSet<File> files){
        HashSet<File> out = new HashSet<>();

        for(File f : files){
            if(f.lastModified() > date){
                out.add(f);
            }
        }

        return out;

    }

    public static void d(HashSet<File> files){
        for(File f : files){
            Files.copy(null, null, null);
        }

    }

    //fetch all files that are deleted in the newest version
    public static HashSet<File> getDeletedFiles(HashSet<File> backup, HashSet<File> current){
        return null;
    }

    public static HashSet<File> getNewFiles(HashSet<File> backup, HashSet<File> current){
        return null;
    }
}
