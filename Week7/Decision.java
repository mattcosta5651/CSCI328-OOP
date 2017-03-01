import java.util.Scanner;

public class Decision implements IDecision{
	private String m_question;
	private IDecision m_yes;
	private IDecision m_no;
	private String m_yesTerminal;
	private String m_noTerminal;
	
	//default constructor takes a question to ask
	public Decision(String question){
		m_question = question;
	}
	
	//sets the yes decision
	public void setYes(IDecision yes){m_yes = yes;}
	//sets the no decision
	public void setNo(IDecision no){m_no = no;}
	//sets the yes terminal
	public void setYesTerminal(String terminal){m_yesTerminal = terminal;}
	//sets the no terminal
	public void setNoTerminal(String terminal){m_noTerminal = terminal;}
	
	//asks user question, returns appropriate response
	public IDecision ask(){
		Scanner scanner = new Scanner(System.in);
		System.out.print(m_question+" ");
		String input = scanner.nextLine();
		
		//answered yes to question
		if(input.equalsIgnoreCase("yes")){
			//there is another question
			if(m_yes != null)
				return m_yes;
			//no more questions
			else
				System.out.println(m_yesTerminal);
		}
		
		//answered no to question
		if(input.equalsIgnoreCase("no")){
			//there is another question
			if(m_no != null)
				return m_no;
			//no more questions
			else
				System.out.println(m_noTerminal);
		}
		
		return null;		
	}
}
