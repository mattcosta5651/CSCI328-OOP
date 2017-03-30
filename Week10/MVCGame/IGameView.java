import javax.swing.*;
import java.awt.event.*;

public interface IGameView
{
  public void tick();
  public int getWidth();
  public int getHeight();
  public JPanel getJPanel();
}
