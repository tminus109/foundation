import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TodoApp {
    static String source = "/Users/t/Documents/green_fox/java/todo_app/assets/todos.txt";

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
        } else if (Objects.equals(args[0], "-l")) {
            List<String> list = readFile(source);
            if (list.isEmpty()) {
                System.out.println("No todos for today! :)");
            } else {
                listTasks(list);
            }
        } else if (Objects.equals(args[0], "-a")) {
            if (args.length < 2) {
                System.out.println("Unable to add - no task provided.");
            } else {
                addNewTask(args[1]);
            }
        } else if (Objects.equals(args[0], "-r")) {
            if (args.length < 2) {
                System.out.println("Unable to remove - no index provided.");
            } else try {
                removeTask(Integer.parseInt(args[1]));
            } catch (NumberFormatException e) {
                System.out.println("Unable to remove - index is not a number.");
            }
        } else if (Objects.equals(args[0], "-c")) {
            if (args.length < 2) {
                System.out.println("Unable to check - no index provided.");
            } else try {
                checkTask(Integer.parseInt(args[1]));
            } catch (NumberFormatException e) {
                System.out.println("Unable to remove - index is not a number.");
            }
        } else {
            System.out.println("Unsupported argument.\n");
            printUsage();
        }
    }

    static void printUsage() {
        System.out.println("""
                Command Line Todo application
                =============================

                Command line arguments:
                -l   Lists all the tasks
                -a   Adds a new task
                -r   Removes a task
                -c   Completes a task
                """);
    }

    static List<String> readFile(String source) {
        Path p = Paths.get(source);
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    static void listTasks(List<String> list) {
        int number = 0;
        for (String s : list) {
            number++;
            String line = number + " - " + s;
            System.out.println(line);
        }
    }

    static void addNewTask(String argument) {
        String newTask = "[ ] " + argument;
        try {
            Files.writeString(Paths.get(source), newTask, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void removeTask(int task) {
        List<String> file = readFile(source);
        if (file.size() < task) {
            System.out.println("Unable to remove - index is out of bound.");
        } else {
            file.remove(task - 1);
            try {
                Files.write(Path.of(source), file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void checkTask(int task) {
        List<String> file = readFile(source);
        if (file.size() < task) {
            System.out.println("Unable to check - index is out of bound.");
        } else {
            file.set(task - 1, file.get(task - 1).replaceFirst(" ", "X"));
            try {
                Files.write(Path.of(source), file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
