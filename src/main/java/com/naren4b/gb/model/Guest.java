package com.naren4b.gb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "guest_book")
@ToString(callSuper=true, includeFieldNames=true)
public class Guest {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String phoneno;
	@NonNull
	private String email;

	private String note;
	
	@NonNull
	private Date created;
	
	
	

}
