import java.util.*;
import java.io.*;

public class RBIHTMLRptA extends HomeRunHTMLRpt{
	public RBIHTMLRptA(String dataFile, String reportFile){
		super(dataFile, reportFile);
	}
	
	@Override
	public List<DataPair> loadData() throws Exception{
		List<DataPair> data = new ArrayList<DataPair>();
		BufferedReader reader = new BufferedReader(new FileReader(m_dataFile));
		while(reader.ready()){
			String[] line = reader.readLine().split(",", -1);
			if(line[2].equals(""))
				line[2] = "0";			
			data.add(new DataPair(line[0], Integer.parseInt(line[2])));
		}
		return data;			
	}
}
