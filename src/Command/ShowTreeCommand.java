package Command;

import Receiver.Receiver;
import Receiver.ShowTreeReceiver;

public class ShowTreeCommand extends ICommand{
    private static final Receiver receiver = new ShowTreeReceiver();

    public ShowTreeCommand() {
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
