package util;

import java.beans.DesignMode;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.regex.Matcher;

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

    //backup function:
    public static void backup(File original, File destination, String[] args){
        if(!original.isDirectory() || !destination.isDirectory()){
            //TODO: exit
        }

        //get all files from the thing
        HashSet<File> files = new HashSet<>();
        try {
            files = allSubfiles(original);
        } catch (Exception e) {
            // TODO: Exit
            System.exit(0);
        }

        for(File f : files){

            String orig = f.getAbsolutePath();
            String dest = destination.getAbsolutePath() + orig.replaceFirst(Matcher.quoteReplacement(original.getAbsolutePath()), ""); 
        
            // copyOP(null, null);
            // System.out.println(dest);
        }
    }

    public static void copyOP(File file, File destination, String[] args){

        //check if thing exists, then copy
        // Files.copy(null, null, null)

    }

    //fetch all files that are deleted in the newest version
    public static HashSet<File> getDeletedFiles(HashSet<File> backup, HashSet<File> current){
        return null;
    }

    public static HashSet<File> getNewFiles(HashSet<File> backup, HashSet<File> current){
        return null;
    }
}
