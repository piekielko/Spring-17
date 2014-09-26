package altkom.model.util;


public class PhoneBookApplicationException extends RuntimeException {

	public PhoneBookApplicationException() {

		super();
	}

	public PhoneBookApplicationException( String message, Throwable cause ) {

		super( message, cause );
	}

	public PhoneBookApplicationException( String message ) {

		super( message );
	}

	public PhoneBookApplicationException( Throwable cause ) {

		super( cause );
	}

}
