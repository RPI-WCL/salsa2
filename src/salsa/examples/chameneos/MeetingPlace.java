package salsa.examples.chameneos;

/****** SALSA LANGUAGE IMPORTS ******/
import salsa.local_noref.LocalActor;
import salsa.local_noref.Message;
import salsa.local_noref.StageService;
import salsa.local_noref.language.JoinDirector;
import salsa.local_noref.language.MessageDirector;
import salsa.local_noref.language.ContinuationDirector;
import salsa.local_noref.language.TokenDirector;

import salsa.local_noref.language.exceptions.ContinuationPassException;
import salsa.local_noref.language.exceptions.TokenPassException;
import salsa.local_noref.language.exceptions.MessageHandlerNotFoundException;
import salsa.local_noref.language.exceptions.ConstructorNotFoundException;

/****** END SALSA LANGUAGE IMPORTS ******/

import salsa.local_noref.io.StandardOutput;
import salsa.local_noref.util.StringUtil;
import salsa.local_noref.util.Timer;

public class MeetingPlace extends LocalActor {
	boolean did_evens = false;
	int max_meetings;
	int meetings;
	Chameneos[] chameneoses;
	Chameneos first = null;
	Colour first_colour;
	Timer timer;


	public Object invokeImmutableMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case 0: return MeetingPlace.spell( (Integer)arguments[0] );
			case 1: MeetingPlace.printCompliments(); return null;
			case 2: MeetingPlace.printCompliment( (Colour)arguments[0], (Colour)arguments[1] ); return null;
			case 3: return MeetingPlace.doCompliment( (Colour)arguments[0], (Colour)arguments[1] );
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public Object invokeMessage(int messageId, Object[] arguments) throws ContinuationPassException, TokenPassException, MessageHandlerNotFoundException {
		switch(messageId) {
			case 0: return MeetingPlace.spell( (Integer)arguments[0] );
			case 1: MeetingPlace.printCompliments(); return null;
			case 2: MeetingPlace.printCompliment( (Colour)arguments[0], (Colour)arguments[1] ); return null;
			case 3: return MeetingPlace.doCompliment( (Colour)arguments[0], (Colour)arguments[1] );
			case 4: odds(); return null;
			case 5: evens(); return null;
			case 6: meet( (Chameneos)arguments[0], (Colour)arguments[1] ); return null;
			case 7: finished(); return null;
			case 8: end(); return null;
			default: throw new MessageHandlerNotFoundException(messageId, arguments);
		}
	}

	public void invokeConstructor(int messageId, Object[] arguments) throws ConstructorNotFoundException {
		switch(messageId) {
			case 0: construct( (String[])arguments[0] ); return;
			default: throw new ConstructorNotFoundException(messageId, arguments);
		}
	}

	public void construct(String[] arguments) {
		max_meetings = Integer.parseInt(arguments[0]);
		meetings = max_meetings;
		timer = Timer.construct(0, null);
		MeetingPlace.printCompliments();
		ContinuationDirector continuation_token = StageService.sendContinuationMessage(timer, 0 /*startTimer*/, null);
		StageService.sendMessage(this, 4 /*odds*/, null, continuation_token);
	}



	public static String spell(int value) {
		String output = "";
		String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String nStr = StringUtil.valueOf(value);
		for (int i = 0; i < StringUtil.lengthOf(nStr); i++) {
			output += " " + numbers[Character.getNumericValue(StringUtil.charAt(nStr, i))];
		}

		return output;
	}

	public static void printCompliments() {
		MeetingPlace.printCompliment(Colour.blue, Colour.blue);
		MeetingPlace.printCompliment(Colour.blue, Colour.red);
		MeetingPlace.printCompliment(Colour.blue, Colour.yellow);
		MeetingPlace.printCompliment(Colour.red, Colour.blue);
		MeetingPlace.printCompliment(Colour.red, Colour.red);
		MeetingPlace.printCompliment(Colour.red, Colour.yellow);
		MeetingPlace.printCompliment(Colour.yellow, Colour.blue);
		MeetingPlace.printCompliment(Colour.yellow, Colour.red);
		MeetingPlace.printCompliment(Colour.yellow, Colour.yellow);
	}

	public static void printCompliment(Colour c1, Colour c2) {
		StandardOutput.println(c1 + " + " + c2 + " -> " + MeetingPlace.doCompliment(c1, c2));
	}

	public static Colour doCompliment(Colour c1, Colour c2) {
		switch (c1) {
			case blue:
			switch (c2) {
				case blue:
				return Colour.blue;
				case red:
				return Colour.yellow;
				case yellow:
				return Colour.red;
			}

			case red:
			switch (c2) {
				case blue:
				return Colour.yellow;
				case red:
				return Colour.red;
				case yellow:
				return Colour.blue;
			}

			case yellow:
			switch (c2) {
				case blue:
				return Colour.red;
				case red:
				return Colour.blue;
				case yellow:
				return Colour.yellow;
			}

		}

		StandardOutput.println("Cannot do compliment for unknown colours: " + c1 + ", " + c2);
		System.exit(0);
		return c1;
	}

	public void odds() {
		StandardOutput.println("\nblue red yellow");
		chameneoses = new Chameneos[3];
		chameneoses[0] = Chameneos.construct(0, new Object[]{Colour.blue, this});
		chameneoses[1] = Chameneos.construct(0, new Object[]{Colour.red, this});
		chameneoses[2] = Chameneos.construct(0, new Object[]{Colour.yellow, this});
	}

