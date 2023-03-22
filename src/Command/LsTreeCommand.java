package Command;

import Receiver.LsTreeReceiver;
import Receiver.Receiver;

public class LsTreeCommand extends ICommand{
    private static final Receiver receiver = new LsTreeReceiver();

    public LsTreeCommand(String location) {
        receiver.setLocation(location);
    }
        
    @Override
    public void execute() {
        receiver.action();
    }
}
