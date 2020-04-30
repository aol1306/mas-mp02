package com.company;

// kompozycja - GraveDecoration is a part of Grave
public class GraveDecoration {
    String name;
    private Grave grave;

    private GraveDecoration(Grave grave, String name) {
        this.name = name;
        this.grave = grave;
    }

    public static GraveDecoration createDecoration(Grave grave, String name) throws Exception {
        if (grave == null) {
            throw new Exception("Grave does not exist");
        }
        var graveDecoration = new GraveDecoration(grave, name);
        grave.addDecoration(graveDecoration);
        return graveDecoration;
    }
}