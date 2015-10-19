import java.awt.*;
import javax.swing.*;

public class JPlayerInfoPanel extends JPanel
{
  private JLabel playerInfoLabel; // contains string of player info
  private String playerInfoString; // string of player info
  private int numPlayers; // number of players total

  public JPlayerInfoPanel()
  {
      playerInfoString = "";
  }

  // PRE:  a 2d array of strings containing player info
  //       the first index of each player is the name of the player's token
  // POST: a JPlayerInfoPanel object is created with 1 component:
  //     -- playerInfoLabel - JLabel containing information about players
  public JPlayerInfoPanel(String[][] players)
  {
    this();
    numPlayers = players.length; // get number of players

    playerInfoString = this.extractPlayerInfo(players); // player data to 1D string

    playerInfoLabel = new JLabel(playerInfoString); // label contains player details

    this.add(playerInfoLabel);
  }

  //// PRE: an array of players
  //// POST: a JPlayerInfoPanel object is created, displaying the current players as a string
  ////       highlights the first player red to indicate it's that players turn
  //public JPlayerInfoPanel(Players[] players)
  //{
      //this();
      //playerInfoString = this.getPlayerInfoString(players, players[0]); // player data into 1D string
      //playerInfoLabel = new JLabel(playerInfoString); // label contains player details
      //this.add(playerInfoLabel);
  //}

  //// PRE: array of player objects, player = current player's player
  ////      n >= 0 and n <= number of players - 1 (starts at 0th index)
  //// POST: a string of player's with the nth player highlighted red
  //private String getPlayerInfoString(Players[] players, Player player)
  //{
      //if ( n < 0 || n > players.length-1)
          //return ""; // incorrect player number
      
      //playerInfoString = "<html>";
        
      //for (int i = 0; i < players.length; i++)
      //{
          //if (players[i] == player) // the current player will be highlighted red and text is enlarged
              //playerInfoString += "<h3 style='color:red;'>" + players[i].toString() + "</h3>";
          //else
              //playerInfoString += "<p>" + players[i].toString() + "</p>";
      //}

      //return playerInfoString += "</html>";
  //}


  // PRE: a 2d array of strings containing information about each player
  //      the first index of each player is the name of the player's token
  // POST: FCTVAL == one string with all player infomation concatenated
  private String extractPlayerInfo(String[][] players)
  {
    playerInfoString = "<html>";
    for (int i = 0; i < numPlayers; i++) // loop through each player
    {
      for (int j = 0; j < players[i].length; j++) // loop through player details
      {
        if (j == 0) // at token string
          playerInfoString += "<h3>" + players[i][j] + "</h3>"; // enlarge token text

        else // at cash and location string
          playerInfoString += " " + players[i][j]; // space each detail about player
      }
      playerInfoString += "<br>"; // new line after each player is extracted
    }
    return playerInfoString + "</html>";
  }
}
