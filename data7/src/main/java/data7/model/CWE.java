package data7.model;

import java.io.Serializable;
import java.util.List;

/**
 * he CWE class (Commom Weakness Enumeration)
 */
public class CWE implements Serializable {

    private static final long serialVersionUID = 20180531L;

    private final int id;
    private final String name;
    private final String description;
    private final List<Integer> childOf;

    /**
     * Constructor of the cwe class
     *
     * @param id          cwe id
     * @param name        cwe name
     * @param description of the cwe
     * @param childOf     this cwe (identifier)
     */
    public CWE(int id, String name, String description, List<Integer> childOf) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.childOf = childOf;
    }

    /**
     * @return the id of the cwe
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name of the cwe
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of cwe
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the list of the child of the cwe
     */
    public List<Integer> getChildOf() {
        return childOf;
    }

}
