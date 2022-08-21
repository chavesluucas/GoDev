package tech.testgodev.application.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer number;
	private Date date;
	private Double percentualDiscount;
	private Double totalValue;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() { }

	public Order(Integer id, Integer number, Date date, Double percentualDiscount, Double totalValue) {
		super();
		this.id = id;
		this.number = number;
		this.date = date;
		this.percentualDiscount = percentualDiscount;
		this.totalValue = totalValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(Double percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, number, orderItem, percentualDiscount, totalValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(number, other.number)
				&& Objects.equals(orderItem, other.orderItem)
				&& Objects.equals(percentualDiscount, other.percentualDiscount)
				&& Objects.equals(totalValue, other.totalValue);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", date=" + date + ", percentualDiscount="
				+ percentualDiscount + ", totalValue=" + totalValue + ", orderItem=" + orderItem + "]";
	}
	
	
}
