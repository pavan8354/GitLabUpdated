package Com.Qa.Util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface jirapolicy {
	
	boolean logTicketReady();

}
