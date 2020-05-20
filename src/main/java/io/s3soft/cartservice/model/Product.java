package io.s3soft.cartservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
public class Product {
    @Id
	private String id;
	private String productName;
	private String description;
	private Double mrp;
	private Double price;
	private Integer avialableQuantity;
	private String category;
	private Date manufactureDate;
	private Long soldUnits;
	private Date createdDate;
	private Date lastUpdatedDate;
	public Product(String productName, String description, Double mrp, Double price, Integer avialableQuantity,
			String category, Date manufactureDate, Long soldUnits) {
		super();
		this.productName = productName;
		this.description = description;
		this.mrp = mrp;
		this.price = price;
		this.avialableQuantity = avialableQuantity;
		this.category = category;
		this.manufactureDate = manufactureDate;
		this.soldUnits = soldUnits;
	}
	public Product() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvialableQuantity() {
		return avialableQuantity;
	}
	public void setAvialableQuantity(Integer avialableQuantity) {
		this.avialableQuantity = avialableQuantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Long getSoldUnits() {
		return soldUnits;
	}
	public void setSoldUnits(Long soldUnits) {
		this.soldUnits = soldUnits;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", mrp=" + mrp
				+ ", price=" + price + ", avialableQuantity=" + avialableQuantity + ", category=" + category
				+ ", manufactureDate=" + manufactureDate + ", soldUnits=" + soldUnits + "]";
	}
	
	
}
