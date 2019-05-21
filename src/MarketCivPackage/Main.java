package MarketCivPackage;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException{

        String file_name = "SaveFile.txt";
        ArrayList saveText = new ArrayList();
        MarketCivGUI  myGUI = new MarketCivGUI();
        myGUI.setVisible(true);

        Resource[] Resources = new Resource[12];
        for( int i = 0; i < Resources.length; i++ ){

        }

    }

    public static void Retrieve(String file_name,ArrayList saveText) {
        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            for (int i = 0; i < aryLines.length; i++) {
                saveText.add(aryLines[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void Save(String file_name, int number) throws IOException {
        WriteFile data = new WriteFile(file_name, true);
        data.clearFile(file_name);
        for (int i = 0; i < number; i++) {
            data.writeToFile("save");
        }
    }
}

