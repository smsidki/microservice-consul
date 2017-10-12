package com.greenfoarfece.ms.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_book")
public class Book {
	
	@Id
	@GeneratedValue(generator = "book_seq_gen")
	@GenericGenerator(
		name = "book_seq_gen",
		strategy = "sequence",
		parameters = {@Parameter(name = "sequence", value = "book_id_seq")}
	)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(unique = true, nullable = false)
	private String isbn;

}
