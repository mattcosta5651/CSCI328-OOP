public class Ball extends GameObject
{

  public Ball(int x, int y, int w, int h, int dX, int dY)
  {
    super("./ball.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
	if(m_x+m_w/2 >= maxw)
		m_x = 0;
	else if(m_x+m_w/2 <= 0)
		m_x = maxw-m_w;
	else if(m_x+m_w/2 == other.getX()-other.getW()/2){
		this.reverseX();
		other.reverseX();
	}
	else
		m_x = m_x + m_dX;
	
	if(m_y+m_h/2 >= maxh)
		m_y = 0;
	else if(m_y+m_h/2 <= 0)
		m_y = maxh-m_h;
	else if(m_y+m_h/2 == other.getY()-other.getH()/2){
		this.reverseY();
		other.reverseY();	
	}		
	else
		m_y = m_y + m_dY;
		
  }

}
