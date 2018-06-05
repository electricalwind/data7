package data7.model;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 University of Luxembourg, Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



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
