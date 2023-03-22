package Command;

import Receiver.Receiver;
import Receiver.SaveReceiver;

public class SaveCommand extends ICommand {
    private static final Receiver receiver = new SaveReceiver();

    public SaveCommand() {
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
