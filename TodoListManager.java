import java.util.ArrayList;
import java.util.Scanner;

public class TodoListManager{

    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<Boolean> completed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=============================");
        System.out.println("   To-Do List Manager (Java) ");
        System.out.println("=============================");

        do {
            System.out.println("\n1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask(sc);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markComplete(sc);
                    break;
                case 4:
                    deleteTask(sc);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void addTask(Scanner sc) {
        System.out.print("Enter task: ");
        String task = sc.nextLine();
        tasks.add(task);
        completed.add(false);
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }
        System.out.println("\n--- Your Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            String status = completed.get(i) ? "[✓]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
        }
    }

    static void markComplete(Scanner sc) {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to mark complete: ");
        int num = sc.nextInt();
        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number!");
        } else if (completed.get(num - 1)) {
            System.out.println("Task already completed!");
        } else {
            completed.set(num - 1, true);
            System.out.println("Task marked as complete!");
        }
    }

    static void deleteTask(Scanner sc) {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();
        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number!");
        } else {
            System.out.println("Task \"" + tasks.get(num - 1) + "\" deleted!");
            tasks.remove(num - 1);
            completed.remove(num - 1);
        }
    }
}