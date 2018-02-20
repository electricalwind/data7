package data7.importer.cwe.model;

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
