public class RatioPicker implements IWordPicker{
    @Override
    public boolean approveWord(String word)
    {
		return (count(false, word) >= (word.toCharArray().length * ((double)1/3)));
    }	
    
    private int count(boolean vowels, String word){
		int total = 0;
		char[] chars = word.toCharArray();
		
		for(char c : chars){
			if(isVowel(c) && vowels)
				total++;
			else if(!isVowel(c) && !vowels)
				total++;
		}
		
		return total;
	}
	
	private boolean isVowel(char c){
		switch(Character.toUpperCase(c)){
			case 'A':
				return true;
			case 'E':
				return true;
			case 'I':
				return true;
			case 'O':
				return true;
			case 'U':
				return true;
			default:
				return false;
		}
	}
}
