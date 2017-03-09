import java.util.*;
import java.io.*;

public class DiffCalculator{
	private List<IDiffAlg> m_diffAlgs;
	
	public static void main(String[] args) throws IOException{
		new DiffCalculator().go();
	}
	
	private void go() throws IOException{
		m_diffAlgs = new ArrayList<IDiffAlg>();
		m_diffAlgs.add(CountAlg.getInstance());
		m_diffAlgs.add(OrderAlg.getInstance());
		m_diffAlgs.add(WeightedOrderAlg.getInstance());
		
		List<String[]> sequences = readSequences();
		List<Double> averages = calcAverages(m_diffAlgs, sequences);
		
		for(int i = 0; i < averages.size(); i++){
			System.out.printf("Average for %s-%s = %.2f%n",	
				sequences.get(i)[0], sequences.get(i)[1],
				averages.get(i));
		}
	}
	
	private List<Double> calcAverages(List<IDiffAlg> algs, List<String[]> seq){
		List<Double> ave = new ArrayList<Double>();
		
		double total;
		for(int i = 0; i < seq.size(); i++){
			total = 0;
			for(int j = 0; j < algs.size(); j++)
				total += algs.get(j).difference(seq.get(i)[0], seq.get(i)[1]);
			ave.add(total/algs.size());
		}
		return ave;
	}
	
	private List<String[]> readSequences() throws IOException{
		List<String[]> seq = new ArrayList<String[]>();
		BufferedReader reader = new BufferedReader(new FileReader("Sequences.txt"));
		
		while(reader.ready())
			seq.add(reader.readLine().split(","));
			
		return seq;
	}
}
