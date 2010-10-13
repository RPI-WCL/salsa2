/* SALSA/World Wide Computer Project
 *  
 * UAN : Universal Actor Name. 
 *
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 *
 */

package salsa.naming;

import java.net.URL;

/**
 * Universal Actor Name. Contains enough data to retrieve the location (UAL) of
 * an acor running in the World Wide Computer, that is, the hostname and the
 * port number of the UANDaemon (location server), and its local name on this
 * server. These informations are authoritative (actor may have migrated), but
 * those contained in the UAL (Universal Actor Name) are not.
 */
public class UAN extends URI {

	public UAN(String s) throws MalformedUANException {
		try {
			protocol = "uan";
			int colonPosition = s.indexOf(':');
			if (!(protocol.equals(s.substring(0, colonPosition))))
				throw new Exception();

			url = new URL("http" + s.substring(colonPosition));

		} catch (Exception e) {
			throw new MalformedUANException("Malformed UAN : " + s);
		}
	}

	public String getLocation() {
		return "uan://" + url.getHost() + ":" + url.getPort() + "/";
	}

	/**
	 * This method returns the specified server port, or 3030 if the port has
	 * not been set.
	 * 
	 * @see salsa.language.URI#getPort()
	 */
	public int getPort() {

		if (url.getPort() == -1) {
			return 3030;
		}

		return url.getPort();
	}

}
