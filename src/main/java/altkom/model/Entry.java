package altkom.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table( name="pb_entries" )
@NamedQueries({
	@NamedQuery( name="Entry.findAll", query="from Entry" ),
	@NamedQuery( name="Entry.findById", query="from Entry e where e.id = :entryId" )
}
)
public class Entry {
	
	private Long id;
	
	private EntryCategory category = EntryCategory.DEFAULT;
	
	private Person person = new Person();
	
	private Address address = new Address();
	
	private Phone phone = new Phone();
	
	public String categoryAsPrettyString() {
		return category.toString();
	}
	
	public String personAsPrettyString() {
		return person.prettyFormat();
	}
	
	public String addressAsPrettyStringString() {
		return address.prettyFormat();
	}
	
	public String phoneAsPrettyString() {
		return phone.prettyFormat();
	}
	
	public String phoneTypeAsPrettyString() {
		return phone.getType().toString();
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	public Long getId() {
	
		return id;
	}
	
	public void setId( Long id ) {
	
		this.id = id;
	}

	@Enumerated( EnumType.STRING )
	public EntryCategory getCategory() {
	
		return category;
	}

	@OneToOne( cascade=CascadeType.ALL )
	public Person getPerson() {
	
		return person;
	}

	@OneToOne( cascade=CascadeType.ALL )
	public Address getAddress() {
	
		return address;
	}

	@OneToOne( cascade=CascadeType.ALL )
	public Phone getPhone() {
	
		return phone;
	}

	public void setCategory( EntryCategory category ) {
	
		this.category = category;
	}

	
	public void setPerson( Person person ) {
	
		this.person = person;
	}

	
	public void setAddress( Address address ) {
	
		this.address = address;
	}

	
	public void setPhone( Phone phone ) {
	
		this.phone = phone;
	}
	
}
