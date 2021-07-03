package com.ariftravelagency.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "location_tbl")
public class LocationEntity implements Serializable {

	private static final long serialVersionUID = 7445912949883430567L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean isActive;

}
