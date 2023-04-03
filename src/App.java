import java.util.Stack;

public class App {
    //Background side

    //Commands: new <path> <name> creates new vault at the path
    //backup <path> <arguments> directory of manifest file aka the
    //add <path> <vault> adds a new directory to the vault to backup
    //remove <path> <vault> remove a directory from a vault
    //help

    public static void main(String[] args) throws Exception {
        
        //convert thing to Stack
        Stack<String> argStack = new Stack<>();
        for (int i = args.length - 1; i >= 0; i--) {
            argStack.push(args[i]);
        }
    

        //atleast 3 args
        switch (argStack.pop().toLowerCase()) {
            case "help":
                Commands.help();
                break;
            
            case "new":
                Commands.new_vault(argStack.pop(), argStack.pop());
                break;

            case "add":
                Commands.add(argStack.pop(), argStack.pop());
                break;

            case "backup":
                Commands.backup(argStack.pop(), argStack);
                break;
        
            default:
                exiting("There is no command called " + args[0]);
                break;
        }
    }


    public static void exiting(String reason){
        System.err.println(reason);
        System.exit(0);
    }
}
