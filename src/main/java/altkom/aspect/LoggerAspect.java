package altkom.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
		
	@Before( "execution( * altkom.model.repository.PhoneBookRepository.*(..))" )
	public void logMethodBegining( JoinPoint jpoint ) {
                System.out.println("logMethodBegining");
		logMethodName( jpoint );
		logParams( jpoint );
	}
	
	@AfterReturning( pointcut="execution(* altkom.model.repository.PhoneBookRepository.*(..))", returning="result" )
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
                System.out.println("logAfterReturning");
                logResult( result );
		logDebug( "--------------------------------------------------------------------" );
	}
	
        @Around( "target(altkom.model.repository.PhoneBookRepository)" )
        public Object repositoryMethods(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("repositoryMethods:start");
            Object result = joinPoint.proceed();
            System.out.println("repositoryMethods:end");
            return result;
	}
	
	private void logMethodName( JoinPoint jpoint ) {

		String className = jpoint.getTarget().getClass().getName();
		String methodName = jpoint.getSignature().getName();
		
		logDebug( "Execution of method: " + className + "#" + methodName );
	}
	
	private void logParams( JoinPoint jpoint ) {
		final Object[] args = jpoint.getArgs();
		
		String argsStr = "Parameters: ( ";
		for ( int i = 0; i < args.length; i++ ) {
			argsStr += args[ i ];
			argsStr += ", ";
		}
		argsStr += " )";
		
		logDebug( argsStr );
	}
	
	private void logResult( Object object ) {
		logDebug( "Result of invocation: " + object );
	}
	
	private void logDebug( String msg ) {
		System.out.println( "[DEBUG]: " + msg );
	}
	
	private void logFatal( String msg ) {
		System.out.println( "[FATAL]: " + msg );
		
	}
}
