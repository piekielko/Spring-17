package altkom.model.util.validation;

import org.springframework.validation.Errors;

import altkom.model.Person;
import altkom.model.util.StringUtils;


public class PersonValidator {

	public void validate( Person person, Errors errors ) {
		if ( StringUtils.isEmpty( person.getName() ) ) {
			errors.rejectValue( "person.name", "required" );
		}
		
		if ( StringUtils.isEmpty( person.getSurname() ) ) {
			errors.rejectValue( "person.surname", "required" );
		}
		
	}
	
}
