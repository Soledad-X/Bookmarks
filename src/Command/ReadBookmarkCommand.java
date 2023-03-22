package Command;

import Receiver.ReadBookmarkReceiver;
import Receiver.Receiver;

public class ReadBookmarkCommand extends ICommand{
    private static final Receiver receiver = new ReadBookmarkReceiver();
    
    public ReadBookmarkCommand(String location) {
        receiver.setLocation(location);
    }
        
    @Override
    public void execute() {
        receiver.action();
    }
}
