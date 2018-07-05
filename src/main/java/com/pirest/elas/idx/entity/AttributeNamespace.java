package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * The persistence class for ATTR_NAMESPACE table
 *
 */
@Entity
@Table(name="attr_namespace")
public class AttributeNamespace implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="attr_namespace_id")
	private long attributeNamespaceId;
	
	@Column(name="namespace", length=32, nullable=false, unique=true)
	private String namespace;

	public long getAttributeNamespaceId() {
		return attributeNamespaceId;
	}

	public void setAttributeNamespaceId(long attributeNamespaceId) {
		this.attributeNamespaceId = attributeNamespaceId;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
}
