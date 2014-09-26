package altkom.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import altkom.model.Entry;

@Repository
@Transactional
public class HibernateRepository
		implements PhoneBookRepository {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void init( HibernateTemplate hibernateTemplate ) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Entry> findAllEntries() {
		
		List result = hibernateTemplate.findByNamedQuery( "Entry.findAll" );
		
		if ( isNullOrEmpty( result ) ) {
			return new ArrayList<Entry>();
		}
		
		return result;
	}

	@Override
	public Entry findById( Long id ) {
		List result = hibernateTemplate
			.findByNamedQueryAndNamedParam( "Entry.findById", "employeeId", id );
		
		return (Entry) result.get( 0 );
	}

	@Override
	public void logToSysout() {

		// TODO Auto-generated method stub

	}

	@Override
	public void save( Entry entry ) {
		hibernateTemplate.save( entry );
	}

	@Override
	public void update( Entry entry ) {
		hibernateTemplate.update( entry );
	}
	
	private boolean isNullOrEmpty( List result ) {

		if( result == null || result.isEmpty() ) {
			return true;
		}
		
		return false;
	}
	
}
