package salsa.test;

import java.lang.System;
import java.lang.Integer;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

class FibState extends ActorState {
  int n = 2;
  public FibState(int _n)
  {
    n=_n;
  }
  public FibState() {}
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void finish(ActorRef src, String assignTo, int result)
  {
    System.out.println(result);
    System.exit(0);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
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
  public void compute(ActorRef src, String assignTo)
  {
    if(n<=0)
    {
      {
        // Normal return
        send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{0}, new int[]{},null);
        return;
      }
    }
    else    if(n<=2)
    {
      {
        // Normal return
        send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{1}, new int[]{},null);
        return;
      }
    }
    else
    {
      salsa.test.Fib fib1 = new salsa.test.Fib(new salsa.test.FibState(n-1));
      salsa.test.Fib fib2 = new salsa.test.Fib(new salsa.test.FibState(n-2));
      Token t1 = send(self/*replyTo*/,fib1/*dest*/,1/*msgId*/,"compute0" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{},new int[]{},null);
      Token t2 = send(self/*replyTo*/,fib2/*dest*/,1/*msgId*/,"compute0" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{},new int[]{},null);
      {
        // Delegate message
        send(src/*replyTo*/,self/*dest*/,2/*msgId*/,"add2" /*msgName*/,assignTo,Message.DELEGATE_TYPE,new Object[]{t1,t2},new int[]{ 0,1},null);
        return;
      }
    }
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void act(ActorRef src, String assignTo, java.lang.String[] args)
  {
    java.lang.String s = args[0];
    int n = Integer.parseInt(s);
    salsa.test.Fib fib = new salsa.test.Fib(new salsa.test.FibState(n));
    Token result = send(self/*replyTo*/,fib/*dest*/,1/*msgId*/,"compute0" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{},new int[]{},null);
    send(self/*replyTo*/,fib/*dest*/,3/*msgId*/,"finish1" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{DeepCopy.copy(result)},new int[]{ 0},null);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {
    if (msgName.equals("finish1")) {
      finish(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgName.equals("add2")) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1]);
      return;
    }
    if (msgName.equals("compute0")) {
      compute(src,assignTo);
      return;
    }
    if (msgName.equals("act1")) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
  public void invokeById(int msgId, Object[] args, ActorRef src, String assignTo) {
    if (msgId == 3) {
      finish(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgId == 2) {
      add(src,assignTo,(Integer)args[0],(Integer)args[1]);
      return;
    }
    if (msgId == 1) {
      compute(src,assignTo);
      return;
    }
    if (msgId == 4) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
}
