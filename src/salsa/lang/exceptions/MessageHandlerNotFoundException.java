package salsa.lang.exceptions;

public class MessageHandlerNotFoundException extends Exception {

    String[] argTypes;
    String[] argValues;
    String message;

    public MessageHandlerNotFoundException(int messageId, Object[] arguments) {
        this.message = String.valueOf(messageId);
        argTypes = new String[arguments.length];
        argValues = new String[arguments.length];
        for (int i = 0; i < argTypes.length; i++) {
            argTypes[i] = arguments[i].getClass().getName();
            argValues[i] = arguments[i].toString();
        }
    }

    public MessageHandlerNotFoundException(String messageName,
            Object[] arguments) {
        this.message = messageName;
        argTypes = new String[arguments.length];
        argValues = new String[arguments.length];
        for (int i = 0; i < argTypes.length; i++) {
            argTypes[i] = arguments[i].getClass().getName();
            argValues[i] = arguments[i].toString();
        }
    }

    public String toString() {
        String description = "MessageHandlerNotFoundException: could not find message: "
                + message + "\n";
        description += "\targument types: ";
        for (int i = 0; i < argTypes.length; i++)
            description += argTypes[i] + " ";
        description += "\n\targument values: ";
        for (int i = 0; i < argValues.length; i++)
            description += argValues[i] + " ";
        return description;
    }
}
