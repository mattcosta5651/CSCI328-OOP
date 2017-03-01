public class Builder{
	//singleton implementation
	private static Builder m_instance;
	public static Builder getInstance(){
		if(m_instance == null)
			m_instance = new Builder();
		return m_instance;
	}
	
	//builds the questions and relationships, returns the inital question
	public IDecision buildWizard(){
		//heap of decisions
		IDecision[] decisions = new Decision[]{
			new Decision("Do you want to buy a snowboard?"),    //0
			new Decision("Do you want to buy downhill skis?"),	//1						
			new Decision("Have you ever snowboarded before?"),  //2
			new Decision(""), 									//3: no terminal for buying downhill skis
			new Decision("Have you gone Skiing before?"),		//4
			new Decision(""), 									//5: no terminal for snowboarding before
			new Decision("Are you an expert?"),					//6: snowboarding
			new Decision(""),									//7: no terminal for skiing before
			new Decision("Are you an expert?"),					//8: skiing
			new Decision(""),									//9: no terminal for expert snowboarding, going fast
			//index 9 as no
			new Decision("Do you like to go fast?"),			//10
			new Decision(""),									//11: no terminal for expert skiing, jumping
			//index 11 as no
			new Decision("Do you like to jump?"),				//12
			new Decision(""),									//13: yes terminal for going fast
			new Decision("") 									//14: yes terminal for jumping
		};
		
		//hard sets yes/no decisions and terminals
		decisions[0].setNo(decisions[1]);
		decisions[0].setYes(decisions[2]);
		decisions[1].setNoTerminal("You should try skiing someday.");
		decisions[1].setYes(decisions[4]);
		decisions[2].setNoTerminal("Buy the XG100 Model.");
		decisions[2].setYes(decisions[6]);
		decisions[4].setNoTerminal("Buy the ZR100 Model.");
		decisions[4].setYes(decisions[8]);
		decisions[6].setNoTerminal("Buy the XG200 Model.");
		decisions[6].setYes(decisions[10]);
		decisions[8].setNoTerminal("Buy the ZR200 Model.");
		decisions[8].setYes(decisions[12]);
		decisions[12].setNoTerminal("Buy the ZR200 Model.");
		decisions[12].setYesTerminal("Buy the ZR300 Model.");
		decisions[10].setNoTerminal("Buy the XG200 Model.");
		decisions[10].setYesTerminal("Buy the XG300 Model.");
		
		return decisions[0];
	}
}
