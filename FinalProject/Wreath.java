public class Wreath extends GameObject
{
  private int m_ticks = 0;
  private final int radius = 5;
  private double angle = 0.0;
	
  public Wreath(int x, int y, int w, int h, int dX, int dY)
  {
    super("./wreath.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + Math.round((float) Math.cos(angle) * radius);
    m_y = m_y + Math.round((float) Math.sin(angle) * radius);
    
    
    if(Math.round((float) Math.sin(angle) * radius) == 0){
		if(m_ticks % 2 == 0)
			m_x += (m_dX);
		else
			m_y += (m_dY);
		m_ticks++;
	}
	
    loop(maxw, maxh);  
    angle += 0.1;
  }

}
