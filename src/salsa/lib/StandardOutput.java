package salsa.lib;

import java.lang.System;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

public class StandardOutput extends ActorRef {
  public StandardOutput(StandardOutputState actorState) {
    super(actorState);
  }
  public void go(String[] args) {
    actorState.send(this, actorState.getSelfRef(),-1,"act1","exitValue",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);
  }
  public static void main(String[] args) {
    StandardOutput ref=new StandardOutput(new StandardOutputState());
    ref.go(args);
  }
}
