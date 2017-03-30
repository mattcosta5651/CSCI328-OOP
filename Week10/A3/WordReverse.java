import java.util.*;

public class WordReverse implements ICrypto{
	private static WordReverse m_instance;
	
	public static WordReverse getInstance(){
		if(m_instance == null)
			return new WordReverse();
		else
			return m_instance;
	}
	
	private WordReverse(){}
	
	public String encrypt(String message){
		IMessageParser parser = Factory.getInstance().createParser(message);
		StringBuffer ret = new StringBuffer();
		
		for(int i = 0; i < parser.getWordCount(); i++){
			char[] chars = encrypt(parser.getWord(i).toCharArray());
			
			for(char c : chars)
				ret.append(c);
				
			ret.append(" ");
		}
		
		return ret.toString();
	}
	
	private char[] encrypt(char[] chars){
		char[] ret = new char[chars.length];
		
		int count = 0;
		for(int i = chars.length-1; i >= 0; i--){
			ret[count] = chars[i];
			count++;
		}
		
		return ret;		
	}
	
	public String decrypt(String message){
		return encrypt(message);
	}
}
