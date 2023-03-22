package Receiver;

import Entity.BookMark;

public class ReadBookmarkReceiver extends Receiver{
    @Override
    public void action() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i=1;i<loc.length-1;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        cur.getLinkMap().get(loc[loc.length-1]).setRead(true);
        // System.out.println("标记为已读！");
    }
}
