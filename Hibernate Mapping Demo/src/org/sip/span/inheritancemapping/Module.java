package org.sip.span.inheritancemapping;

import javax.persistence.Entity;

@Entity
public class Module extends Project{
	
	private String modName;
	
	public String getModName() {
		return modName;
	}
	public void setModName(String modName) {
		this.modName = modName;
	}
	

}
