package Command;
import java.util.Stack;
import java.util.regex.Pattern;

public class CommandManager {
    private Stack<ICommand> redoStacks = new Stack<ICommand>();
    private Stack<ICommand> undoStacks = new Stack<ICommand>();

    public void executeCommand(ICommand command){
        command.execute();

        if(Pattern.matches(".*Add.*", command.getClass().getName()) | Pattern.matches(".*Delete.*", command.getClass().getName()))
            undoStacks.push(command);
    }

    public void Undo(){
        if(!undoStacks.empty()){
            ICommand command = undoStacks.pop();
            command.undoExecute();

            if(Pattern.matches(".*Add.*", command.getClass().getName()) | Pattern.matches(".*Delete.*", command.getClass().getName()))
                redoStacks.push(command);
        }
    }

    public void Redo(){
        if(!redoStacks.empty()){
            ICommand command = redoStacks.pop();
            command.execute();

            if(Pattern.matches(".*Add.*", command.getClass().getName()) | Pattern.matches(".*Delete.*", command.getClass().getName()))
                undoStacks.push(command);
        }
    }
}
