package regexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexpression {
	public static void main (String[] args) {
		
		//Pattern p = Pattern.compile("(?<=(PROCESS_ID[^\\S]))(.*?)(?=;)");
		Pattern p = Pattern.compile("(?<=PROCESS_ID[^\\S])(.*?)(?=;)");
		Matcher m = p.matcher("CREATED_WHEN 11.09.2013; CREATED_BY 121212121; CORELLATION_ID ; SENDER TOMS; RECEIVER IL; PROCESS_ID 9876; OBJECT_ID ; MESSAGE node.toString(); FILE_PATH ; MESSAGE_TYPE Request; OPERATION_NAME ; RELATED_ERROR_ID ;");
		boolean b = m.matches();
		while (m.find()) {
	    	for (int i = 1; i <= m.groupCount(); i++) {
	    		System.out.println(m.group(i));
	    		System.out.println(m.start(i));
	    		System.out.println(m.end(i));
	    	}
	    }
	}	
}
