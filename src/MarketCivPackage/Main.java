package MarketCivPackage;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        String file_name = "SaveFile.txt";

        Resource[] ResourcesShell = {new Resource(0, 0, "Wool", 1),
                new Resource(0, 0, "Timber", 1),
                new Resource(0, 0, "Stone", 1),
                new Resource(0, 0, "Wheat", 1)};
        Retrieve(file_name, ResourcesShell);//
        MarketCivGUI myGUI = new MarketCivGUI();
        myGUI.setVisible(true);
        updateTextFields(myGUI,ResourcesShell);
        Save(file_name, ResourcesShell);


    }

    public static void Retrieve(String file_name, Resource[] Resources) {
        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile(); //arrayList of numbers
            ArrayList<Integer> saveText = new ArrayList();
            for (int i = 0; i < aryLines.length; i++) {
                saveText.add(Integer.parseInt(aryLines[i]));
            }
            ////////////////////////////////////////
            //Do the save code here
            for (int i = 0; i < Resources.length; i++) {
                Resources[i].setCost(saveText.remove(0));
                Resources[i].setQuantity(saveText.remove(0));
            }
            if (saveText.size() == 0) {
                System.out.println("Retrive succseful");
            } else {
                System.out.println("Failed. Size left:" + saveText.size());
            }
            ////////////////////////////////
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void Save(String file_name, Resource[] Resources) throws IOException {
        WriteFile data = new WriteFile(file_name, true);
        data.clearFile(file_name);
        for (int i = 0; i <Resources.length ; i++) {
            data.writeToFile( + Resources[i].getCost()+ "\n"+ Resources[i].getQuantity());
        }
    }

    public static void updateTextFields(MarketCivGUI myGUI, Resource[] Resources){
        String marketText = "";
        String resourceText = "";
        for (int i = 0; i < Resources.length; i++) {
            marketText = marketText + Resources[i].getType() + " Cost: " + Resources[i].getCost() + "\n";
        }
        for (int i = 0; i < Resources.length; i++){
            resourceText = resourceText + Resources[i].getType() + " Quantity: " + Resources[i].getQuantity() + "\n";
        }
        myGUI.setMarketAuctionText(marketText);
        myGUI.setCityHallText(resourceText);
    }


}

