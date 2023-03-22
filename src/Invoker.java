import Command.ICommand;
import Command.CommandManager;

public class Invoker {
    private final static CommandManager commandManager = new CommandManager();

    public Invoker() {
    }

    public void call(ICommand command){
        commandManager.executeCommand(command);
    }

    public void redo(){
        commandManager.Redo();
    }

    public void undo(){
        commandManager.Undo();
    }
}
