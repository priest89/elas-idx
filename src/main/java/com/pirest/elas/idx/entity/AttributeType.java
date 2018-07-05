package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * The persistence class for ATTR_TYPE table
 *
 */
@Entity
@Table(name="attr_type")
public class AttributeType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="attr_type_id")
	private long attributeTypeId;
	
	@Column(name="attr_type", length=64, nullable=false)
	private String attributeType;


	@OneToOne(cascade={CascadeType.MERGE}, optional=false)
	@JoinColumn(name="attr_namespace_id")
	private AttributeNamespace attributeNamespace;
	
	public long getAttributeTypeId() {
		return attributeTypeId;
	}

	public void setAttributeTypeId(long attributeTypeId) {
		this.attributeTypeId = attributeTypeId;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public AttributeNamespace getAttributeNamespace() {
		return attributeNamespace;
	}

	public void setAttributeNamespace(AttributeNamespace attributeNamespace) {
		this.attributeNamespace = attributeNamespace;
	}
	
}
