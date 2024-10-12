package com.example.springbootexample.entity;

import lombok.Getter;

@Getter
public class UpdatedProductCommand {

	
	private int id;
	private Product product;
	public UpdatedProductCommand(int id, Product product) {
		super();
		this.id = id;
		this.product = product;
	}
	
	
	
}
