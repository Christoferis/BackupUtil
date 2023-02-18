package test;

import java.io.File;
import java.util.HashSet;

import util.FileOp;

public class test {
    public static void main(String[] args) {
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
}
