package salsa.examples.fibonacci;

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

public class Fibonacci extends ActorState {
	// Added fields for message invoking
	public static final int FIBONACCI_COMPUTE = 0;
	public static final int FIBONACCI_INCREMENT = 1;
	public static final int FIBONACCI_COMPLEX = 2;
	public static final int FIBONACCI_FINISH = 3;
	// End

	// Added fields for constructor invoking
	public static final int FIBONACCI_0 = 0;
	public static final int FIBONACCI_1 = 1;
	// End


	int n;


	public Object invokeImmutableMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public Object invokeMessage(int messageId, String messageName, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case FIBONACCI_COMPUTE: return compute();
			case FIBONACCI_INCREMENT: return increment();
			case FIBONACCI_COMPLEX: return complex( (Integer)arguments[0], (String[])arguments[1] );
			case FIBONACCI_FINISH: finish( (Integer)arguments[0] ); return null;
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public void invokeConstructor(int messageId, String messageName, Object[] arguments) throws ConstructorNotFoundException {
		switch(messageId) {
			case FIBONACCI_0: construct( (Integer)arguments[0] ); return;
			case FIBONACCI_1: construct( (String[])arguments[0] ); return;
			default: throw new ConstructorNotFoundException(messageId, arguments);
		}
	}

	public void construct(int n) {
		this.n = n;
	}
	
	

	public void construct(String[] arguments) {
		n = Integer.parseInt(arguments[0]);
		StageService.sendMessage(this.getSelfRef(), 3 /*finish*/, new Object[]{StageService.sendImplicitTokenMessage(self, 0 /*compute*/, null)}, new int[]{0});
	}



	public int compute() throws TokenPassException {
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		} else {
			class ExpressionDirector1 extends ActorState  {
				public void invokeConstructor(int id, String messageName, Object[] arguments) {}
				public Object invokeMessage(int id, String messageName, Object[] arguments) { return null; }
				public Object invokeImmutableMessage(int messageId, Object[] arguments) {
					return (Integer)arguments[0] + (Integer)arguments[1];
				}
			}
			StageService.sendPassImmutableMessage(new ExpressionDirector1().getSelfRef(), 0, new Object[]{StageService.sendImplicitTokenMessage(Fibonacci.construct(0, new Object[]{n - 1}), 0 /*compute*/, null), StageService.sendImplicitTokenMessage(Fibonacci.construct(0, new Object[]{n - 2}), 0 /*compute*/, null)}, new int[]{0, 1}, StageService.getCurrentContinuationDirector(self));
			throw new TokenPassException();
		}
	}

	public int increment() {
		n = n + 1;
		return n;
	}

	public int complex(int i, String[] arrays) {
		StageService.sendMessage(self, 3 /*finish*/, new Object[]{n});
		return 0;
	}

	public void finish(int value) {
		StandardOutput.println(value);
		System.exit(0);
	}


	public static void main(String[] arguments) {
		construct(FIBONACCI_1, new Object[]{arguments});
	}

	public static ActorState getImmutableReference() { return new Fibonacci(); }

	public static ActorRef construct(int constructor_id, Object[] arguments) {
		ActorRef actor = new ActorRef(new Fibonacci());
		StageService.send(new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments));
		return actor;
	}
}
