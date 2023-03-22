package Receiver;

import Entity.BookMark;

public class AddTitleReceiver extends Receiver{
    @Override
    public void action() {
        if(location == null){
            BookMark bookMark = new BookMark(value, ".",root);
            root.addBookmarkMap(value,bookMark);
        } else{
            String[] loc = location.split("/");
            BookMark cur = root;
            for(String title : loc){
                cur = cur.titleToBookmarkMap(title);
            }
            cur.addBookmarkMap(value,new BookMark(value, location,cur));
        }
        // System.out.println("添加成功！");
    }

    @Override
    public void undoAction() {
        if(location == null){
            root.getBookmarkMap().remove(value);
        }
        else {
            String[] loc = location.split("/");
            BookMark cur = root;
            for(String title : loc){
                cur = cur.titleToBookmarkMap(title);
            }
            cur.getBookmarkMap().remove(value);
        }
        // System.out.println("撤销成功！");
    }
}
