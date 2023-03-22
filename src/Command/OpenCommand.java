package Command;

import Receiver.OpenReceiver;
import Receiver.Receiver;

public class OpenCommand extends ICommand{
    private static final Receiver receiver = new OpenReceiver();

    public OpenCommand(String location) {
        receiver.setLocation(location);
    }
    
    @Override
    public void execute() {
        receiver.action();
    }
}
