package data7.importer.cwe.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Impact_Type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Impact_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="Modify memory"/>
 *     &lt;enumeration value="Read memory"/>
 *     &lt;enumeration value="Modify files or directories"/>
 *     &lt;enumeration value="Read files or directories"/>
 *     &lt;enumeration value="Modify application data"/>
 *     &lt;enumeration value="Read application data"/>
 *     &lt;enumeration value="DoS: crash / exit / restart"/>
 *     &lt;enumeration value="DoS: amplification"/>
 *     &lt;enumeration value="DoS: instability"/>
 *     &lt;enumeration value="DoS: resource consumption (CPU)"/>
 *     &lt;enumeration value="DoS: resource consumption (memory)"/>
 *     &lt;enumeration value="DoS: resource consumption (other)"/>
 *     &lt;enumeration value="Execute unauthorized code or commands"/>
 *     &lt;enumeration value="Gain privileges / assume identity"/>
 *     &lt;enumeration value="Bypass protection mechanism"/>
 *     &lt;enumeration value="Hide activities"/>
 *     &lt;enumeration value="Alter execution logic"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Varies by context"/>
 *     &lt;enumeration value="Quality degradation"/>
 *     &lt;enumeration value="Unexpected state"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Impact_Type")
@XmlEnum
public enum ImpactType {

    @XmlEnumValue("Modify memory")
    MODIFY_MEMORY("Modify memory"),
    @XmlEnumValue("Read memory")
    READ_MEMORY("Read memory"),
    @XmlEnumValue("Modify files or directories")
    MODIFY_FILES_OR_DIRECTORIES("Modify files or directories"),
    @XmlEnumValue("Read files or directories")
    READ_FILES_OR_DIRECTORIES("Read files or directories"),
    @XmlEnumValue("Modify application data")
    MODIFY_APPLICATION_DATA("Modify application data"),
    @XmlEnumValue("Read application data")
    READ_APPLICATION_DATA("Read application data"),
    @XmlEnumValue("DoS: crash / exit / restart")
    DO_S_CRASH_EXIT_RESTART("DoS: crash / exit / restart"),
    @XmlEnumValue("DoS: amplification")
    DO_S_AMPLIFICATION("DoS: amplification"),
    @XmlEnumValue("DoS: instability")
    DO_S_INSTABILITY("DoS: instability"),
    @XmlEnumValue("DoS: resource consumption (CPU)")
    DO_S_RESOURCE_CONSUMPTION_CPU("DoS: resource consumption (CPU)"),
    @XmlEnumValue("DoS: resource consumption (memory)")
    DO_S_RESOURCE_CONSUMPTION_MEMORY("DoS: resource consumption (memory)"),
    @XmlEnumValue("DoS: resource consumption (other)")
    DO_S_RESOURCE_CONSUMPTION_OTHER("DoS: resource consumption (other)"),
    @XmlEnumValue("Execute unauthorized code or commands")
    EXECUTE_UNAUTHORIZED_CODE_OR_COMMANDS("Execute unauthorized code or commands"),
    @XmlEnumValue("Gain privileges / assume identity")
    GAIN_PRIVILEGES_ASSUME_IDENTITY("Gain privileges / assume identity"),
    @XmlEnumValue("Bypass protection mechanism")
    BYPASS_PROTECTION_MECHANISM("Bypass protection mechanism"),
    @XmlEnumValue("Hide activities")
    HIDE_ACTIVITIES("Hide activities"),
    @XmlEnumValue("Alter execution logic")
    ALTER_EXECUTION_LOGIC("Alter execution logic"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Varies by context")
    VARIES_BY_CONTEXT("Varies by context"),
    @XmlEnumValue("Quality degradation")
    QUALITY_DEGRADATION("Quality degradation"),
    @XmlEnumValue("Unexpected state")
    UNEXPECTED_STATE("Unexpected state");
    private final String value;

    ImpactType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImpactType fromValue(String v) {
        for (ImpactType c: ImpactType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
