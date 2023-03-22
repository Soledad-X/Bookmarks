import java.io.*;
import java.util.Scanner;
import Command.*;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);

        // 输入command
        System.out.print(">> ");
        String[] command = scanner.nextLine().split(" ");
        while(true){
            if(command[0].equals("exit")) break;
            else if(command[0].equals("open")){
                try{
                    File file = new File("Bookmarks.bmk");
                    BufferedReader reader = null;
                    reader = new BufferedReader(new FileReader(file));

                    String tempStr = null;
                    while ((tempStr = reader.readLine()) != null){

                        command = tempStr.split(" ");
                        switch (command[0]){
                            case "add-title" : invoker.call(command.length > 2 ? new AddTitleCommand(command[1],command[3]) : new AddTitleCommand(command[1])); break;

                            case "add-bookmark" :  invoker.call(command.length > 2 ? new AddBookmarkCommand(command[1],command[3]) : new AddBookmarkCommand(command[1])); break;
                        }
                    }
                    reader.close();
                } catch (IOException ignored) {
                }
            }
            switch (command[0]){

                case "add-title" : invoker.call(command.length > 2 ? new AddTitleCommand(command[1],command[3]) : new AddTitleCommand(command[1])); break;

                case "add-bookmark" :  invoker.call(command.length > 2 ? new AddBookmarkCommand(command[1],command[3]) : new AddBookmarkCommand(command[1])); break;

                case "delete-title" : invoker.call(new DeleteTitleCommand(command[1])); break;

                case "delete-bookmark" : invoker.call(new DeleteBookmarkCommand(command[1])); break;

                case "ls-tree" : invoker.call(new LsTreeCommand(command[1])); break;

                case "undo" : invoker.undo(); break;

                case "redo" : invoker.redo(); break;

                case "show-tree" : invoker.call(new ShowTreeCommand()); break;

                case "read-bookmark" : invoker.call(new ReadBookmarkCommand(command[1])); break;

                case "save" : invoker.call(new SaveCommand()); break;
                
                default: System.out.println("Illegal input");
            }
            System.out.print(">> ");
            command = scanner.nextLine().split(" ");
        }
        scanner.close();
    }
}
