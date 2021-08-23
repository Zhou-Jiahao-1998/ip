package duke;

public class Event extends Task {
    private String time;

    public Event(String name) throws DukeEventException {
        super(name.substring(0, name.indexOf(" /at ") + 1));
        this.time = name.substring(name.indexOf(" /at ") + 5);
        if (name.equals("")) {
            throw  new DukeEventException();
        }
    }

    public Event(String[] input) {
        super(input[2].substring(0, input[1].length() - 1), input[1].equals("T") ? true : false);
        this.time = input[3];
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + this.time + ")";
    }

    @Override
    public String toDataString() {
        return "E|" + super.toDataString() + "|" + this.time;
    }
}
