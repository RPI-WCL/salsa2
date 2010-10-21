/* SALSA/World Wide Computer Porject
 *
 * UAL - Universal Actor Location
 * 
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 *
 */

package salsa.naming;

/**
 * Thrown whenever parsing of a UAL has failed.
 */
public class MalformedUALException extends Exception {
	public MalformedUALException(java.lang.String s) {
		super(s);
	}
}
