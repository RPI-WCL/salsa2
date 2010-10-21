/* SALSA/World Wide Computer Porject
 *
 * Location Server - Universal Actor Name Daemon
 * Provides the location (Universal Actor Location) of an actor running on
 * the World Wide Computer from its name (Universal Actor Name).
 *
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 * Modified by WeiJen Wang. v0.2 June, 2005
 */

package salsa.naming;

/**
 * Defines the constants of the Universal Actor Name Protocol v0.2. Can not be
 * instanciated. Both of the client and server must follow the following format
 * format: <VERSION> + "\n" + <COMMAND_CODE> + "\n" + <ARG1> + "\n" + <ARG2> +
 * "\n" wherre <COMMAND_CODE> can be "GET", "PUT", "DEL", "FSC", ..., "NOT" and
 * "\n" is not allowed in <VERSION>, <COMMAND_CODE>, <ARG1>, <ARG2>
 * 
 * @author Gregory Haik, Carlos Varela, WeiJen Wang
 */

public class UANProtocol {
	/********
	 * This private constructor guarantees that this class will never be
	 * instanciated.
	 ********/
	private UANProtocol() {
	};

	public static final String VERSION = "UANP/0.2";

	public static final String GET_REQUEST_CODE = "GET";
	public static final String PUT_REQUEST_CODE = "PUT";
	public static final String DELETE_REQUEST_CODE = "DEL";

	public static final String FOUND_STATUS_CODE = "FSC";
	public static final String MODIFY_STATUS_CODE = "MSC";
	public static final String DELETE_STATUS_CODE = "DSC";

	public static final String BAD_REQUEST_STATUS_CODE = "BAD";
	public static final String NOT_FOUND_STATUS_CODE = "NOT";

	public static String FOUND_STATUS_STR = "Location Found";
	public static String MODIFY_STATUS_STR = "Database Modified";
	public static String DELETE_STATUS_STR = "Entry Deleted";

	public static String BAD_REQUEST_STATUS_STR = "Bad Request";
	public static String NOT_FOUND_STATUS_STR = "Name Not Found";
}
