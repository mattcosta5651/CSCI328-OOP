public class DummyStrategy2 implements IGuessStrategy2{
	@Override
	public int guess(int start, int end){
		return (end - start)/2;
	}
}
