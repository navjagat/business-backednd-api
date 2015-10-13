/**
 * 
 */
package com.interview.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * This class is a replica of business table in database
 * 
 * @author navneet.prabhakar
 * @since 12 October 2015
 * @version 1.0
 */

@Entity
@Table
public class Business implements Serializable {

	private static final long serialVersionUID = 83332401194611100L;
	
	@Id
	@GeneratedValue(generator="business_pk", strategy= GenerationType.TABLE)
	@TableGenerator(name="business_pk", table="busspktb", pkColumnName="pk_key", pkColumnValue="pk_value", allocationSize=1)
	private Long id;
	
	private String bussinessName;
	
	@OneToMany(targetEntity=Address.class, mappedBy="business")
	private List<Address> addresses;
	
	@Enumerated(EnumType.STRING)
	private Type businessType;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the bussinessName
	 */
	public String getBussinessName() {
		return bussinessName;
	}

	/**
	 * @param bussinessName the bussinessName to set
	 */
	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the businessType
	 */
	public Type getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(Type businessType) {
		this.businessType = businessType;
	}
}
