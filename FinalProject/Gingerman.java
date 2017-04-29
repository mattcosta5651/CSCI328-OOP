public class Gingerman extends GameObject
{
  private int m_ticks = 0;
  private final int radius = 5;
  private double angle = 0.0;
	
  public Gingerman(int x, int y, int w, int h, int dX, int dY)
  {
    super("./gingerman.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    if(Math.round((float) Math.cos(angle) * radius) > 0){
		m_x = m_x + Math.round((float) Math.sin(angle) * radius) + m_dX;
		m_y = m_y + Math.round((float) Math.cos(angle) * radius) + m_dY;		
	}
	else if (Math.round((float) Math.cos(angle) * radius) < 0){
		m_x = m_x + Math.round((float) Math.cos(angle) * radius) + m_dX;
		m_y = m_y + Math.round((float) Math.sin(angle) * radius) + m_dY;		
	}
	
    loop(maxw, maxh);  
    angle += 0.1;
  }

}
