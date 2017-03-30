public class VowelMash implements ICrypto{
	private static VowelMash m_instance;
	
	public static VowelMash getInstance(){
		if(m_instance == null)
			return new VowelMash();
		else
			return m_instance;
	}
	
	private VowelMash(){
		
	}
	
	public String encrypt(String message){
		IMessageParser parser = Factory.getInstance().createParser(message);
		StringBuffer ret = new StringBuffer();

		for(int i = 0; i < parser.getCharCount(); i++)
			ret.append(encrypt(parser.getChar(i)));
			
		return ret.toString();
	}
	private char encrypt(char c){
		//A->E, E->I, I->O, O->U, U->A		
		switch(c){
			case 'A':
				return 'E';
			case 'E':
				return 'I';
			case 'I':
				return 'O';
			case 'O':
				return 'U';
			case 'U':
				return 'A';
			default:
				return c;
		}
	}
	
	public String decrypt(String message){
		for(int i = 0; i < 4; i++)
			message = encrypt(message);
		
		return message;
	}	
}
