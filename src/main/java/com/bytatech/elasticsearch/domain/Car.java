package com.bytatech.elasticsearch.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Car.
 */

public class Car {

/*	private Long id;
	private Integer price;

	private String color;

	private String make;

	private LocalDate date;
	
	
	private ZonedDateTime zonedDate ;
	private Instant instantDate;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ZonedDateTime getZonedDate() {
		return zonedDate;
	}

	public void setZonedDate(ZonedDateTime zonedDate) {
		this.zonedDate = zonedDate;
	}

	public Instant getInstantDate() {
		return instantDate;
	}

	public void setInstantDate(Instant instantDate) {
		this.instantDate = instantDate;
	}
*/
	
	 private Long id;

	   
	    private Integer price;

	    
	    private String color;

	    
	    private String make;
	private ZonedDateTime zonedDate ;
		private Instant instantDate;
	 
	    private LocalDate date;
	  
	    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Integer getPrice() {
	        return price;
	    }

	    public Car price(Integer price) {
	        this.price = price;
	        return this;
	    }

	    public void setPrice(Integer price) {
	        this.price = price;
	    }

	    public String getColor() {
	        return color;
	    }

	    public Car color(String color) {
	        this.color = color;
	        return this;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public String getMake() {
	        return make;
	    }

	    public Car make(String make) {
	        this.make = make;
	        return this;
	    }

	    public void setMake(String make) {
	        this.make = make;
	    }

	   
	 

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public Car date(LocalDate date) {
	        this.date = date;
	        return this;
	    }
	public ZonedDateTime getZonedDate() {
			return zonedDate;
		}

		public void setZonedDate(ZonedDateTime zonedDate) {
			this.zonedDate = zonedDate;
		}

		public Instant getInstantDate() {
			return instantDate;
		}

		public void setInstantDate(Instant instantDate) {
			this.instantDate = instantDate;
		}
	  
	    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	        Car car = (Car) o;
	        if (car.getId() == null || getId() == null) {
	            return false;
	        }
	        return Objects.equals(getId(), car.getId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }

	    @Override
	    public String toString() {
	        return "Car{" +
	            "id=" + getId() +
	            ", price=" + getPrice() +
	            ", color='" + getColor() + "'" +
	            ", make='" + getMake() + "'" +
	            ", date='" + getDate() + "'" +
	            "}";
	    }
	
	
}
