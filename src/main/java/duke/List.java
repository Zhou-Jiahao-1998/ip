package duke;

import java.io.IOException;
import java.util.ArrayList;

public class List extends ArrayList<Task> {
    public static ArrayList<Task> todos;

    public List() {
        todos = new ArrayList<>();
    }

    public List(ArrayList<Task> data) {
        todos = data;
    }

    public void addTask(String input) throws IOException {
        if (input.equals("list")) {
            showList();
        } else {
            try {
                Parser.process(input);
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
}
