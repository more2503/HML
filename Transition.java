public class Transition {
    Process start, end;
    char action;

    public Transition(Process start, Process end, char action) {
        this.start = start;
        this.end = end;
        this.action = action;
    }

    public String toString() {
        return this.start.name + " --" + this.action + "--> " + this.end.name;
    }
}
