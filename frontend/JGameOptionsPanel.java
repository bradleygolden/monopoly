import java.awt.*;
import javax.swing.*;

public class JGameOptionsPanel extends JPanel
{
  public JButton viewAllPropertiesButton; // pop's up view all properties window
  public JButton gameMenuButton; // pop's up game menu options

  // POST: A new JGameOptionsPanel is created with
  public JGameOptionsPanel()
  {
      viewAllPropertiesButton = new JButton("View All Properties");
      gameMenuButton = new JButton("Game Options");

      this.add(viewAllPropertiesButton); // add button to this panel
      this.add(gameMenuButton); // add button to this panel
  }
}
