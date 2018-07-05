package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.CollectionUtils;

@Entity
@Table(name = "network_type")
public class NetworkType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "network_type_id")
	private Long networkTypeId;
	
	@Column(name = "type_name")
	private String typeName;

	//bi-directional many-to-one association to VideoMedia
	@OneToMany(mappedBy = "networkType", cascade = {CascadeType.REFRESH})
	private List<Network> networks;
	
	public void addNetwork(Network network) {
		if(network != null && !CollectionUtils.isEmpty(this.getNetworks())) {
			if(!this.getNetworks().contains(network)) {
				this.getNetworks().add(network);
				network.setNetworkType(this);
			}
		}
	}
	
	public void removeNetwork(Network network) {
		if(network != null && !CollectionUtils.isEmpty(this.getNetworks())) {
			if(!this.getNetworks().contains(network)) {
				this.getNetworks().remove(network);
				network.setNetworkType(null);
			}
		}
	}
	
	public boolean hasNetwork(Network network) {
		if(network != null && !CollectionUtils.isEmpty(this.getNetworks())) {
			if(this.getNetworks().contains(network))
				return true;
		}
		return false;
	}
	
	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	public Long getNetworkTypeId() {
		return networkTypeId;
	}

	public void setNetworkTypeId(Long networkTypeId) {
		this.networkTypeId = networkTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
