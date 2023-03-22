package Receiver;

import Entity.BookMark;
import Entity.Link;

public class AddBookmarkReceiver extends Receiver{
    @Override
    public void action() {
        String[] val = value.split("@");
        Link link = new Link(val[0],val[1]);
        if(location == null){
            root.addLinkMap(val[0], link);
        }else{
            String[] loc = location.split("/");
            BookMark cur = root;
            for(String title : loc){
                cur = cur.titleToBookmarkMap(title);
            }
            cur.addLinkMap(val[0], link);
        }        
        // System.out.println("添加成功！");
    }
    @Override
    public void undoAction(){
        String[] val = value.split("@");
        if(location == null){
            root.getLinkMap().remove(val[0]);
        }else{
            String[] loc = location.split("/");
            BookMark cur = root;
            for(String title : loc){
                cur = cur.titleToBookmarkMap(title);
            }
            cur.getLinkMap().remove(val[0]);
        }        
        // System.out.println("撤销成功！");
    }
}
