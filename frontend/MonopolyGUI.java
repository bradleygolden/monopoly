import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;

public class MonopolyGUI extends JApplet
{
    /********************************
     * Declare player menu variables
     * *****************************/
    private JLabel playerLabel; // shows which player's turn it is
    private JLabel cashLabel; // label that displays "Cash: "
    private JLabel playerCash; // displays current player's cash on hand
    private JButton playerMenuButton; // dislays the player menu on click
    private JButton endTurnButton; // ends the player's turn

    /******************************************
     * Declare board location display variables
     * ***************************************/
    private JLabel locationLabel; // name of the current player's location
    private JButton[] actionButton; // array of possible user action buttons

    @Override
    public void init()
    {
        this.setupLayout();
    }

    private void setupLayout()
    {
        setLayout(new BorderLayout()); 

        // number of buttons to be displayed is dependent on the number of possible user actions
        int possibleActions = 2;

        JPanel playerPanel = new JPanel(); // top player panel
        JPanel boardLocationPanel = new JPanel(); // board location panel

        playerPanel.setBackground(Color.WHITE);

        playerLabel = new JLabel("Player 1"); // create new player label set to player token name
        cashLabel = new JLabel("Cash:"); // create new label to be displayed next to playerCash
        playerCash = new JLabel("1000"); // create new player cash label set to player cash amount
        locationLabel = new JLabel("Boardwalk"); // create new location label


        playerMenuButton = new JButton("Properties Menu"); // create new properties button
        endTurnButton = new JButton("End Turn");
        actionButton = new JButton[possibleActions];

        // display possible player actions in the form of buttons
        for (int i=0; i<possibleActions; i++)
        {
            actionButton[i] = new JButton("test");
        }

        locationLabel.setOpaque(true);
        locationLabel.setBackground(Color.BLUE);
        locationLabel.setForeground(Color.WHITE);
        endTurnButton.setForeground(Color.RED);
        boardLocationPanel.setBackground(new Color(220, 255, 193));

        Font playerLabelFont = new Font("TimesRoman", Font.BOLD, 18);
        Font locationLabelFont = new Font("TimesRoman", Font.BOLD, 32);

        playerLabel.setFont(playerLabelFont);
        locationLabel.setFont(locationLabelFont); // set locationLabel to custom font

        playerPanel.add(playerLabel);
        playerPanel.add(cashLabel);
        playerPanel.add(playerCash);
        playerPanel.add(playerMenuButton);
        playerPanel.add(endTurnButton);
        boardLocationPanel.add(locationLabel);

        for (int i=0; i<possibleActions; i++)
        {
            boardLocationPanel.add(actionButton[i]);
        }

        add("North", playerPanel); // add player panel to north section of gui
        add("Center", boardLocationPanel); // add boardLocation panel to center section of gui
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }
}
