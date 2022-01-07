import java.util.ArrayList;

public class Process {
    String name;
    ArrayList<Transition> transitions;

    public Process(String Procname) {
        name = Procname;
        transitions = new ArrayList<Transition>();
    }

    public void addTransition(Process end, char action) {
        transitions.add(new Transition(this, end, action));
    }

    public String toString() {
        return this.name;
    }

    /*
    public String toString() {
        String res = "";
        for (Transition t : transitions) {
            res += t.toString() + "\n";
        }
        return res;
    } */
}
