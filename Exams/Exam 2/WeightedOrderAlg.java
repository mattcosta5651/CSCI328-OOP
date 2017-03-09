public class WeightedOrderAlg extends AbstractOrderAlg{
	//Singleton
	private static WeightedOrderAlg m_instance;
	
	public static WeightedOrderAlg getInstance(){
		if(m_instance == null)
			m_instance = new WeightedOrderAlg();
		return m_instance;
	}
	
	private WeightedOrderAlg(){}	
	
	@Override
	protected int getPenalty(char ch1){
		switch(ch1){
			case 'A':
				return 1;
			case 'C':
				return 2;
			case 'G':
				return 3;
			case 'T':
				return 4;
		}
		
		return 0; //never reached
	}
}
