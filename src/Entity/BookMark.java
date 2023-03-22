package Entity;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookMark {
    private String title;
    private String location;//当前节点的绝对路径
    private Map<String,BookMark> bookmarkMap; // '.'指向自身 '..'指向上一级
    private Map<String,Link> linkMap;
    
    public BookMark() {
    }
    public BookMark(String title, String location, BookMark parent) {
        this.title = title;
        this.location = location;
        this.bookmarkMap = new LinkedHashMap<String, BookMark>();
        this.bookmarkMap.put(".", this);
        this.bookmarkMap.put("..", parent == null? parent : this);
        this.linkMap = new LinkedHashMap<String, Link>();
    }
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public Map<String, BookMark> getBookmarkMap() {
        return bookmarkMap;
    }
    public Map<String, Link> getLinkMap() {
        return linkMap;
    }
    public void addBookmarkMap(String title,BookMark bookMark){this.bookmarkMap.put(title, bookMark);}
    public BookMark titleToBookmarkMap(String title){ return bookmarkMap.get(title);}
    public void addLinkMap(String title,Link link){this.linkMap.put(title,link);}
    @Override
    public String toString() {
        return "BookMark [title=" + title + ", location=" + location + ", bookmarkMap=" + bookmarkMap + ", linkMap="
                + linkMap + "]";
    }
}
