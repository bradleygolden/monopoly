// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 21, 2015
// Description: This class creates a panel that serves as a player menu

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JPlayerMenuPanel extends JPanel
{
  private JLabel panelTitleLabel; // title of this panel
  private String titleString; // stirng containing the title
  public JButton turnButton; // button that begins and ends a turn
  public JButton leaveGameButton; // player can leave the game
  public JButton endGameButton; // ends the game

  // POST: A new JPlayerMenuPanel object is created with 4 components:
  //      -- panelTitleLabel of type JLabel
  //      -- turnButton of type JButton
  //      -- leaveGameButton of type JButton
  //      -- endGameButton of type JButton
  public JPlayerMenuPanel()
  {
      turnButton = new JButton("Roll dice");
      leaveGameButton = new JButton("Leave Game");
      endGameButton = new JButton("End Game");

      titleString = "<html><strong>Player Menu</strong></html>"; // bold
      panelTitleLabel = new JLabel(titleString); // add title string to label

      this.add(panelTitleLabel); // add the title of the panel
      this.add(turnButton); // add turn button
      this.add(leaveGameButton); // add leave game button
      this.add(endGameButton); // add button to panel
  }
}
