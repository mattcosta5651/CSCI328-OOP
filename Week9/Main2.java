public class Main2{
	public static void main(String[] args){
		new Main2().go();
	}
	
	private void go(){
		int start = 0;
		int end = 10;
		int num = 5;//Math.random() * 10;
		
		IGuessStrategy2 s1 = new DummyStrategy2();
		IGuessStrategy2 s2 = new TopDownStrategy2();
		
		int guess1 = s1.guess(start, end);
		int guess2 = s2.guess(start, end);
		
		while(guess1 != num || guess2 != num){
			guess1 = s1.guess(start, end);
			guess2 = s2.guess(start, end);
		}
		
		if(guess1 == num)
			System.out.println(guess1);
		else
			System.out.println(guess2);
	}
}
