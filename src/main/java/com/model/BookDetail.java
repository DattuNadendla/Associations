package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookDetail extends BaseModel {
	@Column(name="num_of_pages")
	private int numOfPages;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="isbn")
	private String isbn;
}
