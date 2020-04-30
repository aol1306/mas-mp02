package com.company;

import java.util.HashMap;
import java.util.Map;

// cemetery *-1 region kwalifikowana
public class Region {
    private Map<String, Cemetery> cemeteries = new HashMap<>();

    public void addCemetery(Cemetery cemetery) {
        if(!cemeteries.containsValue(cemetery)) {
            cemeteries.put(cemetery.name, cemetery);
            cemetery.setRegion(this);
        }
    }

    public void removeCemetery(Cemetery cemetery) {
        if(cemeteries.containsValue(cemetery)) {
            cemeteries.remove(cemetery.name);
            cemetery.setRegion(null);
        }
    }

    public Cemetery getCemetery(String name) throws Exception{
        if(!cemeteries.containsKey(name)) {
            throw new Exception("Unable to find cemetery: " + name);
        }
        return cemeteries.get(name);
    }
}