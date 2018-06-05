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
 * <p>Classe Java pour Frequency_Type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Frequency_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Often"/>
 *     &lt;enumeration value="Sometimes"/>
 *     &lt;enumeration value="Rarely"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Frequency_Type")
@XmlEnum
public enum FrequencyType {

    @XmlEnumValue("Often")
    OFTEN("Often"),
    @XmlEnumValue("Sometimes")
    SOMETIMES("Sometimes"),
    @XmlEnumValue("Rarely")
    RARELY("Rarely");
    private final String value;

    FrequencyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FrequencyType fromValue(String v) {
        for (FrequencyType c: FrequencyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
