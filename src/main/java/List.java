import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class List extends ArrayList<Task> {
    public static ArrayList<Task> todos;

    public List() {
        todos = new ArrayList<>();
    }

    public void addTask(String input) {
        if (input.equals("list")) {
            showList();
        } else {
            try {
                process(input);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showList() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println(i + 1 + ". " + todos.get(i).toString());
        }
    }

    public void done(String[] array) throws DukeDoneException {
        if (array.length == 1) {
            throw new DukeDoneException();
        }
        int index = parseInt(array[1]);
        Task temp = todos.get(index - 1);
        temp.markAsDone();
        System.out.println("Nice! I've marked this task as done:\n" + temp);
    }

    public void delete(String[] array) {
        int index = parseInt(array[1]);
        Task temp = todos.remove(index - 1);
        System.out.println("Noted. I've removed this task:\n"
                + temp
                + "\nNow you have "
                + todos.size()
                + " task"
                + (todos.size() == 1 ? "" : "s")
                + " in the list");

    }

    public void process(String input) throws DukeException {
        String[] split = input.split(" ", 2);
        if (split[0].equals("done")) {
            done(split);
        } else if (split[0].equals("delete")) {
            delete(split);
        } else if (split[0].equals("todo")) {
            if (split.length == 1) {
                throw new DukeTodoException();
            }
            Task newItem = new Todo(split[1]);
            todos.add(newItem);
            echo(newItem);
        } else if (split[0].equals("deadline")) {
            if (split.length == 1) {
                throw new DukeDeadlineException();
            }
            Task newItem = new Deadline(split[1]);
            todos.add(newItem);
            echo(newItem);
        } else if (split[0].equals("event")) {
            if (split.length == 1) {
                throw new DukeEventException();
            }
            Task newItem = new Event(split[1]);
            todos.add(newItem);
            echo(newItem);
        } else {
            throw new DukeException();
        }
    }

    public void echo(Task item) {
        System.out.println("Got it. I've added this task:\n"
                + item
                + "\nNow you have "
                + todos.size()
                + " task"
                + (todos.size() == 1 ? "" : "s")
                + " in the list"); // will take care of when it is 1
    }

    public void echo(String input) {
        System.out.println(input);
    }
}
