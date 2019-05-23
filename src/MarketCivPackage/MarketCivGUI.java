package MarketCivPackage;

import javax.swing.*;
import java.awt.*;

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

    public MarketCivGUI(){
        add(rootPanel);
        setTitle("Market Civ");
        setSize(1000,1000);


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
}
