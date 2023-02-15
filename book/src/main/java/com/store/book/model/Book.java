package com.store.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="book_record")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@JsonProperty
	private String id;
	@JsonProperty
	private String title;
	@JsonProperty
	private String author;
	@JsonProperty
	private double price;
}
