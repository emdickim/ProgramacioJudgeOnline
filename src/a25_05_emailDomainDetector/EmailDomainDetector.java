package a25_05_emailDomainDetector;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailDomainDetector {


    /** 
    * Receives a list of email addresses with duplicates, 
    * removes duplicated emails using a Set, 
    * and returns a TreeMap with the number of unique emails per domain. 
    */ 
    public Map<String, Integer> countDomains(List<String> emails) {
        Set<String> emailsNoRepeat = new HashSet<>();
    
        Map<String, Integer> dominis = new TreeMap<>();
        for (String email : emails) {
            if (email != null) {
                emailsNoRepeat.add(email.trim().toLowerCase());
            }
        }


        for (String email : emailsNoRepeat) {

            String[] emailsParts = email.split("@");
            
            if (emailsParts.length != 2) continue;
            
            String domain = emailsParts[1];

            // Definim un patró RegEx que accepta només dominis que terminen en .com
            String pattern = "^[a-z0-9]+\\.com$";
            Matcher matcher = Pattern.compile(pattern).matcher(domain);

            if (matcher.find()) {
                System.out.println(email);
                if (dominis.containsKey(domain)) {  
                    dominis.put(domain, dominis.get(domain) + 1);
                } else {
                    dominis.put(domain, 1);
                }                
            }
        }

        return dominis;
    }
    
}
