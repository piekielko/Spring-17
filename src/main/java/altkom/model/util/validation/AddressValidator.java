package altkom.model.util.validation;

import org.springframework.validation.Errors;

import altkom.model.Address;
import altkom.model.util.StringUtils;


public class AddressValidator {

	public void validate( Address address, Errors errors ) {
		if ( StringUtils.isEmpty( address.getStreet() ) ) {
			errors.rejectValue( "address.street", "required" );
		}
		
		if ( StringUtils.isEmpty( address.getNumber() ) ) {
			errors.rejectValue( "address.number", "required" );
		}
		
		if ( StringUtils.isEmpty( address.getCity() ) ) {
			errors.rejectValue( "address.city", "required" );
		}
		
		if ( StringUtils.isEmpty( address.getPostalCode() ) ) {
			errors.rejectValue( "address.postalCode", "required" );
		}
	}
	
}
