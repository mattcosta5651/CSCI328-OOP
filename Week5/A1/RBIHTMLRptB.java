import java.util.*;
import java.io.*;

public class RBIHTMLRptB extends RBITextRpt{
	public RBIHTMLRptB(String dataFile, String reportFile){
		super(dataFile, reportFile);
	}
	
	public void generateReport(List<DataPair> data) throws Exception{
		FileWriter writer = new FileWriter(m_reportFile);
		writer.write("<html>\n");
		writer.write("<body>\n");
		writer.write("<table>\n");
		for(DataPair pair : data){
			writer.write("<tr><td>"+pair.getName()+"\t"+pair.getStat()+"</td></tr>\n");
		}
		writer.write("</table>\n");	
		writer.write("</body>\n");
		writer.write("</html>\n");
			
		writer.close();			
	}
}
