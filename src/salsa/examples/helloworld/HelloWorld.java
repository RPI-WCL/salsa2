package salsa.examples.helloworld;

/****** SALSA LANGUAGE IMPORTS ******/
import salsa.lang.*;
import salsa.lang.exceptions.*;
import salsa.lang.services.*;
import salsa.util.director.*;
/****** END SALSA LANGUAGE IMPORTS ******/

import salsa.local_fcs.io.StandardOutput;
import salsa.local_fcs.util.Timer;
import salsa.local_fcs.util.System;
import java.lang.Integer;

public class HelloWorld extends ActorState {
	// Added fields for message invoking
	public static final int HELLOWORLD_HELLO = 0;
	public static final int HELLOWORLD_WORLD = 1;
	// End

	// Added fields for constructor invoking
	public static final int HELLOWORLD_0 = 0;
	public static final int HELLOWORLD_1 = 1;
	// End


	String hello = "";


	public Object invokeImmutableMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public Object invokeMessage(int messageId, String messageName, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case HELLOWORLD_HELLO: return hello();
			case HELLOWORLD_WORLD: return world();
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public void invokeConstructor(int messageId, String messageName, Object[] arguments) throws ConstructorNotFoundException {
		switch(messageId) {
			case HELLOWORLD_0: construct( (String)arguments[0] ); return;
			case HELLOWORLD_1: construct( (String[])arguments[0] ); return;
			default: throw new ConstructorNotFoundException(messageId, arguments);
		}
	}

	public void construct(String s) {
		hello = s;
	}

	public void construct(String[] arguments) {
		HelloWorld hw = ObjectWrapperActor.construct("HellowWorld", -1, new Object[]{"Hello"});
		StageService.sendMessage(self, 0 /*hello*/, null);
		StageService.sendMessage(self, 1 /*world*/, null);
	}



	public void hello() {
		StandardOutput.print(hello);
	}

	public void world() {
		StandardOutput.println(" World!");
	}


	public static void main(String[] arguments) {
		construct(HELLOWORLD_1, new Object[]{arguments});
	}

	public static ActorState getImmutableReference() { return new HelloWorld(); }

	public static ActorRef construct(int constructor_id, Object[] arguments) {
		ActorRef actor = new ActorRef(new HelloWorld());
		StageService.send(new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments));
		return actor;
	}
}
