package com.store.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="book_record")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonSerialize
@Getter
@Setter


public class Book {

	public Book(String string, String string2, String string3, double d) {
		// TODO Auto-generated constructor stub
	}
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
