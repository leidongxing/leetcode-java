package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> reMap = new HashMap<String, Integer>();
        for (String cpd : cpdomains) {
            String[] ecpd = cpd.split(" ");
            int times = Integer.parseInt(ecpd[0]);
            String all = ecpd[1];
            String[] alld = all.split("\\.");
            int j = alld.length;
            String elld = "";
            for (int i = 0; i < j; i++) {
                int k = i;
                while (k < j) {
                    elld = elld + '.' + alld[k];
                    k++;
                }
                elld = elld.substring(1, elld.length());
                if (!reMap.containsKey(elld)) {
                    reMap.put(elld, times);
                } else {
                    reMap.put(elld, times + reMap.get(elld));
                }
                elld = "";
            }
        }
        for (Entry<String, Integer> entry : reMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        SubdomainVisitCount s = new SubdomainVisitCount();
        s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }
}
