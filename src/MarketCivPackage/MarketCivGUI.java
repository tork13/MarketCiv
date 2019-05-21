package MarketCivPackage;

import javax.swing.*;

public class MarketCivGUI extends JFrame {
    private JPanel rootPanel;
    private JTextPane textFieldRightTextPane;
    private JTextPane textFieldBottomTextPane;
    private JTextPane textFieldLeftTextPane;
    private JButton buyButton;
    private JButton sellButton;
    private JTextArea quantityTextArea;

    public MarketCivGUI(){
        add(rootPanel);
        setTitle("Market Civ");
        setSize(1000,1000);



    }

}
