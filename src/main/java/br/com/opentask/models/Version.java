package br.com.opentask.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Version {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private SituationType situation;
	private Calendar createdDate;
	private Calendar previsionDate;

	public Version(){}
	
	public Version(Long id, String description, SituationType situation, Calendar createdDate, Calendar previsionDate) {
		this.id = id;
		this.description = description;
		this.situation = situation;
		this.createdDate = createdDate;
		this.previsionDate = previsionDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public void setSituation(SituationType situation) {
		this.situation = situation;
	}
	
	public SituationType getSituation() {
		return situation;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getPrevisionDate() {
		return previsionDate;
	}

	public void setPrevisionDate(Calendar previsionDate) {
		this.previsionDate = previsionDate;
	}

	@Override
	public String toString() {
		return "Version [id=" + id + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Version other = (Version) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
