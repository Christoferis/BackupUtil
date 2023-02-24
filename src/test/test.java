package test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;

import util.FileOp;

public class test {
    public static void main(String[] args) {
        // FileOpTest();
        // PathTest();
        copyTest();
    }

    //Test: passed (24.02.23, 23.50)
    public static void FileOpTest() {
        String path = "D:/Dev/Code/autocomplete/src";
        String path1 = "D:/Dev/Code/RhubarbBarbara";
        String path2 = "D:/Dev/Code/3001_SpaceTragedy";
        String path3 = "G:/Cubase Projects";

        try {
            HashSet<File> f = FileOp.allSubfiles(new File(path));
            System.out.println(f.toString());
            HashSet<File> f1 = FileOp.allSubfiles(new File(path1));
            System.out.println(f1.toString());
            HashSet<File> f2 = FileOp.allSubfiles(new File(path2));
            System.out.println(f2.toString());
            HashSet<File> f3 = FileOp.allSubfiles(new File(path3));
            System.out.println(f3.toString());
            System.out.println(f3.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Do not use after backup has been implemented; Test: passed (24.02.23, 23.50)
    public static void PathTest() {
        FileOp.backup(new File("D:/Dev/Code/RhubarbBarbara"), new File("G:/Backups"), null);
        FileOp.backup(new File("D:/Dev/Code/3001_SpaceTragedy"), new File("G:/Backups"), null);
    }

    //Test: test if a path has to already exist or if it can create it itself
    //Observation: Directory path needs to exist, file to copy not
    public static void copyTest() {
        try {
            Files.copy(Paths.get("D:/Dev/Code/BackupUtil/BackupUtil/src/test/testfile.txt"), Paths.get("D:/Dev/Code/BackupUtil/BackupUtil/src/test/testdirectory/testfile.txt"), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
            System.err.println("Test failed");
        }
    }
}
