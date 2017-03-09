public abstract class AbstractOrderAlg implements IDiffAlg{
	public AbstractOrderAlg(){
		
	}
	
	@Override
	public int difference(String seq1, String seq2){
		int diff = 0;
		
		char[] sequence1 = seq1.toCharArray();
		char[] sequence2 = seq2.toCharArray();
		
		for(int i = 0; i < sequence1.length; i++){
			if(sequence1[i] != sequence2[i])
				diff += getPenalty(sequence1[i]);
		}
		
		return diff;
	}
	
	protected abstract int getPenalty(char ch1);
}
