package com.company;

import java.util.ArrayList;
import java.util.List;

// cemetery 1-* grave - zwykła
// cemetery-region kwalifikowana
public class Cemetery {
    public String name;
    private List<Grave> graves = new ArrayList<>();
    private Region region;

    public Cemetery(String name) {
        this.name = name;
    }

    public void addGrave(Grave grave) {
        if(!graves.contains(grave)) {
            graves.add(grave);
            grave.setCemetery(this);
        }
    }

    public void removeGrave(Grave grave) {
        if(graves.contains(grave)) {
            graves.remove(grave);
            grave.setCemetery(null);
        }
    }

    public void setRegion(Region region) {
        if(this.region == region) return;
        if(this.region != null) {
            this.region.removeCemetery(this);
        }
        this.region = region;
        if(region != null) {
            region.addCemetery(this);
        }
    }

    @Override
    public String toString() {
        var ret = "Cemetery: " + this.name + "\n";
        for (var grave : graves) {
            ret += "\t" + grave.toString() + "\n";
        }
        return ret;
    }
}