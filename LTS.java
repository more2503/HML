import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LTS {
    HashSet<Process> processes;

    public LTS(HashSet<Process> processes) {
        this.processes = processes;
    }

    public HashSet<Process> forAll(HashSet<Process> set, char action) {
        HashSet<Process> a = (HashSet)this.processes.clone();

        for (Process p : processes) {
            for (Transition t : p.transitions) {
                if (t.action == action) {
                    if (!set.contains(t.end))
                        a.remove(p);
                }
            }
        }

        return a;
    }

    public HashSet<Process> exists(HashSet<Process> set, char action) {
        HashSet<Process> a = new HashSet<>();

        for (Process p : processes) {
            for (Transition t : p.transitions) {
                if (t.action == action) {
                    if (set.contains(t.end))
                        a.add(p);
                }
            }
        }

        return a;
    }

    public HashSet<Process> and(HashSet<Process> set1, HashSet<Process> set2) {
        HashSet<Process> out = (HashSet)set1.clone();
        out.retainAll(set2);
        return out;
    }

    public HashSet<Process> or(HashSet<Process> set1, HashSet<Process> set2) {
        HashSet<Process> out = (HashSet)set1.clone();
        out.addAll(set2);
        return out;
    }

    public HashSet<Process> c(HashSet<Process> set) {
        HashSet<Process> out = (HashSet)processes.clone();
        out.removeAll(set);
        return out;
    }
}
