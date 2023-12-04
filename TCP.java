package Fsm;
import java.util.Scanner;

public class TCP {
    class FSM { 
        String fsmName;
        State starState;
        State curState;
        boolean trace;

        FSM(){}
        FSM(String fsmName) {
            this.fsmName = fsmName;
        }
        FSM(String fsmName, State start) {
            this.fsmName = fsmName;
            starState = start;
        }
        void addTransition(Transition t) {}
        State currentState() {
            return curState;
        }
        void doEvent(Event e) {}
        void nextState(State s) {
            curState = s;
        }
        void reset() {
            curState = starState;
        }
        void traceOff() {
            trace = false;
        }
        void traceOn() {
            trace = true;
        }
    }

    public static enum States {
        CLOSED,
        LISTEN,
        ESTABLISHED,
        SYN_SENT,
        SYN_RCVD,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSING,
        TIME_WAIT,
        CLOSE_WAIT,
        LAST_ACK
    }
    
    public static enum Input {
        PASSIVE,
        ACTIVE,
        SYN,
        SYNACK,
        ACK,
        RDATA,
        SDATA,
        FIN,
        CLOSE,
        TIMEOUT
    }
    
    class Event {
        // Data members
        public String event_name;
        public Object object;

       
        // Constructor
        public Event(String name) {
            event_name = name;
        }  
        public Event(String name, Object obj) {
            event_name = name;
            object = obj;
        }
        public String getName() {
            return event_name;
        }
        public Object getValue() {
            return this.object;
        }
        public void setValue(Object o) {
            object = o;
        }
        public String toString() {
            // Return a String representing the state of the Event Object.
            // Overrides: toString in class java.lang.Object
        }
    }

    abstract class Action {
        public Action() {}
        public void execute(FSM f, Event e) {
            // This method is invoked whenever the corresponding transition occurs. 
            // You may access the FSM to get current State and then 
            // retrieve any persistent information associated with that State.
            f.doEvent(e);
        }
    }
}

class State {

}



class Transition {

}

// abstract class Action {
//     public abstract void execute(FSM f, Event e) {
//         Action action = 
//     }
// }

class FsmException extends Exception {
    
}