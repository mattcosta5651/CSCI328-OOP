public class Factory{
	private static Factory m_instance;
	
	public static Factory getInstance(){
		if(m_instance == null)
			return new Factory();
		else
			return m_instance;
	}
	
	private Factory(){}
	
	public IMessageParser createParser(String text){
		return new MessageParser(text);
	}
}
