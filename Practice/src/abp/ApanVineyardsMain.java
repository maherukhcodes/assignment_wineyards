package abp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ApanVineyardsMain {

	public static void main(String[] args) throws Exception {
		
		ApanVineyards apan = new ApanVineyards();
		apan.readFile();
		
		Set<String> s = new HashSet<String>();
		
		System.out.println("--Please enter the id's of 3 customers at the Apan Vineyard--");
		
		Scanner sc = new Scanner(System.in);
		String id;
		
		while (s.size() < 3) {
			id  = sc.next();
			s.add(id);
		}
		sc.close();
		
		Map<String, String> hashMap = new HashMap<String,String>();
		hashMap = apan.writeFile(s);
		Set<Map.Entry<String, String>> persons = hashMap.entrySet();
		
		System.out.println("No. of Wine Bottles sold: " +hashMap.size());
		System.out.println();
		for (Map.Entry<String, String> m: persons) {
			System.out.println(m.getValue()+"   "+m.getKey());
		}
		
	}

}
