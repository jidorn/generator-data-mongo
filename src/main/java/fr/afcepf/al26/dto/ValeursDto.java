package fr.afcepf.al26.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alexandrequere on 5/04/2016.
 */
@XmlRootElement
public class ValeursDto {
    private String key;
    private String value;

    public ValeursDto() {
    }

    public ValeursDto(String paramKey, String paramValue) {
        key = paramKey;
        value = paramValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String paramKey) {
        key = paramKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String paramValue) {
        value = paramValue;
    }

    @Override
    public String toString() {
        return "ValeursDto{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
