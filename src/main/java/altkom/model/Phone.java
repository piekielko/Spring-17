package altkom.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table( name="pb_phones" )
public class Phone implements Formatter {

	public static final String SPACE = " ";
	
	private Long id;
	
	private PhoneType type = PhoneType.MOBILE;
	
	private String countryNumber;
	
	private String areaNumber;
	
	private String phoneNumber;
	
	public String prettyFormat() {
		String result
			= getCountryNumber()
			+ SPACE
			+ getAreaNumber()
			+ SPACE
			+ getPhoneNumber();
		
		return result; 
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	public PhoneType getType() {
		
		return type;
	}

	
	public String getCountryNumber() {
	
		return countryNumber;
	}

	
	public String getAreaNumber() {
	
		return areaNumber;
	}

	
	public String getPhoneNumber() {
	
		return phoneNumber;
	}

	@Enumerated(EnumType.STRING)
	public void setType( PhoneType phoneType ) {
	
		this.type = phoneType;
	}

	
	public void setCountryNumber( String countryNumber ) {
	
		this.countryNumber = countryNumber;
	}

	
	public void setAreaNumber( String areaNumber ) {
	
		this.areaNumber = areaNumber;
	}

	
	public void setPhoneNumber( String phoneNumber ) {
	
		this.phoneNumber = phoneNumber;
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
