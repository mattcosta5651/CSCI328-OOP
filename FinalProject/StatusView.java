import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.Color;

public abstract class StatusView extends JPanel implements IGameView{
  protected JLabel m_status = new JLabel();
  protected JLabel m_game = new JLabel();
  protected Map<String, List<IGameObject>> m_objects;
   
  protected StatusView(Map<String, List<IGameObject>> objects)
  {
    m_objects = objects;
    setLayout(new BorderLayout());
    m_status.setText("");
    add(m_status, BorderLayout.WEST);
    add(m_game, BorderLayout.EAST);
  }	
	
  public void tick(int time){
	Hero hero = (Hero) m_objects.get("Hero").get(0);
	if(hero.getLives() > 0 && time > 0){  
		m_status.setText(String.format("HX: %s HY: %s dX: %s, dY: %s",
				m_objects.get("Hero").get(0).getX(), m_objects.get("Hero").get(0).getY(), 
				m_objects.get("Hero").get(0).getDX(), m_objects.get("Hero").get(0).getDY()));
		m_game.setText(String.format("Lives: %s Time remaining: %s",hero.getLives(), time-1));
	}
	if(hero.getLives() == 0){
		m_status.setText("YOU LOST");
		m_status.setBackground(Color.red);
		m_game.setBackground(Color.red);
	}
	if(hero.getLives() > 0 && time == 0){
		m_status.setText("YOU WON");
		m_status.setBackground(Color.green);
		m_game.setBackground(Color.green);		
	}
  }
  
  
 
  @Override
  public JPanel getJPanel()
  {
    return this;
  }
}
