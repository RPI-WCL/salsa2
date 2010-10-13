package salsa.test;

import java.lang.System;
import java.lang.Integer;
import java.util.Date;
import java.lang.Object;
import java.io.PrintStream;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

class TypeTestState extends ActorState {
  int n;
  public TypeTestState()
  {
    n=10;
  }
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, java.lang.String o)
  {
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void add(ActorRef src, String assignTo, int n1, int n2, int n3)
  {
    {
      // Normal return
      send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{n1+n2+n3}, new int[]{},null);
      return;
    }
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void add(ActorRef src, String assignTo, int n1, int n2)
  {
    {
      // Normal return
      send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{n1+n2}, new int[]{},null);
      return;
    }
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void act(ActorRef src, String assignTo, java.lang.String[] args)
  {
    int n = Integer.parseInt(args[0]);
    salsa.test.Fib fib = new salsa.test.Fib(new salsa.test.FibState(n));
    send(self/*replyTo*/,fib/*dest*/,1/*msgId*/,"compute0" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{},new int[]{},null);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {
    if (msgName.equals("println1")) {
      println(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgName.equals("add3")) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1],(Integer)args[2]);
      return;
    }
    if (msgName.equals("add2")) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1]);
      return;
    }
    if (msgName.equals("act1")) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
  public void invokeById(int msgId, Object[] args, ActorRef src, String assignTo) {
    if (msgId == 3) {
      println(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgId == 2) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1],(Integer)args[2]);
      return;
    }
    if (msgId == 1) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1]);
      return;
    }
    if (msgId == 4) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
}
