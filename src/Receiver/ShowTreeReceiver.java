package Receiver;

import Utils.Utils;

public class ShowTreeReceiver extends Receiver{
    @Override
    public void action() {
        Utils.showTree(root,0, true);
    }
}
