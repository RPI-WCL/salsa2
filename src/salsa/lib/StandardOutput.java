package salsa.lib;

import java.lang.System;
import salsa.wwc.lang.*;
import salsa.wwc.lang.fullcopy.DeepCopy;
import java.util.*;

public class StandardOutput extends ActorRef {
  public StandardOutput(StandardOutputState actorState) {
    super(actorState);
  }
  public StandardOutput(StandardOutputState actorState, String uan, String location) {
    super(actorState, uan, location);
  }
  public void go(ActorState actorState, String[] args) {
    actorState.send(this, actorState.getSelfRef(),-1,"act1","exitValue",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);
  }
  public static void main(String[] args) {
    StandardOutputState as = new StandardOutputState();
    StandardOutput ref=new StandardOutput(as);
    ref.go(as, args);
  }
}
