package altkom.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import altkom.model.repository.PhoneBookRepository;
import altkom.view.EmployeesPdfReportView;

@Controller()
@RequestMapping( "/generateReport.do" )
public class ReportGeneratorController {

	@Autowired
	private PhoneBookRepository phoneBookRepository;


	@RequestMapping( method = RequestMethod.GET )
	public ModelAndView generateReport() {
		Map model = new HashMap();
		model.put( EmployeesPdfReportView.ENTRIES_KEY,
				phoneBookRepository.findAllEntries() );
		
		return new ModelAndView( "employeesReport", model );
	}
	
	public PhoneBookRepository getPhoneBookRepository() {
	
		return phoneBookRepository;
	}

	
	public void setPhoneBookRepository( PhoneBookRepository phoneBookRepository ) {
	
		this.phoneBookRepository = phoneBookRepository;
	}
	
}
