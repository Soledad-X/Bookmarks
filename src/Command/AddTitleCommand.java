package Command;

import Receiver.AddTitleReceiver;
import Receiver.Receiver;

public class AddTitleCommand extends ICommand{
    private static final Receiver receiver = new AddTitleReceiver();

    public AddTitleCommand(String value) {
        receiver.setValue(value);
        receiver.setLocation(null);
    }

    public AddTitleCommand(String value, String location) {
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
