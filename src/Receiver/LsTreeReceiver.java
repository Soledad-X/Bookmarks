package Receiver;

import Entity.BookMark;
import Utils.Utils;

public class LsTreeReceiver extends Receiver{
    @Override
    public void action() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i = 0;i < loc.length;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        Utils.showTree(cur,0, true);
    }
}
