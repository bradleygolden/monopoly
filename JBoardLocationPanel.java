import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class JBoardLocationPanel extends JPanel
{
    public JLabel boardLocationLabel; // location of current player
    public JButton[] actionButton; // possible user actions
    private int numActions; // number of totla possible user actions

    public JBoardLocationPanel()
    {
        // do nothing
        numActions = 0;
    }

    // PRE:  possibleUserActions = a string array of possible user actions
    //       boardLocation = the name of the user's location
    // POST: a JBoardLocationPanel object is created with 2 components
    //    -- boardLocationLabel - JLabel containing the name of the player's location
    //    -- color = color of the board location
    //    -- actionButton's     - JButton list of possible user actions
    public JBoardLocationPanel(String boardLocation, Color color,
            String[] possibleUserActions)
    {
        this();
        boardLocationLabel = new JLabel(boardLocation, JLabel.CENTER); // center label
        this.update(boardLocation, color, possibleUserActions);
    }

    // see previous constructor
    // this method is used to not only initialize this panel but to update it as well
    public void update(String boardLocation, Color color, String[] possibleUserActions)
    {
        //this.removeAll();

        // remove all old actionButtons prior to adding new ones
        if (actionButton != null)
        {
            for (int i = 0; i < actionButton.length; i++)
            {
                this.remove(actionButton[i]);
            }
        }

        // update the label
        boardLocationLabel.setText(boardLocation);
        numActions = possibleUserActions.length; // get number of possible actions

        // initialize array of buttons
        actionButton = new JButton[numActions];

        boardLocationLabel.setOpaque(true); // allow for label background coloring
        boardLocationLabel.setBackground(color); // set background of board location label

        // text is hard to read if dark blue, change font to white in this case, otherwise
        // default to black
        if (color.toString().equals("java.awt.Color[r=0,g=0,b=255]")) // check if color is blue
            boardLocationLabel.setForeground(Color.WHITE); // set font color of board location label
        else
            boardLocationLabel.setForeground(Color.BLACK); // set font color of board location label

        Font locationLabelFont = new Font("TimesRoman", Font.BOLD, 32);
        boardLocationLabel.setFont(locationLabelFont); // set locationLabel to custom font

        this.add(boardLocationLabel); // add location string to panel

        // iterate through each possible user action
        for (int i = 0; i < numActions; i++)
        {
            // add a button for each user action
            actionButton[i] = new JButton(possibleUserActions[i]);
            this.add(actionButton[i]);
        }
    }
}
