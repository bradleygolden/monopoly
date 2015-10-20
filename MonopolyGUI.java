import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MonopolyGUI extends JApplet implements ActionListener
{
    private static final String GAME_MODE = "demo"; // current mode the game is in
    private JFrame frame; // used for pop up windows

    private JPlayerMenuPanel playerMenuPanel; // panel that includes user option buttons
    private JGameOptionsPanel gameOptionsPanel; // panel that includes game options buttons
    private JPlayerInfoPanel playerInfoPanel; // panel that includes information about each player
    private JBoardLocationPanel boardLocationPanel; // panel that includes board location info
    private JPropertyInfoPanel propertyInfoPanel; // panel that includes information about properties

    private Game game; // holds the current state of the game
    private Player[] players; // player objects of all players currenly playing
    private Player currentPlayer; // the current player
    private Property[] properties; // property objects of all "ownable" properties on the board
    private Color locationColor; // color of the current players location
    private String[] actions; // possible actions the current player can make
    private String locationName; // the current location name of the player's location
    private boolean rollDiceFlag; // displays whether the dice need to be rolled or not

    @Override
    public void init()
    {
        this.startGame(); // start the game and initialize all game related components
        this.setupMainWindow(); // setup the gui
    }

    // POST: a game object is created with the current state set to GAME_MODE
    private void startGame()
    {
        this.game = new Game(GAME_MODE); // set up game in predefined GAME_MODE
        game.startGame(); // start the current game
        this.players = game.getPlayers(); // initialize array of player objects
        this.currentPlayer = game.getPlayer(); // init the current player
        this.properties = game.getProperties(); // initialize array of property objects
        this.locationColor = game.getColor(); // initialize current location color
        this.locationName = game.getLocationName(); // init first player's location name
        this.actions = game.getPossibleActions(); // init possible actions on starting location
        this.rollDiceFlag = true; // dice needs to be rolled
    }

    // POST: a gui interface is created to represent the current game state
    private void setupMainWindow()
    {
        // Needed API calls
        // Game game = new Game();
        // Players[] players = game.getPlayers();
        // Properties[] properties = game.getProperties();
        // String[] actions = game.getPossibleActions();
        // game.rollDice();
        // int[] rollValues = game.getDiceValues();
        // game.nextTurn();
        // Player player = game.getPlayer();
        // Boardlocation location = game.getLocation();
        // Color locationColor = game.getLocationColor();
        // game.leaveGame();
        // game.improveProperty(Property property);
        // game.performAction(String action);

        String[][] playerArr = {{"Dog", "Cash: 1000", "Location: Boardwalk"},
            {"Top Hat", "Cash: 500", "Location: St. Charles Place"}};
        String[] actions = {"Buy", "Park for free"};
        String location = "Boardwalk";

        setLayout(new BorderLayout()); 

        JPanel northPanel = new JPanel(); // main panel for north quadrant of app
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

        //
        // Create array of propertyInfoPanels to display property info
        //
        int numProperties = 28;
        JPropertyInfoPanel[] propertyInfoPanel = new JPropertyInfoPanel[numProperties];

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
    
    // PRE: to be used immediately after Game.newTurn() has been called
    // POST: updates the board after Game.newTurn() is called
    private void updateBoard()
    {
        currentPlayer = game.getPlayer(); // update the currentPlayer
        System.out.println(currentPlayer.toString()); //TODO - bug doesn't advance next player
        locationName = game.getLocationName(); // update the current location name
        locationColor = game.getColor(); // update the current location color
        actions = game.getPossibleActions(); // update the current possible actions for location

        // update boardLocationPanel text, color, and possible actions
        boardLocationPanel.update(locationName, locationColor, actions);

        //
        // boardLocationPanel actionListeners
        //
        //iterate through each possible action button
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // add action listener to each possible action button
            boardLocationPanel.actionButton[i].addActionListener(this);
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
            // player wants to roll the dice
            if (playerMenuPanel.turnButton.getText().equals("Roll dice"))
            {
                game.makeMove(); // roll the dice for the current player
                // update board with new player info
                this.updateBoard(); // update GUI
                playerMenuPanel.turnButton.setText("End turn"); // change text of button to End turn
            }
            // player wants to end their turn
            else if (playerMenuPanel.turnButton.getText().equals("End turn"))
            {
                game.nextTurn(); // set up board for next turn
                this.updateBoard(); // update GUI
                playerMenuPanel.turnButton.setText("Roll dice"); // change text of button to Roll dice
            }
        }

        if (e.getSource() == playerMenuPanel.leaveGameButton)
            System.out.println("leaveGameButton");
        if (e.getSource() == playerMenuPanel.endGameButton)
        {
            //game = new Game(GAME_MODE);
        }

        //
        // actions for boardLocationPanel
        //
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            // check if user clicked an action button
            if (e.getSource() == boardLocationPanel.actionButton[i])
                System.out.println(boardLocationPanel.actionButton[i].getText());
        }
        
    }
}
