package cweimporter;

import java.util.List;

public class CWE {

    private final int id;
    private final String name;
    private final String description;
    private final List<Integer> childOf;

    public CWE(int id, String name, String description, List<Integer> childOf){

        this.id = id;
        this.name = name;
        this.description = description;
        this.childOf = childOf;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getChildOf() {
        return childOf;
    }

}
