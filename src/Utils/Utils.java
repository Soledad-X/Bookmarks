package Utils;
import java.util.Iterator;
import java.util.Map;
import Entity.BookMark;
import Entity.Link;

public class Utils {
    // private static String I_branch = "│   ";
    private static String T_branch = "├── ";
    private static String L_branch = "└── ";
    private static String SPACER = "    ";

    public static void showTree(BookMark root, Integer depth, boolean isLast){
        for(Integer i = 0;i < depth-1;i++){
            System.out.print(SPACER);
        }
        if(depth != 0) System.out.print(isLast ? L_branch : T_branch);
        System.out.println(root.getTitle());
        Iterator<Map.Entry<String, BookMark>> bookmarks = root.getBookmarkMap().entrySet().iterator();
        Map.Entry<String, BookMark> bookmark;
        while(bookmarks.hasNext()) {
            bookmark = bookmarks.next();
            if(bookmark.getKey().equals(".") || bookmark.getKey().equals("..")) continue;
            Utils.showTree(bookmark.getValue(), depth + 1, !(bookmarks.hasNext() == true) & root.getLinkMap().isEmpty());
        }
        Iterator<Map.Entry<String, Link>> links = root.getLinkMap().entrySet().iterator();
        Map.Entry<String, Link> link;
        while(links.hasNext()) {
            link = links.next();
            for(Integer i = 0;i < depth;i++){
                System.out.print(SPACER);
            }
            System.out.print((links.hasNext() == true) ? T_branch : L_branch);
            System.out.println("[" + link.getKey() + "](" + link.getValue().getUrl() + ")" + ((link.getValue().isRead() == true) ? "*" : ""));
        }
    }

    public static String genTree(BookMark root){
        String content = "";
        if(!root.getTitle().equals("."))
            content += ("add-title " + root.getTitle() + " at " + root.getLocation()) + "\n";
        Iterator<Map.Entry<String, BookMark>> bookmarks = root.getBookmarkMap().entrySet().iterator();
        Map.Entry<String, BookMark> bookmark;
        while(bookmarks.hasNext()) {
            bookmark = bookmarks.next();
            if(bookmark.getKey().equals(".") || bookmark.getKey().equals("..")) continue;
            content += Utils.genTree(bookmark.getValue());
        }
        Iterator<Map.Entry<String, Link>> links = root.getLinkMap().entrySet().iterator();
        Map.Entry<String, Link> link;
        while(links.hasNext()) {
            link = links.next();
            if(root.getTitle().equals("."))
                content += ("add-bookmark " + link.getKey() + "@" + link.getValue().getUrl() + " at " + root.getLocation()) + "\n";
            else
                content += ("add-bookmark " + link.getKey() + "@" + link.getValue().getUrl() + " at " + root.getLocation() + "/" + root.getTitle()) + "\n";
        }
        return content;
    }
}
