public class CountAlg implements IDiffAlg{
	private static CountAlg m_instance;
	
	public static CountAlg getInstance(){
		if(m_instance == null)
			m_instance = new CountAlg();
		return m_instance;
	}
	
	private CountAlg(){}
	
	@Override
	public int difference(String seq1, String seq2){
		char[] sequence1 = seq1.toCharArray();
		char[] sequence2 = seq2.toCharArray();
				
		int totalA = countTotal(sequence1, sequence2, 'A');
		int totalG = countTotal(sequence1, sequence2, 'G');
		int totalC = countTotal(sequence1, sequence2, 'C');
		int totalT = countTotal(sequence1, sequence2, 'T');
		
		return totalA+totalG+totalC+totalT;
	}
	
	private int countTotal(char[] sequence1, char[] sequence2, char c){
		int seq1 = 0;
		int seq2 = 0;
		
		for(int i = 0; i < sequence1.length; i++){
			if(sequence1[i] == c)
				seq1++;
			if(sequence2[i] == c)
				seq2++;
		}
		
		return Math.abs(seq1-seq2);
	}
}
