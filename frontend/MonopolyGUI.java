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

    private JPlayerMenuPanel playerMenuPanel; // panel that includes user option buttons
    private JGameOptionsPanel gameOptionsPanel; // panel that includes game options buttons
    private JPlayerInfoPanel playerInfoPanel; // panel that includes information about each player
    private JBoardLocationPanel boardLocationPanel; // panel that includes board location info
    private JPropertyInfoPanel propertyInfoPanel; // panel that includes information about properties

    @Override
    public void init()
    {
        this.setupMainWindow();
    }

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
        playerMenuPanel = new JPlayerMenuPanel();
        gameOptionsPanel = new JGameOptionsPanel();
        playerInfoPanel = new JPlayerInfoPanel(playerArr);
        boardLocationPanel = new JBoardLocationPanel(location, Color.BLUE, actions);


        gameOptionsPanel.setLayout(new GridLayout(2,1)); // create 2x1 button
        playerMenuPanel.setLayout(new GridLayout(1, 3)); // create new panel for player menu options
        propertiesPanel.setLayout(new GridLayout(28,1)); // allow for 28 editable properties
        northPanel.setLayout(new BorderLayout()); // create new borderlayout in north quad of app
        boardLocationPanel.setLayout(new GridLayout(10,4)); // create new layout for center location
        playerInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

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
        // Create array of propertyInfoPanels HERE
        //
        int numProperties = 28;
        JPropertyInfoPanel[] propertyInfoPanel = new JPropertyInfoPanel[numProperties];

        for (int i = 0; i < 1; i++)
        {
            propertyInfoPanel[i] = new JPropertyInfoPanel("Boardwalk", "Price: 200",
                    "Improvements: 5", "Owner: Me", "Rent: 400", true);
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
            System.out.println("turnButton");
        if (e.getSource() == playerMenuPanel.leaveGameButton)
            System.out.println("leaveGameButton");
        if (e.getSource() == playerMenuPanel.endGameButton)
            System.out.println("endGameButton");

        //
        // actions for boardLocationPanel
        //
        for (int i = 0; i < boardLocationPanel.actionButton.length; i++)
        {
            if (e.getSource() == boardLocationPanel.actionButton[i]) 
                System.out.println(boardLocationPanel.actionButton[i].getText());
        }
        
    }
}
