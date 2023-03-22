package Command;

import Receiver.AddBookmarkReceiver;
import Receiver.Receiver;

public class AddBookmarkCommand extends ICommand{
    private static final Receiver receiver = new AddBookmarkReceiver();

    public AddBookmarkCommand(String value) {
        receiver.setValue(value);
        receiver.setLocation(null);
    }

    public AddBookmarkCommand(String value, String location) {
        receiver.setValue(value);
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
