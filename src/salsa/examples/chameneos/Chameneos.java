package salsa.examples.chameneos;

/****** SALSA LANGUAGE IMPORTS ******/
import salsa.local_fcs.SynchronousMailboxStage;
import salsa.local_fcs.LocalActor;
import salsa.local_fcs.Message;
import salsa.local_fcs.StageService;
import salsa.local_fcs.language.JoinDirector;
import salsa.local_fcs.language.MessageDirector;
import salsa.local_fcs.language.ContinuationDirector;
import salsa.local_fcs.language.TokenDirector;

import salsa.local_fcs.language.exceptions.ContinuationPassException;
import salsa.local_fcs.language.exceptions.TokenPassException;
import salsa.local_fcs.language.exceptions.MessageHandlerNotFoundException;
import salsa.local_fcs.language.exceptions.ConstructorNotFoundException;

/****** END SALSA LANGUAGE IMPORTS ******/

import salsa.local_fcs.io.StandardOutput;

public class Chameneos extends LocalActor {
	int self_meetings = 0;
	int other_meetings = 0;
	MeetingPlace meeting_place;


	public Object invokeImmutableMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public Object invokeMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case 0: left_other( (Colour)arguments[0] ); return null;
			case 1: left_self( (Colour)arguments[0] ); return null;
			case 2: output_meetings(); return null;
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public void invokeConstructor(int messageId, Object[] arguments) throws ConstructorNotFoundException {
		switch(messageId) {
			case 0: construct( (Colour)arguments[0], (MeetingPlace)arguments[1] ); return;
			default: throw new ConstructorNotFoundException(messageId, arguments);
		}
	}

	public void construct(Colour colour, MeetingPlace meeting_place) {
		this.meeting_place = meeting_place;
		StageService.sendMessage(meeting_place, 11 /*meet*/, new Object[]{this, colour});
	}



	public void left_other(Colour new_colour) {
		other_meetings++;
		StageService.sendMessage(meeting_place, 11 /*meet*/, new Object[]{this, new_colour});
	}

	public void left_self(Colour new_colour) {
		self_meetings++;
		StageService.sendMessage(meeting_place, 11 /*meet*/, new Object[]{this, new_colour});
	}

	public void output_meetings() {
		StandardOutput.print(other_meetings);
		meeting_place.spell(self_meetings);
		return;
	}


	public Chameneos() { super(); }

	public Chameneos(SynchronousMailboxStage stage) { super(stage); }

	public static Chameneos getImmutableReference(SynchronousMailboxStage stage) {
		return new Chameneos(stage);
	}

	public static TokenDirector construct(int constructor_id, Object[] arguments, int[] token_positions) {
		Chameneos actor = new Chameneos();
		TokenDirector output_continuation = TokenDirector.construct(0 /*construct()*/, null);
		Message input_message = new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments, output_continuation);
		MessageDirector md = MessageDirector.construct(0, new Object[]{input_message, token_positions.length});
		TokenDirector argument_token;
		for (int i = 0; i < token_positions.length; i++) {
			argument_token = (TokenDirector)arguments[token_positions[i]];
			StageService.send(new Message(Message.SIMPLE_MESSAGE, argument_token, 0 /*addMessageDirector*/, new Object[]{md, token_positions[i]}));
		}
		return output_continuation;
	}

	public static Chameneos construct(int constructor_id, Object[] arguments) {
		Chameneos actor = new Chameneos();
		StageService.send(new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments));
		return actor;
	}
	public static TokenDirector construct(int constructor_id, Object[] arguments, int[] token_positions, SynchronousMailboxStage target_stage) {
		Chameneos actor = new Chameneos(target_stage);
		TokenDirector output_continuation = TokenDirector.construct(0 /*construct()*/, null, target_stage);
		Message input_message = new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments, output_continuation);
		MessageDirector md = MessageDirector.construct(0, new Object[]{input_message, token_positions.length}, target_stage);
		TokenDirector argument_token;
		for (int i = 0; i < token_positions.length; i++) {
			argument_token = (TokenDirector)arguments[token_positions[i]];
			argument_token.stage.putMessageInMailbox(new Message(Message.SIMPLE_MESSAGE, argument_token, 0 /*addMessageDirector*/, new Object[]{md, token_positions[i]}));
		}
		return output_continuation;
	}

	public static Chameneos construct(int constructor_id, Object[] arguments, SynchronousMailboxStage target_stage) {
		Chameneos actor = new Chameneos(target_stage);
		target_stage.putMessageInMailbox(new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments));
		return actor;
	}
}
