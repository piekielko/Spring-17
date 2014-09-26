
package altkom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table( name="pb_persons" )
public class Person implements Formatter {

	private Long id;
	
	private String name;

	private String surname;

	@Override
	public String prettyFormat() {
		return name + surname;
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	public String getName() {

		return name;
	}

	public String getSurname() {

		return surname;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setSurname( String surname ) {

		this.surname = surname;
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
