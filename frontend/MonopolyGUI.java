import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MonopolyGUI extends JApplet implements ActionListener
{
    private JFrame frame; // used for pop up windows

    /********************************
     * player menu variables
     * *****************************/
    private JLabel playerLabel; // shows which player's turn it is
    private JLabel cashLabel; // label that displays "Cash: "
    private JLabel playerCash; // displays current player's cash on hand
    private JButton playerMenuButton; // dislays the player menu on click
    private JButton turnButton; // toggle player's turn (end turn or roll dice at start of turn)

    /******************************************
     * board location display variables
     * ***************************************/
    private int numActions; // number of possible player actions
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
        numActions = 2;

        JPanel playerPanel = new JPanel(); // top player panel
        JPanel boardLocationPanel = new JPanel(); // board location panel
        JPanel cashPanel = new JPanel(); // panel to hold player cash amount
        JPanel westPadding = new JPanel(); // panel for padding
        JPanel southPadding = new JPanel(); // panel for padding
        JPanel eastPadding = new JPanel(); // panel for padding

        playerPanel.setLayout(new GridLayout(2,4)); // create new layout for playerPanel
        boardLocationPanel.setLayout(new GridLayout(10,4)); // create new layout for center location
        cashPanel.setLayout(new FlowLayout(FlowLayout.LEADING)); // set cash panel to be left aligned

        playerPanel.setBackground(Color.WHITE); // set background of player panel to white
        cashPanel.setBackground(Color.WHITE); // set background of cash panel to white

        playerLabel = new JLabel("Player 1"); // create new player label set to player token name
        cashLabel = new JLabel("Cash:"); // create new label to be displayed next to playerCash
        playerCash = new JLabel("1000"); // create new player cash label set to player cash amount
        locationLabel = new JLabel("Boardwalk", JLabel.CENTER); // create new location label


        playerMenuButton = new JButton("Properties Menu"); // create new properties button
        turnButton = new JButton("End Turn"); // create turn button
        actionButton = new JButton[numActions]; // create array of action buttons

        // temp string array for display purposes TODO - remove this later
        String[] actions = {"Buy", "Park for free"};

        // display possible player actions in the form of buttons
        for (int i=0; i<numActions; i++)
        {
            actionButton[i] = new JButton(actions[i]); // create new action button
            actionButton[i].addActionListener(this); // add action listeners to each button
            //actionButton[i].setActionCommand(Integer.toString(i));
        }

        playerMenuButton.addActionListener(this);
        turnButton.addActionListener(this);

        locationLabel.setOpaque(true); // allow for label background coloring
        locationLabel.setBackground(Color.BLUE); // set background of board location label
        locationLabel.setForeground(Color.WHITE); // set font color of board location label
        turnButton.setForeground(Color.RED); // set font color of turn button
        boardLocationPanel.setBackground(new Color(220, 255, 193)); // monopoly board color

        Font playerLabelFont = new Font("TimesRoman", Font.BOLD, 18);
        Font locationLabelFont = new Font("TimesRoman", Font.BOLD, 32);

        playerLabel.setFont(playerLabelFont);
        locationLabel.setFont(locationLabelFont); // set locationLabel to custom font

        cashPanel.add(cashLabel);
        cashPanel.add(playerCash);
        playerPanel.add(playerLabel);
        playerPanel.add(playerMenuButton);
        playerPanel.add(cashPanel);
        playerPanel.add(turnButton);
        boardLocationPanel.add(locationLabel);

        for (int i=0; i<numActions; i++)
        {
            boardLocationPanel.add(actionButton[i]); // add possible action buttons to display
        } 

        add("North", playerPanel); // add player panel to north section of gui
        add("Center", boardLocationPanel); // add boardLocation panel to center section of gui
        add("West", westPadding);
        add("South", southPadding);
        add("East", eastPadding);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == playerMenuButton)
        {
            JOptionPane.showMessageDialog(frame,
                    "Eggs are not supposed to be green.",
                    "A plain message",
                    JOptionPane.PLAIN_MESSAGE);
        }

        if (e.getSource() == turnButton)
        {
            JOptionPane.showMessageDialog(frame,
                    "Eggs are not supposed to be green.",
                    "A plain message",
                    JOptionPane.PLAIN_MESSAGE);
            turnButton.setText("Roll die");
        }

        for (int i=0; i<numActions; i++)
        {
            if (e.getSource() == actionButton[i])
            {
                System.out.println("button " + i + " pressed");
                //do something
            }
        }

    }
}
