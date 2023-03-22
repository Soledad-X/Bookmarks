package Receiver;

import Entity.BookMark;

public class Receiver {
    protected static BookMark root = new BookMark(".", ".", null);
    protected String value;
    protected String location;
    
    public void setValue(String value) {
        this.value = value;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void action(){}

    public void undoAction(){}
}
