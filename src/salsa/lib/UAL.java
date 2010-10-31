package salsa.lib;

import java.io.Serializable;

public class UAL implements Serializable {
    public static final String PREFIX = "ual://";
    private String host;
    private int port = 3030;
    private String identifier;
   
        
    public UAL(String identifier) {        
        this.identifier = identifier;
        int prefixLen = PREFIX.length();
        int colonPos = identifier.indexOf(':');
        int slashPos = identifier.indexOf('/', prefixLen);
//        if (identifier.contains("#"))
//            throw new MalformedUANException("uan cannot contain # symbol " + identifier);
        if (colonPos > 0 && slashPos > 0) {
            try {
                host = identifier.substring(prefixLen, colonPos);
                port = Integer.valueOf(identifier.substring(colonPos + 1, slashPos));
            } catch (Exception e) {
                
            }
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
   
}
