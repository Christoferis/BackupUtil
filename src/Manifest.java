import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


//loads a manifest file

public class Manifest {

    long lastBackup;
    ArrayList<String> paths;
    File vault;
    String name;


    private Manifest(long lastBackup, ArrayList<String> paths, File vault, String name){
        this.paths = paths;
        this.lastBackup = lastBackup;
        this.vault = vault;
    }

    //save current manifest content
    public void save(){

        File mf = new File(vault, name + ".mf");

        if(!mf.exists()){
            try {
                mf.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                App.exiting("Couldn't create a Manifest file");
            }
        }

        try {
            BufferedWriter f = new BufferedWriter(new FileWriter(mf));
            f.write((int) lastBackup);
            f.newLine();
            f.write(vault.getAbsolutePath());

            for(String path : paths){
                f.newLine();
                f.write(path);
            }

            f.close();

        } catch (IOException e) {
            e.printStackTrace();
            App.exiting("Couldn't save Manifest file");
        }
    }

    public void updateBackup(){

    }

    public void updateList(String path){

    }
    
    public static Manifest getManifest(File mf){
        //load manifest
        return null;
    }

    public static void newManifest(File vaultDir, String name){
        Manifest mf = new Manifest(0, null, vaultDir, name);
    }
    
}
