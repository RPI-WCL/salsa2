package salsa.lang.exceptions;

import salsa.util.director.ContinuationDirector;


public class ContinuationPassException extends Exception {

	public ContinuationDirector continuationDirector;

	public ContinuationPassException(ContinuationDirector continuationDirector) {
		super();
		this.continuationDirector = continuationDirector;
	}
}
