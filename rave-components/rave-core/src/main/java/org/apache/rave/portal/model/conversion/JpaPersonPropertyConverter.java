package org.apache.rave.portal.model.conversion;

import org.apache.rave.model.ModelConverter;
import org.apache.rave.portal.model.JpaPersonProperty;
import org.apache.rave.portal.model.PersonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Converts an Address to a JpaAddress
 */
@Component
public class JpaPersonPropertyConverter implements ModelConverter<PersonProperty, JpaPersonProperty> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Class<PersonProperty> getSourceType() {
        return PersonProperty.class;
    }

    @Override
    public JpaPersonProperty convert(PersonProperty source) {
        return source instanceof JpaPersonProperty ? (JpaPersonProperty) source : createEntity(source);
    }

    private JpaPersonProperty createEntity(PersonProperty source) {
        JpaPersonProperty converted = null;
        if (source != null) {
            converted = manager.find(JpaPersonProperty.class, source.getId());

            if (converted == null) {
                converted = new JpaPersonProperty();
            }
            updateProperties(source, converted);
        }
        return converted;
    }

    private void updateProperties(PersonProperty source, JpaPersonProperty converted) {
        converted.setQualifier(source.getQualifier());
        converted.setPrimary(source.getPrimary());
    }
}
