package altkom.model.util.validation;

import org.springframework.validation.Errors;

import altkom.model.Phone;
import altkom.model.util.StringUtils;


public class PhoneValidator {

	public void validate( Phone phone, Errors errors ) {
		if ( StringUtils.isEmpty( phone.getPhoneNumber() ) ) {
			errors.rejectValue( "phone.phoneNumber", "required" );
		}
		
		if ( StringUtils.isEmpty( phone.getAreaNumber() ) ) {
			errors.rejectValue( "phone.areaNumber", "required" );
		}
		
		if ( StringUtils.isEmpty( phone.getCountryNumber() ) ) {
			errors.rejectValue( "phone.countryNumber", "required" );
		}
	}
	
}
