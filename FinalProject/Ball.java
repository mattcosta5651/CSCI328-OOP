public class Ball extends GameObject
{
  public Ball(int x, int y, int w, int h, int dX, int dY)
  {
    super("./ball.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_x = m_x + m_dX*2;
    m_y = m_y + m_dY/2;
    
    loop(maxw, maxh);
  }

}
