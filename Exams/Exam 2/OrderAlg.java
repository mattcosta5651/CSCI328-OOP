public class OrderAlg extends AbstractOrderAlg{
	//Singleton
	private static OrderAlg m_instance;
	
	public static OrderAlg getInstance(){
		if(m_instance == null)
			m_instance = new OrderAlg();
		return m_instance;
	}
	
	private OrderAlg(){}	
	
	@Override
	protected int getPenalty(char ch1){
		return 1;
	}
}
