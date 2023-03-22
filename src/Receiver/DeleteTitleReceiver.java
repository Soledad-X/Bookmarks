package Receiver;

import Entity.BookMark;

public class DeleteTitleReceiver extends Receiver{

    protected static BookMark bookMark = null;

    @Override
    public void action() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i=0 ;i<loc.length-1;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        bookMark = cur.getBookmarkMap().get(loc[loc.length-1]);
        cur.getBookmarkMap().remove(loc[loc.length-1]);
        // System.out.println("删除成功！");
    }

    @Override
    public void undoAction() {
        String[] loc = location.split("/");
        BookMark cur = root;
        for(int i=0 ;i<loc.length-1;i++){
            cur = cur.titleToBookmarkMap(loc[i]);
        }
        cur.getBookmarkMap().put(loc[loc.length-1],bookMark);
        // System.out.println("撤销成功！");
    }
}
