package com.maxtrain.bootcamp.sales.order;

import java.time.LocalDate;

import com.maxtrain.bootcamp.sales.customer.Customer;

import jakarta.persistence.*;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition="date NOT NULL")
	private LocalDate Date;
	@Column(length=90, nullable=false)
	private String description;
	@Column(columnDefinition="decimal(11,2) NOT NULL DEFAULT 0")
	private double total;
	@Column(length=20, nullable=false)
	private String status = "NEW";
	
	@ManyToOne(optional=false)
	@JoinColumn(name="customerId", columnDefinition="int")
	private Customer customer;
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
