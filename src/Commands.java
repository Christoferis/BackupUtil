import java.io.File;
import java.util.Stack;

public class Commands {
    
    //Commands: new <path> <name> creates new vault at the path
    //backup <path> <arguments> directory of manifest file aka the
    //add <path> <vault> adds a new directory to the vault to backup
    //remove <path> <vault> remove a directory from a vault
    //help


    public static void help(){
        System.out.println("BackupUtil has the following commands available:");
        System.out.println(" <BackupUtil> new <path> <name> \n Creates a new Vault with the given name at the given path, the manifest file is inside this newly created directory \n");
        System.out.println(" <BackupUtil> add <path> <vault> \n Adds a to be backed up path to the vault (directory in which the manifest file of the vault can be found) \n");
        System.out.println(" <BackupUtil> remove <path> <vault> \n Removes a to be backed up path of a vault (directory in which the manifest file of the vault can be found) \n");
        System.out.println(" <BackupUtil> backup <vault> <arguments> \n Initiates the Backup Process of a vault \n");
        System.out.println(" Arguments for Backup can be: \n\t retro (removes deleted files from the Backup retroactively) \n\t keep (keep the older version of a file in the Vault instead of overwriting with the newer version) \n\t full (creates a full Backup, this action takes long)");
    }


    public static boolean new_vault(String path, String name){
        File vault = new File(path, name);
        
        if(vault.exists()){App.exiting("Vault / Directory already exists");}

        try {
            vault.mkdir();
        } catch (SecurityException e) {
            e.printStackTrace();
            App.exiting("Vault couldn't be created.");
            return false;
        }

        return true;
    }

    //vault function
    public static void add(String path, String vault){
        
    }

    //vault function
    public static void remove(String path, String vault){

    }

    public static void backup(String vault, Stack<String> args){
        //get all of the args

        //replace older backups with new backup
        boolean replace = false;
        //backup only the files that were modified recently
        boolean onlyNew = false;
        //retroactively delete files that now don't exist anymore
        boolean retro = false;

        if (args.size() > 3){
            App.exiting("To many arguments");
        }

        while (!args.isEmpty()) {
            switch (args.pop()) {
                case "replace":
                    replace = true;
                    break;

                case "onlyNew":
                    onlyNew = true;
                    break;

                case "retroactive":
                    retro = true;
                    break;
            
                default:
                    continue;
            }


        }

    }


}
