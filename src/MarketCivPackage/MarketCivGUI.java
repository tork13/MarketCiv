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

    public MarketCivGUI(){
        add(rootPanel);
        setTitle("Market Civ");
        setSize(1000,1000);


    }

    public void errorLabelSetText(String inputText){
        errorLabel.setText(inputText);
    }
    public void marketAuctionSetText(String inputText){
        marketAuctionText.setText(inputText);
    }


}
