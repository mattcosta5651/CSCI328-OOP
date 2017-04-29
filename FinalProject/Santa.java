public class Santa extends Hero
{
  private int m_ticks = 0;
  private java.util.Random m_rand = new java.util.Random();

  public Santa(int x, int y, int w, int h, int dX, int dY)
  {
    super("./santa.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks++;
    if (m_ticks % 10 == 0)
    {
		int dir = m_rand.nextInt(4);
		
		if(dir == 0){
			for(int i = 0; i < 5; i++)
				moveLeft();
		}
		if(dir == 1)
			for(int i = 0; i < 5; i++)		
				moveRight();
		if(dir == 2)
			for(int i = 0; i < 5; i++)
				moveUp();
		if(dir == 3)
			for(int i = 0; i < 5; i++)
				moveDown();
    }
    
    loop(maxw, maxh);    
  }		
}
