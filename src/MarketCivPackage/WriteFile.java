package MarketCivPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    private String path;
    private boolean append_to_file = false;

    public WriteFile(String file_path){
        path = file_path;
    }

    WriteFile(String file_path, boolean append_value){
        path = file_path;
        append_to_file = append_value;
    }

     void writeToFile(String textLine) throws IOException{
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s"+"%n" ,textLine);

        print_line.close();
    }
     void clearFile(String file_path){
        File f = new File(file_path);
        if(f.exists()){
            f.delete();
        }
        try{
            f.createNewFile();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
