/* SALSA/World Wide Computer Project
 *  
 * MalformedUANException : Naming MalformedURLException. 
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 *
 */

package salsa.naming;

/**
 * Thrown by the UAN constructor.
 */
public class MalformedUANException extends Exception {
	public MalformedUANException(java.lang.String s) {
		super(s);
	}
}
