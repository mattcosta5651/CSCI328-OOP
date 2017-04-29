import javax.swing.*;
import java.awt.event.*;

public interface IGameView
{
  public void tick(int time);
  public int getWidth();
  public int getHeight();
  public JPanel getJPanel();
  public void flashRed();
}
