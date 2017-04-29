import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

public class FancyView extends StatusView
{	
  private Color[] rainbow = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta};
  private int m_ticks = 0;
  
  public FancyView(Map<String, List<IGameObject>> objects)
  {
	super(objects);
  }

  @Override
  public void tick(int time)
  {
	super.tick(time);
	if(m_ticks >= rainbow.length)
		m_ticks = 0;
	  
	setBackground(rainbow[m_ticks]);
	
    m_ticks++;
  }

  @Override
  public JPanel getJPanel()
  {
    return this;
  }
}
