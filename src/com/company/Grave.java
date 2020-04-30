package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Grave-GraveDecoration kompozycja
// Grave-Cemetery "zwykła"
// Grave-Deadman z atrybutem
public class Grave {
    private Cemetery cemetery;
    private Funeral funeral;
    private List<GraveDecoration> decorations = new ArrayList<>();
    private static Set<GraveDecoration> allDecorations = new HashSet<>();

    public Grave() {}

    public void setCemetery(Cemetery cemetery) {
        if(this.cemetery == cemetery) return;
        if(this.cemetery != null) {
            this.cemetery.removeGrave(this);
        }
        this.cemetery = cemetery;
        if(cemetery != null) {
            cemetery.addGrave(this);
        }
    }

    public void setFuneral(Funeral funeral) {
        if(this.funeral == funeral) return;
        if(this.funeral != null) {
            this.funeral.removeGrave(this);
        }
        this.funeral = funeral;
        if(funeral != null) {
            funeral.addGrave(this);
        }
    }

    public void addDecoration(GraveDecoration graveDecoration) throws Exception {
        if(!decorations.contains(graveDecoration)) {
            if(allDecorations.contains(graveDecoration)) {
                throw new Exception("This decoration is already used with another grave!");
            }
            decorations.add(graveDecoration);
            allDecorations.add(graveDecoration);
        }
    }

    @Override
    public String toString() {
        return "Grave on cemetery " + cemetery.name;
    }
}