import java.util.*;
import java.io.*;

public class HomeRunTextRpt{
	protected String m_dataFile;
	protected String m_reportFile;
	
	public HomeRunTextRpt(String dataFile, String reportFile){
		m_dataFile = dataFile;
		m_reportFile = reportFile;
	}
	
	public List<DataPair> loadData() throws Exception{
		List<DataPair> data = new ArrayList<DataPair>();
		BufferedReader reader = new BufferedReader(new FileReader(m_dataFile));
		while(reader.ready()){
			String[] line = reader.readLine().split(",", -1);
			if(line[1].equals(""))
				line[1] = "0";
			data.add(new DataPair(line[0], Integer.parseInt(line[1])));
		}
		return data;
	}
	
	public void generateReport(List<DataPair> data) throws Exception{
		FileWriter writer = new FileWriter(m_reportFile);
		for(DataPair pair : data){
			writer.write(pair.getName()+"\t"+pair.getStat()+"\n");
		}
		writer.close();
	}
}
