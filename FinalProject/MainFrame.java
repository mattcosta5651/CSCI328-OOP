import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MainFrame extends JFrame
{
  private final int WIDTH = 1200;
  private final int HEIGHT = 800;
  
  public static void main(String args[])
  {
    JFrame frame = new MainFrame();
  }

  public MainFrame()
  {
    super("Game Engine Example");
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    int interval = 100;

    // model
    Map<String, List<IGameObject>> objects = new HashMap<String, List<IGameObject>>();
    objects.put("Enemies", Factory.getInstance().createEnemies(WIDTH, HEIGHT, 30, 30, 5, 5)); 
    objects.put("Hero", new ArrayList());
    objects.get("Hero").add(Factory.getInstance().createHero(WIDTH, HEIGHT, 40, 40, 5, 5));

    // view
    IGameView view = Factory.getInstance().createMainView(objects);
    IGameView statusView = Factory.getInstance().createStatusView(objects);
    List<IGameView> views = new ArrayList<IGameView>();
    views.add(view);
    views.add(statusView);

    // controller
    IGameController controller = Factory.getInstance().createController(interval, objects, views);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(view.getJPanel(), BorderLayout.CENTER);
    getContentPane().add(statusView.getJPanel(), BorderLayout.SOUTH);

	this.setVisible(true);

    controller.startGame();
  }
}
