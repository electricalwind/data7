package data7.importer.cwe.model;

/*-
 * #%L
 * Data7
 * %%
 * Copyright (C) 2018 Matthieu Jimenez
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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour SDLC_Phase_Type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SDLC_Phase_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="Policy"/>
 *     &lt;enumeration value="Requirements"/>
 *     &lt;enumeration value="Architecture and Design"/>
 *     &lt;enumeration value="Implementation"/>
 *     &lt;enumeration value="Testing"/>
 *     &lt;enumeration value="Bundling"/>
 *     &lt;enumeration value="Distribution"/>
 *     &lt;enumeration value="Installation"/>
 *     &lt;enumeration value="Patch"/>
 *     &lt;enumeration value="Documentation"/>
 *     &lt;enumeration value="Porting"/>
 *     &lt;enumeration value="System Configuration"/>
 *     &lt;enumeration value="Operation"/>
 *     &lt;enumeration value="Build and Compilation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SDLC_Phase_Type")
@XmlEnum
public enum SDLCPhaseType {

    @XmlEnumValue("Policy")
    POLICY("Policy"),
    @XmlEnumValue("Requirements")
    REQUIREMENTS("Requirements"),
    @XmlEnumValue("Architecture and Design")
    ARCHITECTURE_AND_DESIGN("Architecture and Design"),
    @XmlEnumValue("Implementation")
    IMPLEMENTATION("Implementation"),
    @XmlEnumValue("Testing")
    TESTING("Testing"),
    @XmlEnumValue("Bundling")
    BUNDLING("Bundling"),
    @XmlEnumValue("Distribution")
    DISTRIBUTION("Distribution"),
    @XmlEnumValue("Installation")
    INSTALLATION("Installation"),
    @XmlEnumValue("Patch")
    PATCH("Patch"),
    @XmlEnumValue("Documentation")
    DOCUMENTATION("Documentation"),
    @XmlEnumValue("Porting")
    PORTING("Porting"),
    @XmlEnumValue("System Configuration")
    SYSTEM_CONFIGURATION("System Configuration"),
    @XmlEnumValue("Operation")
    OPERATION("Operation"),
    @XmlEnumValue("Build and Compilation")
    BUILD_AND_COMPILATION("Build and Compilation");
    private final String value;

    SDLCPhaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SDLCPhaseType fromValue(String v) {
        for (SDLCPhaseType c: SDLCPhaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
