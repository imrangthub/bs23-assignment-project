package com.ariftravelagency.status;

import java.io.Serializable;

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
@Table(name = "status_tbl")
public class StatusEntity implements Serializable {

	private static final long serialVersionUID = 51679557935040554L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String statusBody;

	private Integer privacyType;

	private Long locationId;

	private Long userId;

}
