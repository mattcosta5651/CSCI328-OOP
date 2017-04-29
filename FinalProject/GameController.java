import javax.swing.Timer;
import java.awt.event.*;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class GameController implements ActionListener, KeyListener, IGameController
{
  private Timer m_timer;
  private Timer countdown;
  private int time;
  private Map<String, List<IGameObject>> m_objects;
  private List<IGameView> m_views;

  public GameController(int interval, Map<String, List<IGameObject>> objects, List<IGameView> views)
  {
    m_objects = objects;
    m_views = views;
    m_timer = new Timer(interval, this);
    countdown = new Timer(1000, this);
    time = 60;
	m_views.get(0).getJPanel().addKeyListener(this);
  }

  @Override
  public void startGame()
  {
    m_timer.start();
    countdown.start();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
	Hero hero = (Hero) m_objects.get("Hero").get(0);
	for(List<IGameObject> list : m_objects.values()){
		for (IGameObject obj : list){
		  obj.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
		  if(hero.getRectangle().intersects(obj.getRectangle()) && obj != hero){
			hero.loseLife();
			m_views.get(0).flashRed();
		}
	  }
	}

    for (IGameView obj : m_views)
    {
      obj.tick(time);
    }
    
    if(e.getSource() == countdown)
		time--;
	
	if(time == 0 || hero.getLives() < 0){
		countdown.stop();
		m_timer.stop();
	}
  }
  
	public void	keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_A){
			m_objects.get("Hero").get(0).moveLeft();
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			m_objects.get("Hero").get(0).moveRight();
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			m_objects.get("Hero").get(0).moveUp();
		}				
		if(e.getKeyCode() == KeyEvent.VK_S){
			m_objects.get("Hero").get(0).moveDown();
		}		
	}
	
	public void	keyReleased(KeyEvent e){
		
	}
	
	public void	keyTyped(KeyEvent e){
		
	}
}
