public abstract class Hero extends GameObject{
	protected int lives;
	
	protected Hero(String image, int x, int y, int w, int h, int dX, int dY){
		super(image, x, y, w, h, dX, dY);	
		lives = 3;	
	}
	
	@Override
	abstract public void tick(int maxw, int maxh);
	
	public int getLives(){
		return lives;
	}
	
	public void loseLife(){
		lives--;
	}
}
