import java.awt.*;
import javax.swing.*;

public class JPlayerInfoPanel extends JPanel
{
  private JLabel playerInfoLabel; // contains string of player info
  private Player[] players; // array of players currently playing the game
  private String playerInfoString; // string of player info
  private int numPlayers; // number of players total

  public JPlayerInfoPanel()
  {
      // do nothing
  }

  // PRE: an array of players
  // POST: a JPlayerInfoPanel object is created, displaying the current players as a string
  //       highlights the first player red to indicate it's that players turn
  public JPlayerInfoPanel(Player[] players, Player player)
  {
      this();
      playerInfoString = this.getPlayerInfoString(players, player); // player data into 1D string
      playerInfoLabel = new JLabel(playerInfoString); // label contains player details
      this.add(playerInfoLabel);
  }

  // PRE: array of player objects, player = current player
  // POST: a string of all players info
  //       the current player is highlighted red
  private String getPlayerInfoString(Player[] players, Player player)
  {
      playerInfoString = "<html>";
        
      for (Player aPlayer : players)
      {
          if (aPlayer == player) // the current player will be highlighted red and text is enlarged
              playerInfoString += "<h3 style='color:red;'>" + aPlayer.toString() + "</h3>";
          else
              playerInfoString += "<p>" + aPlayer.toString() + "</p>";
      }

      return playerInfoString += "</html>";
  }
}
