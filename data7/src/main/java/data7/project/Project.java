package data7.project;

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
import java.util.Map;

/**
 * Project class
 * This class contains all information required to generate a data7
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 20181004L;


    private final String name;
    private final Map<String,MetaInformation> subProjects;


    public Project(String name, Map<String, MetaInformation> subProjects) {
        this.name = name;
        this.subProjects = subProjects;
    }

    public String getName() {
        return name;
    }

    public Map<String, MetaInformation> getSubProjects() {
        return subProjects;
    }
}
