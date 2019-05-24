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

    public MarketCivGUI() {
        add(rootPanel);
        setTitle("Market Civ");
        setSize(1000, 1000);


        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = 0;
                boolean realNumber = true;
                boolean realResource = true;
                int resourceIndex;
                for (resourceIndex = 0; resourceIndex < ResourceShell.length; resourceIndex++) {
                    if (itemTextField.getText().toUpperCase().equals(ResourceShell[resourceIndex].getType().toUpperCase())) {
                        try {
                            quantity = Integer.parseInt(textFieldQuantity.getText());
                        } catch (NumberFormatException el) {
                            setErrorLabel("Please enter valid number");
                            realNumber = false;
                            textFieldQuantity.setText("");
                        }
                        break;
                    }
                }
                if (resourceIndex == ResourceShell.length) {
                    setErrorLabel("Please enter a valid Resource");
                    itemTextField.setText("");
                    realResource = false;
                }
                if (realNumber && realResource) {
                    //check money here
                    ResourceShell[resourceIndex].setQuantity(ResourceShell[resourceIndex].getQuantity() + quantity);
                    itemTextField.setText("");
                    textFieldQuantity.setText("");
                    updateTextFields(ResourceShell);
                }


                saveFile();
            }
        });

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = 0;
                boolean realNumber = true;
                boolean realResource = true;
                int resourceIndex;
                for (resourceIndex = 0; resourceIndex < ResourceShell.length; resourceIndex++) {
                    if (itemTextField.getText().toUpperCase().equals(ResourceShell[resourceIndex].getType().toUpperCase())) {
                        try {
                            quantity = Integer.parseInt(textFieldQuantity.getText());
                        } catch (NumberFormatException el) {
                            setErrorLabel("Please enter valid number");
                            realNumber = false;
                            textFieldQuantity.setText("");
                        }
                        break;
                    }
                }
                if (resourceIndex == ResourceShell.length) {
                    setErrorLabel("Please enter a valid Resource");
                    itemTextField.setText("");
                    realResource = false;
                } else if (quantity > ResourceShell[resourceIndex].getQuantity()) {
                    setErrorLabel("Please enter valid number");
                    textFieldQuantity.setText("");
                    realNumber = false;
                }
                if (realNumber && realResource) {
                    //check money here
                    ResourceShell[resourceIndex].setQuantity(ResourceShell[resourceIndex].getQuantity() - quantity);
                    itemTextField.setText("");
                    textFieldQuantity.setText("");
                    updateTextFields(ResourceShell);
                }


                saveFile();
            }

        });
    }

    public void setErrorLabel(String inputText) {
        errorLabel.setText(inputText);
    }

    public void setMarketAuctionText(String inputText) {
        marketAuctionText.setText(inputText);
    }

    public void setCityHallText(String inputText) {
        cityHallText.setText(inputText);
    }

    public void setUpgradesText(String inputText) {
        upgradesText.setText(inputText);
    }

    public void setBuildingsText(String inputText) {
        buildingsText.setText(inputText);
    }

    public void updateTextFields(Resource[] Resources) {
        String marketText = "";
        String resourceText = "";
        for (int i = 0; i < Resources.length; i++) {
            marketText = marketText + Resources[i].getType() + " Cost: " + Resources[i].getCost() + "\n";
        }
        for (int i = 0; i < Resources.length; i++) {
            resourceText = resourceText + Resources[i].getType() + " Quantity: " + Resources[i].getQuantity() + "\n";
        }
        setMarketAuctionText(marketText);
        setCityHallText(resourceText);
    }

    public void setResourceShell(Resource[] input) {
        ResourceShell = input;
    }

    public void saveFile() {
        try {
            Main.Save(ResourceShell);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