	public void evens() {
		meetings = max_meetings;
		first = null;
		StandardOutput.println("\nblue red yellow red yellow blue red yellow red blue");
		chameneoses = new Chameneos[10];
		chameneoses[0] = Chameneos.construct(0, new Object[]{Colour.blue, this});
		chameneoses[1] = Chameneos.construct(0, new Object[]{Colour.red, this});
		chameneoses[2] = Chameneos.construct(0, new Object[]{Colour.yellow, this});
		chameneoses[3] = Chameneos.construct(0, new Object[]{Colour.red, this});
		chameneoses[4] = Chameneos.construct(0, new Object[]{Colour.yellow, this});
		chameneoses[5] = Chameneos.construct(0, new Object[]{Colour.blue, this});
		chameneoses[6] = Chameneos.construct(0, new Object[]{Colour.red, this});
		chameneoses[7] = Chameneos.construct(0, new Object[]{Colour.yellow, this});
		chameneoses[8] = Chameneos.construct(0, new Object[]{Colour.red, this});
		chameneoses[9] = Chameneos.construct(0, new Object[]{Colour.blue, this});
	}

	public void meet(Chameneos chameneos, Colour colour) {
		if (meetings == 0) {
			return;
		} 
		if (first == null) {
			first = chameneos;
			first_colour = colour;
		}
		else {
			if (first == chameneos) {
				StageService.sendMessage(first, 1 /*left_self*/, new Object[]{MeetingPlace.doCompliment(first_colour, colour)});
				StageService.sendMessage(chameneos, 1 /*left_self*/, new Object[]{MeetingPlace.doCompliment(first_colour, colour)});
				first = null;
			}
			else {
				StageService.sendMessage(first, 0 /*left_other*/, new Object[]{MeetingPlace.doCompliment(first_colour, colour)});
				StageService.sendMessage(chameneos, 0 /*left_other*/, new Object[]{MeetingPlace.doCompliment(first_colour, colour)});
				first = null;
			}

			meetings--;
			if (meetings == 0) {
				StageService.sendMessage(this, 7 /*finished*/, null);
			} 
		}

	}

	public void finished() {
		if (!did_evens) {
			did_evens = true;
			ContinuationDirector join_director_3_1_continuation = ContinuationDirector.construct(0, null);
			JoinDirector join_director_3_1 = JoinDirector.construct(0, new Object[]{join_director_3_1_continuation});
			int join_director_3_1_message_count = 0;
			{
				for (int i = 0; i < chameneoses.length; i++) {
					ContinuationDirector continuation_token = StageService.sendContinuationMessage((chameneoses[i]), 2 /*output_meetings*/, null);
					StageService.sendMessage(join_director_3_1, 0 /*setValue*/, new Object[]{++join_director_3_1_message_count}, continuation_token);
				}

			}
			StageService.sendMessage(join_director_3_1, 1 /*resolveAfter*/, new Object[]{join_director_3_1_message_count});
			ContinuationDirector continuation_token = join_director_3_1_continuation;

			continuation_token = StageService.sendContinuationImmutableMessage(StandardOutput.getImmutableReference(), 10 /*println*/, new Object[]{StageService.sendImplicitTokenImmutableMessage(MeetingPlace.getImmutableReference(), 0 /*spell*/, new Object[]{max_meetings * 2}, continuation_token)}, new int[]{0}, continuation_token);
			continuation_token = StageService.sendContinuationMessage(timer, 0 /*startTimer*/, null, continuation_token);
			StageService.sendMessage(this, 5 /*evens*/, null, continuation_token);
		}
		else {
			ContinuationDirector join_director_3_1_continuation = ContinuationDirector.construct(0, null);
			JoinDirector join_director_3_1 = JoinDirector.construct(0, new Object[]{join_director_3_1_continuation});
			int join_director_3_1_message_count = 0;
			{
				for (int i = 0; i < chameneoses.length; i++) {
					ContinuationDirector continuation_token = StageService.sendContinuationMessage((chameneoses[i]), 2 /*output_meetings*/, null);
					StageService.sendMessage(join_director_3_1, 0 /*setValue*/, new Object[]{++join_director_3_1_message_count}, continuation_token);
				}

			}
			StageService.sendMessage(join_director_3_1, 1 /*resolveAfter*/, new Object[]{join_director_3_1_message_count});
			ContinuationDirector continuation_token = join_director_3_1_continuation;

			continuation_token = StageService.sendContinuationImmutableMessage(StandardOutput.getImmutableReference(), 10 /*println*/, new Object[]{StageService.sendImplicitTokenImmutableMessage(MeetingPlace.getImmutableReference(), 0 /*spell*/, new Object[]{max_meetings * 2}, continuation_token)}, new int[]{0}, continuation_token);
			StageService.sendMessage(this, 8 /*end*/, null, continuation_token);
		}

	}

	public void end() {
		System.exit(0);
	}


	public static void main(String[] arguments) {
		StageService.send(new Message(Message.CONSTRUCT_MESSAGE, new MeetingPlace(), 0, new Object[]{arguments}));
	}

	public static MeetingPlace getImmutableReference() { return new MeetingPlace(); }
	public static TokenDirector construct(int constructor_id, Object[] arguments, int[] token_positions) {
		MeetingPlace actor = new MeetingPlace();
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

	public static MeetingPlace construct(int constructor_id, Object[] arguments) {
		MeetingPlace actor = new MeetingPlace();
		StageService.send(new Message(Message.CONSTRUCT_MESSAGE, actor, constructor_id, arguments));
		return actor;
	}
}
