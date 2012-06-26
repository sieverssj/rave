package org.apache.rave.portal.model.impl;

import org.apache.rave.portal.model.PersonProperty;

/** **/
public class PersonPropertyImpl implements PersonProperty {

    private Long id;
    private String type;
    private String value;
    private String qualifier;
    private String extendedValue;
    private Boolean primary;

    public PersonPropertyImpl() {}

    public PersonPropertyImpl(Long id, String type, String value, String extendedValue, String qualifier, Boolean primary) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.qualifier = qualifier;
        this.primary = primary;
        this.extendedValue = extendedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getExtendedValue() {
        return extendedValue;
    }

    public void setExtendedValue(String extendedValue) {
        this.extendedValue = extendedValue;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonPropertyImpl)) return false;

        PersonPropertyImpl that = (PersonPropertyImpl) o;

        if (extendedValue != null ? !extendedValue.equals(that.extendedValue) : that.extendedValue != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (primary != null ? !primary.equals(that.primary) : that.primary != null) return false;
        if (qualifier != null ? !qualifier.equals(that.qualifier) : that.qualifier != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (qualifier != null ? qualifier.hashCode() : 0);
        result = 31 * result + (extendedValue != null ? extendedValue.hashCode() : 0);
        result = 31 * result + (primary != null ? primary.hashCode() : 0);
        return result;
    }
}
