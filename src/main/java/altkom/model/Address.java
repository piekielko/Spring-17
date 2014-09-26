package altkom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table( name="pb_addresses" )
public class Address implements Formatter {

	private Long id;
	
	private String street;
	
	private String number;
	
	private String city;
	
	private String postalCode;

	@Override
	public String prettyFormat() {
		String result
			= number
			+ street + ","
			+ postalCode
			+ city;
		
		return result;
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	public void setStreet( String street ) {
	
		this.street = street;
	}

	
	public void setNumber( String number ) {
	
		this.number = number;
	}

	
	public void setCity( String city ) {
	
		this.city = city;
	}

	
	public void setPostalCode( String postalCode ) {
	
		this.postalCode = postalCode;
	}

	
	public String getStreet() {
	
		return street;
	}

	
	public String getNumber() {
	
		return number;
	}

	
	public String getCity() {
	
		return city;
	}

	
	public String getPostalCode() {
	
		return postalCode;
	}

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	public Long getId() {
	
		return id;
	}

	
	public void setId( Long id ) {
	
		this.id = id;
	}
	
}
