import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameView extends JPanel implements IGameView
{
    private Map<String, List<IGameObject>> m_objects;

    public GameView(Map<String, List<IGameObject>> objects)
    {
      setOpaque(true);
      setBackground(Color.white);
      setIgnoreRepaint(true);
      m_objects = objects;
	  setFocusable(true);
	  requestFocusInWindow();      
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Image bufferedImage = createImage(getWidth(), getHeight());
        Graphics2D buffer = (Graphics2D) bufferedImage.getGraphics();
		for(List<IGameObject> list : m_objects.values()){
			for (IGameObject obj : list)
				buffer.drawImage(obj.getImage(), obj.getX(), obj.getY(), obj.getW(), obj.getH(), this);
        }

        g.drawImage(bufferedImage, 0, 0, this);
    }

    @Override
    public void tick(int remainingTime)
    {
      repaint();
    }

    @Override
    public JPanel getJPanel()
    { return this; }

	@Override
	public void flashRed(){
		setBackground(Color.red);
		setBackground(Color.white);
	}
}
