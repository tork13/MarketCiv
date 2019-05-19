package MarketCivPackage;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException{
        String file_name = "SaveFile.txt";
        Retrieve(file_name);
        Save(file_name,5);

    }

    public static void Retrieve(String file_name) {
        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            for (int i = 0; i < aryLines.length; i++) {
                System.out.println("get");
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

