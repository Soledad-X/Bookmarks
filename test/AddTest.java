import Command.*;
import org.junit.Test;

public class AddTest {

    @Test
    public void addTitleTest(){
        Invoker invoker = new Invoker();
        invoker.call(new AddTitleCommand("haha"));
        invoker.call(new AddTitleCommand("computer","./haha"));
        invoker.call(new AddTitleCommand("lab1","./haha/computer"));
        invoker.call(new AddTitleCommand("math","./haha"));
    }

    @Test
    public void addBookmarkTest(){
        Invoker invoker = new Invoker();

        invoker.call(new AddTitleCommand("course"));
        invoker.call(new AddTitleCommand("computer","./course"));
        invoker.call(new ShowTreeCommand());
        invoker.call(new AddTitleCommand("lab1","./course/computer"));
        invoker.call(new AddTitleCommand("math","./course"));
        invoker.call(new ShowTreeCommand());
        invoker.call(new AddBookmarkCommand("computercourse-1@www.baidu.com","./course/computer"));
        invoker.call(new AddBookmarkCommand("mathcourse-1@www.baidu.com","./course/math"));
    }
}
