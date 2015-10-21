import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MonopolyGUI extends JApplet implements ActionListener
{
    private static final String GAME_MODE = "normal"; // current mode the game is in
    private JFrame frame; // used for pop up windows
    
    private JPanel northPanel; // main panel for north quadrant of app

    private JPlayerMenuPanel playerMenuPanel; // panel that includes user option buttons
    private JGameOptionsPanel gameOptionsPanel; // panel that includes game options buttons
    private JPlayerInfoPanel playerInfoPanel; // panel that includes information about each player
    private JBoardLocationPanel boardLocationPanel; // panel that includes board location info
    private JPropertyInfoPanel[] propertyInfoPanel; // panel that includes information about properties

    private Game game; // holds the current state of the game
    private Player[] players; // player objects of all players currenly playing
    private Player currentPlayer; // the current player
    private Property[] properties; // property objects of all "ownable" properties on the board
    private Color locationColor; // color of the current players location
    private String[] actions; // possible actions the current player can make
    private String locationName; // the current location name of the player's location
    private boolean hasMoved; //true if the player has moved, false if not 
    private boolean performedAction; // true if the player has performed an action

    @Override
    public void init()
    {
        this.startGame(); // start the game and initialize all game related components
        this.setupMainWindow(); // setup the gui
    }

    // POST: a game object is created with the current state set to GAME_MODE
    //       initializes all game related instance variables
    private void startGame()
    {
        this.game = new Game(GAME_MODE); // set up game in predefined GAME_MODE
        this.game.startGame(); // start the current game
        this.players = game.getPlayers(); // initialize array of player objects
        this.currentPlayer = game.getPlayer(); // init the current player
        this.properties = game.getProperties(); // initialize array of property objects
        this.locationColor = game.getColor(); // initialize current location color
        this.locationName = game.getLocationName(); // init first player's location name
        this.actions = game.getPossibleActions(); // init possible actions on starting location
        this.hasMoved = false; // false to indicate that the first player hasn't moved
        this.performedAction = false; // false to indicate that the player can't do any actions until moving
    }

    // POST: a new game object is created with the current state of the new game
    private void restartGame()
    {
        this.startGame(); // reset all instance variables
        this.updateWindow(); // update and repaint the window to reflect new game
    }

    // POST: a gui interface is created to represent the current game state
    private void setupMainWindow()
    {
        setLayout(new BorderLayout()); 

        northPanel = new JPanel(); // initialize northPanel
        JPanel westPadding = new JPanel(); // panel for padding
        JPanel southPadding = new JPanel(); // panel for padding
        JPanel eastPadding = new JPanel(); // panel for padding
        JPanel propertiesPanel = new JPanel(); // panel for holding properties
        playerMenuPanel = new JPlayerMenuPanel(); // panel that holds the player menu options
        playerInfoPanel = new JPlayerInfoPanel(players, currentPlayer); // panel for player information details
        boardLocationPanel = new JBoardLocationPanel(this.locationName, this.locationColor,
                this.actions); // displays current board location details


        playerMenuPanel.setLayout(new GridLayout(1, 3)); // create new panel for player menu options
        propertiesPanel.setLayout(new GridLayout(28,1)); // allow for 28 editable properties
        northPanel.setLayout(new BorderLayout()); // create new borderlayout in north quad of app
        boardLocationPanel.setLayout(new GridLayout(10,4)); // create new layout for center location
        playerInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // align player details left

        // gameOptionsPanel.setBackground(Color.WHITE); // set background of player panel to white
        playerInfoPanel.setBackground(Color.WHITE); // set background of players info panel to white
        playerMenuPanel.setBackground(Color.WHITE); // set background of player menu panel to white
        boardLocationPanel.setBackground(new Color(220, 255, 193)); // monopoly board color
        propertiesPanel.setBackground(new Color(220, 255, 193));

        //
        // setup action listeners
        //
        // playerMenuPanel actionListeners
        playerMenuPanel.turnButton.addActionListener(this);
        playerMenuPanel.leaveGameButton.addActionListener(this);
        playerMenuPanel.endGameButton.addActionListener(this);

        //
        // boardLocationPanel actionListeners
        //
        //iterate through each possible action button
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // add action listener to each possible action button
            boardLocationPanel.actionButton[i].addActionListener(this);
        }

        this.toggleActionButtons(false); // disable action buttons until player has moved

        //
        // Create array of propertyInfoPanels to display property info
        //
        int numProperties = 28;
        propertyInfoPanel = new JPropertyInfoPanel[numProperties];

        for (int i = 0; i < numProperties; i++)
        {
            propertyInfoPanel[i] = new JPropertyInfoPanel(properties[i]); // add property info to panel
            propertyInfoPanel[i].setLayout(new GridLayout(1,7)); // occupies 1 row and 7 columns
            propertyInfoPanel[i].setBackground(new Color(220, 255, 193)); // monopoly board color
            propertiesPanel.add(propertyInfoPanel[i]);
        }

        //saved as an example for possible later use
        //Font playerLabelFont = new Font("TimesRoman", Font.BOLD, 18);
        //playerLabel.setFont(playerLabelFont);

        northPanel.add("Center", playerInfoPanel);
        //northPanel.add("Center", gameOptionsPanel);
        northPanel.add("South", playerMenuPanel);

        add("North", northPanel);
        add("West", boardLocationPanel);
        //add("South", southPadding);
        //add("East", eastPadding);
        add("Center", propertiesPanel);
    }

    // PRE: to be used to update all game related instance variables
    // POST: updates all game related instance variables
    private void updateGame()
    {
        currentPlayer = game.getPlayer(); // update the currentPlayer
        players = game.getPlayers(); // update the players
        properties = game.getProperties(); // update the properties
        locationColor = game.getColor(); // update the current location color
        actions = game.getPossibleActions(); // update the current possible actions for location
        locationName = game.getLocationName(); // update the current location name
    }

    // POST: dynamically updates the player info panel
    private void updatePlayerInfoPanel()
    {
        this.updateGame(); // update all game variables
        this.playerInfoPanel.update(players, currentPlayer); // update player info panel contents
        this.repaint(); // repaint gui
    }

    // PRE: to be used immediately after Game.newTurn() has been called
    // POST: updates the board after Game.newTurn() is called
    private void updateWindow()
    {
        this.updateGame();
        // update boardLocationPanel text, color, and possible actions
        boardLocationPanel.update(locationName, locationColor, actions);

        //
        // add boardLocationPanel button actionListeners
        //
        //iterate through each possible action button
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // remove action listener if it exists
            // this prevents multiple action listeners for the same button
            boardLocationPanel.actionButton[i].removeActionListener(this);
            // add action listener to each possible action button
            boardLocationPanel.actionButton[i].addActionListener(this);
        }

        // update playerInfoPanel
        playerInfoPanel.update(this.players, this.currentPlayer);

        // update propertyInfoPanel
        for (int i = 0; i < propertyInfoPanel.length; i++)
        {
            // update property info panel
            propertyInfoPanel[i].update(properties[i], currentPlayer.getProperties()); 

            // add action listener to improve button
            propertyInfoPanel[i].improve.addActionListener(this);
        }
        this.repaint();
    }

    // POST: disable possibleAction buttons in boardLocationPanel
    private void toggleActionButtons(boolean toggle)
    {
        // iterate through all action buttons
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // disable each button
            boardLocationPanel.actionButton[i].setEnabled(toggle);
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //
        // actions for playerMenuPanel
        //
        if (e.getSource() == playerMenuPanel.turnButton)
        {
            // player wants to roll the dice, check if they've moved already
            if (playerMenuPanel.turnButton.getText().equals("Roll dice") && hasMoved == false)
            {
                game.makeMove(); // roll the dice for the current player
                this.toggleActionButtons(true); //enable action buttons for use by player
                hasMoved = true; // set hasMove to true to indicate that the player has moved
                
                // update board with new player info
                this.updateWindow(); // update GUI

                playerMenuPanel.turnButton.setEnabled(false); // disable until user performs an action
                playerMenuPanel.turnButton.setText("End turn"); // change text of button to End turn
            }
            // player wants to end their turn, check if they've moved yet and peformed an action
            else if (playerMenuPanel.turnButton.getText().equals("End turn") && hasMoved == true
                    && performedAction == true)
            {
                game.nextTurn(); // set up board for next turn
                hasMoved = false; // set hasMoved flag to false for the next player
                performedAction = false; // set performedAction to false for the next player
                playerMenuPanel.turnButton.setText("Roll dice"); // change text of button to Roll dice
                //this.toggleActionButtons(false); // disable action buttons
                this.updateWindow(); // update GUI
                this.toggleActionButtons(false); //disable action buttons
            }
        }

        if (e.getSource() == playerMenuPanel.leaveGameButton)
        {
            // TODO - test this functionality
            game.leaveGame(); // remove the current player from the game
            hasMoved = false; // reset hasMoved
            performedAction = false; // reset actionPerformed
            this.updateWindow(); // update the player window
        }

        // check if user wants to end the game
        if (e.getSource() == playerMenuPanel.endGameButton)
        {
            JOptionPane.showMessageDialog(frame, game.toString()); // dispaly end game results popup

            // TODO - fix this
            this.startGame(); // re-initlialize all game components
            this.updateWindow(); // update window
            //playerMenuPanel.turnButton.setText("Roll dice");
        }

        //
        // actions for boardLocationPanel
        //
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // check if user clicked an action button
            if (e.getSource() == boardLocationPanel.actionButton[i])
            {
                if (hasMoved) // check that player has moved first
                {
                    // attempt to perform a possible action
                    if(game.performAction(boardLocationPanel.actionButton[i].getText()))
                    {
                        performedAction = true; // user performed an action, set the flag
                        this.updatePlayerInfoPanel(); // dynamically update player info panel
                        playerMenuPanel.turnButton.setEnabled(true); // enable button after action
                        this.toggleActionButtons(false); // disable action buttons
                    }
                    else
                    {
                        // in case an error occurred
                        System.out.println("Action: " + boardLocationPanel.actionButton[i].getText()
                                + " failed.");
                    }
                }
            }
        }

        ///
        // actions for propertyInfoPanel
        //
        for (int i = 0; i < propertyInfoPanel.length; i++)
        {
            // check if user clicked the improve button
            if(e.getSource() == propertyInfoPanel[i].improve)
            {
                if(game.improveProperty(properties[i]))
                {
                    this.updatePlayerInfoPanel(); // dynamically update player info panel
                }
                else
                {
                    // Display message to user
                    JOptionPane.showMessageDialog(frame, "You cannot improve this property");  
                }
            }
        }
    }
}
