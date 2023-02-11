package service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    
    HashMap<String  ,Integer> hm=new HashMap<>();
	
	public HashMap<String,Integer> fetchName(String visit) {
	    hm.put(visit,hm.getOrDefault(visit, 0)+1);
	   return  hm;
	}
}
