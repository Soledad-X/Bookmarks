package Receiver;

import Entity.BookMark;
import Entity.Link;

public class DeleteBookmarkReceiver extends Receiver{
    @Override
    public void action() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i=0 ;i<loc.length-1;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        value = cur.getLinkMap().get(loc[loc.length-1]).getUrl();
        cur.getLinkMap().remove(loc[loc.length-1]);
        // System.out.println("删除成功！");
    }

    @Override
    public void undoAction() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i=0 ;i<loc.length-1;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        Link link = new Link(loc[loc.length-1],value);
        cur.getLinkMap().put(loc[loc.length-1],link);
        // System.out.println("撤销成功");
    }
}
