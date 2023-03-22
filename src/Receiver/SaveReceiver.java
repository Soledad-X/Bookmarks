package Receiver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Utils.Utils;

public class SaveReceiver extends Receiver{
    @Override
    public void action() {
        String content = Utils.genTree(root);
        try{
            File file = new File("Bookmarks.bmk");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
