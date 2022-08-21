package tech.testgodev.application.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Double value;
	@Column(name = "type", nullable = false)
	private Character type;
	
	//Empty Constructor
	public Product() {	}
	
	//Constructor
	public Product(Integer id, String description, Double value, char type) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.type = type;
	}

	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		if(type == 's' || type == 'S') {
			this.type = type;
		}
		if( type == 'p' || type == 'P') {			
			this.type = type;
		}
	}

	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(description, id, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id) && type == other.type
				&& Objects.equals(value, other.value);
	}

	//ToString
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", value=" + value + ", type=" + type + "]";
	}
	
	
	
	
}
