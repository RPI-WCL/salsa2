package salsa.test;

import java.lang.System;
import java.lang.Integer;
import salsa.lang.*;
import salsa.lang.fullcopy.DeepCopy;
import java.util.*;

class ThreadRingState extends ActorState {
  salsa.test.ThreadRing next;
  int id;
  public ThreadRingState(int id)
  {
    this.id=id;
  }
  public ThreadRingState() {}
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void forwardMessage(ActorRef src, String assignTo, int value)
  {
    if(value==0)
    {
      System.out.println(id);
      System.exit(0);
    }
    else
    {
      value--;
      send(self/*replyTo*/,next/*dest*/,2/*msgId*/,"forwardMessage1" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{value},new int[]{},null);
    }
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void setNextThread(ActorRef src, String assignTo, salsa.test.ThreadRing next)
  {
    this.next=next;
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void act(ActorRef src, String assignTo, java.lang.String[] args)
  {
    if(args.length!=2)
    {
      System.out.println("Usage: java ThreadRing <threadCount> <hopCount> ");
      System.exit(0);
    }
    int threadCount = Integer.parseInt(args[0]);
    int hopCount = Integer.parseInt(args[1]);
    salsa.test.ThreadRing first = new salsa.test.ThreadRing(new salsa.test.ThreadRingState(0));
    salsa.test.ThreadRing previous = first;

    // begin joinblock
    List _tokenList = new ArrayList();
    {
      for (int i = 1;i<threadCount;i++)
      {
        salsa.test.ThreadRing next = new salsa.test.ThreadRing(new salsa.test.ThreadRingState(i));
        token = send(self/*replyTo*/,previous/*dest*/,1/*msgId*/,"setNextThread1" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{next},new int[]{},null);
        _tokenList.add(token);
        previous=next;
      }
    }
    Object[] _tokens = _tokenList.toArray();
    token = send(self,self,-1,"joinHelper","",Message.NORMAL_TYPE,_tokens,null,null);
    // end joinblock

    token = send(self/*replyTo*/,previous/*dest*/,1/*msgId*/,"setNextThread1" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{first},new int[]{},token);
    send(self/*replyTo*/,first/*dest*/,2/*msgId*/,"forwardMessage1" /*msgName*/,"",Message.NORMAL_TYPE,new Object[]{hopCount},new int[]{},token);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {
    if (msgName.equals("forwardMessage1")) {
      forwardMessage(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgName.equals("setNextThread1")) {
      setNextThread(src,assignTo,(salsa.test.ThreadRing)args[0]);
      return;
    }
    if (msgName.equals("act1")) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
  public void invokeById(int msgId, Object[] args, ActorRef src, String assignTo) {
    if (msgId == 2) {
      forwardMessage(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgId == 1) {
      setNextThread(src,assignTo,(salsa.test.ThreadRing)args[0]);
      return;
    }
    if (msgId == 3) {
      act(src,assignTo,Arrays.copyOf(((Object[])args[0]), ((Object[])args[0]).length, java.lang.String[].class));
      return;
    }
  }
}
