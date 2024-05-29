public class TaskManager {

    public static void main(String[] args) {

        // for the to-do list
        ToDoList toDoList = new ToDoList();

        // for adding tasks
        toDoList.addToDo("Finish homework");
        toDoList.addToDo("Clean room");
        toDoList.addToDo("Do assignment");
        toDoList.addToDo("Study");
        toDoList.addToDo("Watch movie");

        // for Viewing list
        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        // for Marking tasks as completed
        toDoList.markToDoAsCompleted("Clean room");
        toDoList.markToDoAsCompleted("Watch movie");

        // to View updated list
        System.out.println("\nTo-Do List after marking tasks as completed:");
        toDoList.viewToDoList();
    }
}

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    void markAsCompleted() {
        this.isCompleted = true;
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    private Node head;

    ToDoList() {
        this.head = null;
    }

    void addToDo(String title) {
        Task newTask = new Task(title);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void markToDoAsCompleted(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.title.equals(title)) {
                temp.task.markAsCompleted();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found: " + title);
    }

    void viewToDoList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("To-Do List is empty");
            return;
        }
        while (temp != null) {
            System.out.println(temp.task.title + (temp.task.isCompleted ? " (Completed)" : " (Pending)"));
            temp = temp.next;
        }
    }
}
