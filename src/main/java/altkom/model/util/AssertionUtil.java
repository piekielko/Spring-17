package altkom.model.util;

import altkom.model.Entry;
import altkom.model.Person;


public class AssertionUtil {

	public static void assertTrue( boolean condition, String failMessage ) {
		
		if ( condition == false ) {
			throw new PhoneBookApplicationException( failMessage );
		}
	}
	
	public static void assertPerson( Entry entry ) {
		final Person person = entry.getPerson();
		
		assertTrue( person.getName() != null, "Entry.person.name cannot be null" );
		assertTrue( person.getSurname() != null, "Entry.person.surname cannot be null" );
	}
	
}
