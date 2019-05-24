package MarketCivPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MarketCivGUI extends JFrame {
    private JPanel rootPanel;
    private JButton buyButton;
    private JButton sellButton;
    private JTextField itemTextField;
    private JTextField textFieldQuantity;
    private JPanel MarketPanel;
    private JLabel errorLabel;
    private JTextArea marketAuctionText;
    private JTextArea buildingsText;
    private JTextArea upgradesText;
    private JTextArea cityHallText;

    private Resource[] ResourceShell;
    public MarketCivGUI(){
        add(rootPanel);
        setTitle("Market Civ");
        setSize(1000,1000);


        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity=0;
               try{
                    quantity = Integer.parseInt(textFieldQuantity.getText());
               }
               catch (NumberFormatException el){
                   setErrorLabel("not a number");
               }


                ResourceShell[1].setQuantity(ResourceShell[1].getQuantity()+ quantity);
                itemTextField.setText("");
                updateTextFields(ResourceShell);
                saveFile();
            }
        });


        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sell");

                itemTextField.setText("");
                updateTextFields(ResourceShell);
            }
        });
    }

    public void setErrorLabel(String inputText){
        errorLabel.setText(inputText);
    }
    public void setMarketAuctionText(String inputText){
        marketAuctionText.setText(inputText);
    }
    public void setCityHallText(String inputText){
        cityHallText.setText(inputText);
    }
    public void setUpgradesText(String inputText){
        upgradesText.setText(inputText);
    }
    public void setBuildingsText(String inputText) {
        buildingsText.setText(inputText);
    }
    public void updateTextFields(Resource[] Resources){
        String marketText = "";
        String resourceText = "";
        for (int i = 0; i < Resources.length; i++) {
            marketText = marketText + Resources[i].getType() + " Cost: " + Resources[i].getCost() + "\n";
        }
        for (int i = 0; i < Resources.length; i++){
            resourceText = resourceText + Resources[i].getType() + " Quantity: " + Resources[i].getQuantity() + "\n";
        }
        setMarketAuctionText(marketText);
        setCityHallText(resourceText);
    }
    public void setResourceShell(Resource[] input){
        ResourceShell = input;
    }
    public void saveFile(){
        try {
            Main.Save(ResourceShell);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
