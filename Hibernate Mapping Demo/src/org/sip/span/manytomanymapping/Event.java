package org.sip.span.manytomanymapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private int eventTd;
	private String eventName;
	@ManyToMany
	@JoinTable(name = "JOIN_DELEGATE_EVENT", 
	joinColumns = { @JoinColumn(name = "eventId") }, 
	inverseJoinColumns = { @JoinColumn(name = "delegateId") })
	private List<Delegate> delegates = new ArrayList<Delegate>();

	public int getEventTd() {
		return eventTd;
	}

	public void setEventTd(int eventTd) {
		this.eventTd = eventTd;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<Delegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

}
