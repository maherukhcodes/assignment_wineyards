package abp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ApanVineyards {
	
	Map<String,String> map = new HashMap<String,String>();
		
	public void readFile() throws Exception {
			
		String dir = "C:\\Users\\my\\Desktop\\wine\\";
		BufferedReader TSVFile = 
		    new BufferedReader(new FileReader(dir+"person_vine_1.tsv"));

		String dataRow = TSVFile.readLine(); // Read first line.

		while (dataRow != null){
		String[] dataArray = dataRow.split("\t");		
		map.put(dataArray[1],dataArray[0]);
		dataRow = TSVFile.readLine(); // Read next line of data.
		}
		// Close the file once all data has been read.
		TSVFile.close();			
	
	}
		
	public HashMap<String, String> writeFile(Set<String> set) throws Exception {
		
		Set<Map.Entry<String, String>> persons = map.entrySet();
		HashMap<String, String> hash = new LinkedHashMap<String, String>(); 
		int count = 0;
		String terminate = "";
		int margin = 0;
		for (String s: set) {
			margin += 3;
			for (Map.Entry<String, String> m: persons) {
				 
			           if (m.getValue().equals(s) && !terminate.equalsIgnoreCase("STOP")) {
			        	   hash.put(m.getKey(), s);	
			        	   if (hash.size() <= margin)
			        		   count++;
			           }
			           if (count%3 == 0 && hash.size()>0 && hash.size() %3 == 0 && hash.size() == margin) {		        	   
			        	   		 terminate = "STOP";       	   
			           }
			}
			count = 0;	
			terminate = "";
		}
		
		return hash;
		}
				
		
}
