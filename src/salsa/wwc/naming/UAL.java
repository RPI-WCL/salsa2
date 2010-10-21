/* SALSA/World Wide Computer Porject
 *
 * UAL - Universal Actor Location
 * 
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 *
 */

package salsa.naming;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Universal Actor Location. Contains enough data for an actor to be reached in
 * the World Wide Computer, that is, the hostname and the port number of the
 * RMSPDaemon (Remote Message Sending Protocol), and its local name. These
 * informations are not authoritative (actor may have migrated), but those
 * contained in the UAN (Universal Actor Name) are.
 */
public class UAL extends URI {

	public String getLocation() {
		String retval = "rmsp://" + url.getHost() + ":" + url.getPort() + "/";

		String file = url.getFile();
		if (file.length() > 8 && file.substring(0, 8).equals("/applet/")) {
			retval += url.getFile().substring(1,
					file.indexOf("/", file.indexOf("/", 1) + 1))
					+ "/";
		}
		return retval;
	}

	/**
	 * Builds a UAL from a given string.
	 * 
	 * @param s
	 *            the string standing for the UAL.
	 */
	public UAL(String s) throws MalformedUALException {
		try {
			protocol = "rmsp";
			int colonPosition = s.indexOf(':');
			if (!(protocol.equals(s.substring(0, colonPosition))))
				throw new Exception();

			url = new URL("http" + s.substring(colonPosition));
		} catch (Exception e) {
			throw new MalformedUALException("Malformed UAL : " + s);
		}
	}

	public int getPort() {
		if (url.getPort() == -1)
			return 4040;
		return url.getPort();
	}
}
