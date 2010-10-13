package salsa.test;

import java.lang.System;
import java.lang.Integer;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

class ThreadRing extends ActorRef {
  public ThreadRing(ThreadRingState actorState) {
    super(actorState);
  }
  public void go(String[] args) {
    actorState.send(this, actorState.getSelfRef(),-1,"act1","exitValue",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);
  }
  public static void main(String[] args) {
    ThreadRing ref=new ThreadRing(new ThreadRingState());
    ref.go(args);
  }
}
