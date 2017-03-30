import javax.swing.Timer;
import java.awt.event.*;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GameController implements ActionListener, KeyListener, IGameController
{
  private Timer m_timer;
  private List<IGameObject> m_objects;
  private List<IGameView> m_views;

  public GameController(int interval, List<IGameObject> objects, List<IGameView> views)
  {
    m_objects = objects;
    m_views = views;
    m_timer = new Timer(interval, this);
	m_views.get(0).getJPanel().addKeyListener(this);
  }

  @Override
  public void startGame()
  {
    m_timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    for (IGameObject obj : m_objects)
    {
      obj.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
    }

    for (IGameView obj : m_views)
    {
      obj.tick();
    }
  }
  
	public void	keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_A){
			m_objects.get(1).moveLeft();
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			m_objects.get(1).moveRight();
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			m_objects.get(1).moveUp();
		}				
		if(e.getKeyCode() == KeyEvent.VK_S){
			m_objects.get(1).moveDown();
		}		
	}
	
	public void	keyReleased(KeyEvent e){
		
	}
	
	public void	keyTyped(KeyEvent e){
		
	}
}
