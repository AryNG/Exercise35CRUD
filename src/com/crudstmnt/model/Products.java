package com.crudstmnt.model;

public class Products {
	private int idProduct;
	private String nameProduct;
	private double priceProduct;
	
	//Constructors
	public Products() {}
	public Products(int idProduct, String nameProduct, double priceProduct) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
	}
	
	//Getters and Setters
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}
	
}
