package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class LabSeqService {

    public Map<Integer,Integer> labSeqResults= new HashMap<>(Map.of(
            0,0,
            1,1,
            2,0,
            3,1
    ));

    //@CacheResult(cacheName = "labseq-cache")
    public int labseqMethod(Integer n){
        if(n<=3){
            return labSeqResults.get(n);
        }
        if(labSeqResults.containsKey(n)){
            return labSeqResults.get(n);
        }
        else{
            int n_value = labseqMethod(n-4) + labseqMethod(n-3);
            labSeqResults.put(n,n_value);
            return n_value;
        }
    }

}
