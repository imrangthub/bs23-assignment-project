package com.ariftravelagency.statusView;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Immutable
@Table(name = "STATUS_VIEW")
public class StatusViewEntity implements Serializable {

	private static final long serialVersionUID = 516795575040554L;

	@Id
	private Long id;

	private String statusBody;

	private Integer privacyType;

	private Long locationId;
	
	private String title;

	private Long userId;
	
	private String fullName;

}
