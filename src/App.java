import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class App {
    //Background side

    //Commands: new <path> <name> creates new vault at the path
    //backup <path> <arguments> directory of manifest file aka the
    //add <path> <vault> adds a new directory to the vault to backup
    //remove <path> <vault> remove a directory from a vault
    //help

    public static void main(String[] args) throws Exception {
        
        //atleast 3 args
        switch (args[0].toLowerCase()) {
            case "help":
                Commands.help();
                break;
            
            case "new":
                break;

            case "add":
                break;

            case "backup":
                break;
        
            default:
                exiting("No command called " + args[0]);
                break;
        }
    }


    public static void exiting(String reason){
        System.err.println(reason);
        System.exit(0);
    }
}
