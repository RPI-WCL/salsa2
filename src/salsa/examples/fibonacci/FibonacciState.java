/****** SALSA LANGUAGE IMPORTS ******/
import salsa.wwc.WWCActorReference;
import salsa.wwc.WWCActorState;
import salsa.wwc.Message;
import salsa.wwc.StageService;
import salsa.wwc.language.JoinDirector;
import salsa.wwc.language.ContinuationDirector;
import salsa.wwc.language.TokenDirector;

import salsa.wwc.language.exceptions.ContinuationPassException;
import salsa.wwc.language.exceptions.TokenPassException;
import salsa.wwc.language.exceptions.MessageHandlerNotFoundException;
import salsa.wwc.language.exceptions.ConstructorNotFoundException;

/****** END SALSA LANGUAGE IMPORTS ******/

import salsa.wwc.io.StandardOutput;
import salsa.wwc.util.Timer;
import salsa.wwc.util.System;
import java.lang.Integer;

public class FibonacciState extends ActorStateState {
	int n;


	public Object invokeImmutableMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public Object invokeMessage(int messageId, String messageName, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case 0: return compute();
			case 1: finish( (Integer)arguments[0] ); return null;
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public void invokeConstructor(int messageId, String messageName, Object[] arguments) throws ConstructorNotFoundException {
		switch(messageId) {
			case 0: construct( (Integer)arguments[0] ); return;
			case 1: construct( (String[])arguments[0] ); return;
			default: throw new ConstructorNotFoundException(messageId, arguments);
		}
	}

	public void construct(int n) {
		this.n = n;
	}

	public void construct(String[] arguments) {
		n = Integer.parseInt(arguments[0]);
		StageService.sendMessage(self, 1 /*finish*/, new Object[]{StageService.sendImplicitTokenMessage(self, 0 /*compute*/, null)}, new int[]{0});
	}



	public int compute() throws TokenPassException {
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		} else {
			class ExpressionDirector1 extends WWCActorReference {
				public ExpressionDirector1(String identifier) { super(identifier); }
				public Object invokeImmutableMessage(int messageId, Object[] arguments) {
					return (Integer)arguments[0] + (Integer)arguments[1];
				}
			}
			StageService.sendPassImmutableMessage(new ExpressionDirector1(StageService.generateUniqueId()), 0, new Object[]{StageService.sendImplicitTokenMessage(Fibonacci.construct(0, new Object[]{n - 1}), 0 /*compute*/, null), StageService.sendImplicitTokenMessage(Fibonacci.construct(0, new Object[]{n - 2}), 0 /*compute*/, null)}, new int[]{0, 1}, StageService.getCurrentContinuationDirector(self));
			throw new TokenPassException();
		}
	}

	public void finish(int value) {
		StandardOutput.println(value);
		System.exit(0);
	}


	public FibonacciState(String identifier) { super(identifier); }

}
