package util;

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

        int count = 0;
        for(File f : files){
            count++;

            String orig = f.getAbsolutePath();
            String dest = destination.getAbsolutePath() + orig.replaceFirst(Matcher.quoteReplacement(original.getAbsolutePath()), ""); 
        
            //TODO: CopyOP

            //Loading Screen
            System.out.println("Backed up " + count / files.size() * 100 + "% (" + count + "/" + files.size() + ")" );

        }
    }

    public static void copyOP(File file, File destination, String[] args){
        File dirTest = new File(destination.getParent());

        //may be point of failure -> Don't know the behaviour
        dirTest.mkdirs();

        try {
            Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("Couldn't copy file " + file.getAbsolutePath() + ". Skipping this file...");
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
