package salsa.lib;

import java.lang.System;
import salsa.wwc.lang.*;
import salsa.wwc.lang.fullcopy.DeepCopy;
import java.util.*;

public class StandardOutputState extends ActorState {
  public StandardOutputState() {}
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, java.lang.String s)
  {
    System.out.print(s);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, java.lang.Object p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, boolean p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, char p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, int p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, long p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, float p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void print(ActorRef src, String assignTo, double p)
  {
    System.out.print(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, java.lang.String s)
  {
    System.out.println(s);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, java.lang.Object p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, boolean p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, char p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, int p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, long p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, float p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo, double p)
  {
    System.out.println(p);
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void println(ActorRef src, String assignTo)
  {
    System.out.println();
    // A tricky fix: add an echo message for void message.
    send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, new int[]{},null);
  }

  public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {
    if (msgName.equals("print1")) {
      print(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(java.lang.Object)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Boolean)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Character)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Long)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Float)args[0]);
      return;
    }
    if (msgName.equals("print1")) {
      print(src,assignTo,(Double)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(java.lang.Object)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Boolean)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Character)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Long)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Float)args[0]);
      return;
    }
    if (msgName.equals("println1")) {
      println(src,assignTo,(Double)args[0]);
      return;
    }
    if (msgName.equals("println0")) {
      println(src,assignTo);
      return;
    }
  }
  public void invokeById(int msgId, Object[] args, ActorRef src, String assignTo) {
    if (msgId == -1743835991) {
      print(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgId == -1521725637) {
      print(src,assignTo,(java.lang.Object)args[0]);
      return;
    }
    if (msgId == 2098032924) {
      print(src,assignTo,(Boolean)args[0]);
      return;
    }
    if (msgId == -1580339880) {
      print(src,assignTo,(Character)args[0]);
      return;
    }
    if (msgId == 87753653) {
      print(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgId == -1571807502) {
      print(src,assignTo,(Long)args[0]);
      return;
    }
    if (msgId == -1655911384) {
      print(src,assignTo,(Float)args[0]);
      return;
    }
    if (msgId == -1477200131) {
      print(src,assignTo,(Double)args[0]);
      return;
    }
    if (msgId == 1841362539) {
      println(src,assignTo,(java.lang.String)args[0]);
      return;
    }
    if (msgId == 2063472893) {
      println(src,assignTo,(java.lang.Object)args[0]);
      return;
    }
    if (msgId == -1164491494) {
      println(src,assignTo,(Boolean)args[0]);
      return;
    }
    if (msgId == -694236646) {
      println(src,assignTo,(Character)args[0]);
      return;
    }
    if (msgId == -1269135693) {
      println(src,assignTo,(Integer)args[0]);
      return;
    }
    if (msgId == -685704268) {
      println(src,assignTo,(Long)args[0]);
      return;
    }
    if (msgId == 43485094) {
      println(src,assignTo,(Float)args[0]);
      return;
    }
    if (msgId == -335516865) {
      println(src,assignTo,(Double)args[0]);
      return;
    }
    if (msgId == -1796256208) {
      println(src,assignTo);
      return;
    }
  }
}
