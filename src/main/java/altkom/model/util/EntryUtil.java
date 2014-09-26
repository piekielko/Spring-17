
package altkom.model.util;

import java.util.HashMap;
import java.util.Map;

import altkom.model.Address;
import altkom.model.Entry;
import altkom.model.EntryCategory;
import altkom.model.Person;
import altkom.model.Phone;
import altkom.model.PhoneType;

public class EntryUtil {

	private static final String NULL_MSG = "Ensure that Entry object was initialized";

	public static Map<Long,Entry> createCoupleOfEntryMocks() {
		Map<Long, Entry> entries = new HashMap<Long, Entry>();
		
		Entry firstEntry = createEntry( EntryCategory.BUSINESS_PARTNER );
		setPerson( firstEntry, "John", "Lenon" );
		setAddress( firstEntry, "Down Street", "33", "Liverpool", "1232" );
		setPhone( firstEntry, PhoneType.HOME, "+42", "17", "744-223-113" );
		entries.put( 1L, firstEntry );
		
		Entry secondEntry = createEntry( EntryCategory.CUSTOMER );
		setPerson( secondEntry, "Kirk", "Hammet" );
		setAddress( secondEntry, "Town Road", "11", "New York", "57884" );
		setPhone( secondEntry, PhoneType.MOBILE, "+37", "56", "8223-123-2" );
		entries.put( 2L, secondEntry );
		
		Entry thirdEntry = createEntry( EntryCategory.SERVICE_DELIVERER );
		setPerson( thirdEntry, "Rod", "Johnson" );
		setAddress( thirdEntry, "Down Street", "33", "Florida", "321" );
		setPhone( thirdEntry, PhoneType.PUBLIC, "4", "421", "123-123-132" );
		entries.put( 3L, thirdEntry );
		
		return entries;
	}

	public static Entry createEntry( EntryCategory entryCategory ) {

		Entry entry = new Entry();
		entry.setCategory( entryCategory );

		return entry;
	}

	public static void setPerson( Entry entry, String name, String surname ) {

		final Person person = entry.getPerson();
		AssertionUtil.assertTrue( person != null, NULL_MSG );

		person.setName( name );
		person.setSurname( surname );
	}

	public static void setAddress( Entry entry, String street, String number,
			String city, String postalCode ) {

		final Address address = entry.getAddress();
		AssertionUtil.assertTrue( address != null, NULL_MSG );
		
		address.setStreet( street );
		address.setNumber( number );
		address.setCity( city );
		address.setPostalCode( postalCode );
	}

	public static void setPhone( Entry entry, PhoneType phoneType,
			String countryNumber, String areaNumber, String phoneNumber ) {

		final Phone phone = entry.getPhone();
		AssertionUtil.assertTrue( phone != null, NULL_MSG );
		
		phone.setType( phoneType );
		phone.setCountryNumber( countryNumber );
		phone.setAreaNumber( areaNumber );
		phone.setPhoneNumber( phoneNumber );
	}
}
