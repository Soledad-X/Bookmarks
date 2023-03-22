package Command;

import Receiver.DeleteTitleReceiver;
import Receiver.Receiver;

public class DeleteTitleCommand extends ICommand{
    private static final Receiver receiver = new DeleteTitleReceiver();

    public DeleteTitleCommand(String location) {
        receiver.setLocation(location);
    }
       
    @Override
    public void execute() {
        receiver.action();
    }
    
    @Override
    public void undoExecute() {
        receiver.undoAction();
    }
}
