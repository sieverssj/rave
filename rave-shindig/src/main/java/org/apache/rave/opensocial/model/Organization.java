/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.rave.opensocial.model;

import org.apache.rave.persistence.BasicEntity;
import org.apache.shindig.social.opensocial.model.Address;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 */
@Entity
@Table(name = "organization")
public class Organization implements org.apache.shindig.social.opensocial.model.Organization, BasicEntity {

    /**
     * The internal object ID used for references to this object. Should be generated by the
     * underlying storage mechanism
     */
    @Id
    @Column(name = "entity_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "organizationIdGenerator")
    @TableGenerator(name = "organizationIdGenerator", table = "RAVE_SHINDIG_SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT", pkColumnValue = "organization", allocationSize = 1, initialValue = 1)
    private Long entityId;

    @OneToOne
    private Address address;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "description", length = 255)
    private String description;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "field", length = 255)
    private String field;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "name", length = 255)
    private String name;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "salary", length = 255)
    private String salary;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "sub_field", length = 255)
    private String subField;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "title", length = 255)
    private String title;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "webpage", length = 255)
    private String webpage;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "type", length = 255)
    private String type;

    /**
     * Part of the Organization Model
     *
     * @see org.apache.shindig.social.opensocial.model.Organization
     */
    @Basic
    @Column(name = "primary_organization")
    private Boolean primary;

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getAddress()
     */
    public Address getAddress() {
        return address;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setAddress(org.apache.shindig.social.opensocial.model.Address)
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getDescription()
     */
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setDescription(String)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getEndDate()
     */
    public Date getEndDate() {
        if (endDate == null) {
            return null;
        }
        return new Date(endDate.getTime());
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setEndDate(java.util.Date)
     */
    public void setEndDate(Date endDate) {
        if (endDate == null) {
            this.endDate = null;
        } else {
            this.endDate = new Date(endDate.getTime());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getField()
     */
    public String getField() {
        return field;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setField(String)
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setName(String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getSalary()
     */
    public String getSalary() {
        return salary;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setSalary(String)
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getStartDate()
     */
    public Date getStartDate() {
        if (startDate == null) {
            return null;
        }
        return new Date(startDate.getTime());
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setStartDate(java.util.Date)
     */
    public void setStartDate(Date startDate) {
        if (startDate == null) {
            this.startDate = null;
        } else {
            this.startDate = new Date(startDate.getTime());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getSubField()
     */
    public String getSubField() {
        return subField;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setSubField(String)
     */
    public void setSubField(String subField) {
        this.subField = subField;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getTitle()
     */
    public String getTitle() {
        return title;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setTitle(String)
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getWebpage()
     */
    public String getWebpage() {
        return webpage;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setWebpage(String)
     */
    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getType()
     */
    public String getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setType(String)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#getPrimary()
     */
    public Boolean getPrimary() {
        return primary;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.apache.shindig.social.opensocial.model.Organization#setPrimary(Boolean)
     */
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    /**
     */
    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

}
