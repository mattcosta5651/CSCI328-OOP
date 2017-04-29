public class Reindeer extends Hero
{
  private int m_ticks = 0;
  private java.util.Random m_rand = new java.util.Random();

  public Reindeer(int x, int y, int w, int h, int dX, int dY)
  {
    super("./reindeer.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks++;
    if (m_ticks % 50 == 0)
    {
		int dir = m_rand.nextInt(2);
		
		if(dir == 0){
			m_dX++;
		}
		if(dir == 1)
			m_dY++;
    }
    
    loop(maxw, maxh);    
  }		
}
