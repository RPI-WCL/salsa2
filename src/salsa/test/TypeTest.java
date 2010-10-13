package salsa.test;

import java.lang.System;
import java.lang.Integer;
import java.util.Date;
import java.lang.Object;
import java.io.PrintStream;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

class TypeTest extends ActorRef {
  public TypeTest(TypeTestState actorState) {
    super(actorState);
  }
  public void go(String[] args) {
    actorState.send(this, actorState.getSelfRef(),-1,"act1","exitValue",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);
  }
  public static void main(String[] args) {
    TypeTest ref=new TypeTest(new TypeTestState());
    ref.go(args);
  }
}
