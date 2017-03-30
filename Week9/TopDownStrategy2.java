public class TopDownStrategy2 implements IGuessStrategy2{
	private int lastGuess = Integer.MIN_VALUE;
	
	@Overide
	public int guess(int start, int end){
		if(lastGuess < start)
			lastGuess = end;
		else
			lastGuess -= 1;
		
		return lastGuess; 
	}
}
