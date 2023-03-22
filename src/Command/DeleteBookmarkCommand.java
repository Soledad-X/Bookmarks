package Command;

import Receiver.DeleteBookmarkReceiver;
import Receiver.Receiver;

public class DeleteBookmarkCommand extends ICommand{
    private static final Receiver receiver = new DeleteBookmarkReceiver();

    public DeleteBookmarkCommand(String location) {
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
