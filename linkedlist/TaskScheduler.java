package linkedlist;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {
    private TaskNode head = null;
    private TaskNode current = null;

    // Add task at beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode tail = getTail();
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Add task at end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode tail = getTail();
            tail.next = newNode;
            newNode.next = head;
        }
    }

    // Add task at specific position (1-based)
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove task by task ID
    public void removeById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head, prev = null;

        // Special case: deleting head
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
                current = null;
            } else {
                TaskNode tail = getTail();
                head = head.next;
                tail.next = head;
                if (current.taskId == taskId) current = head;
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.taskId == taskId) {
                prev.next = temp.next;
                if (current == temp) current = temp.next;
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
        } while (temp != head);

        System.out.println("Task ID not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current != null) {
            printTask(current);
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            System.out.println("Moved to next task:");
            viewCurrentTask();
        } else {
            System.out.println("No tasks to move.");
        }
    }

    // Display all tasks from head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        System.out.println("Task List:");
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Utility: Get tail (last node)
    private TaskNode getTail() {
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp;
    }

    // Utility: Print task info
    private void printTask(TaskNode task) {
        System.out.println("ID: " + task.taskId +
                           ", Name: " + task.taskName +
                           ", Priority: " + task.priority +
                           ", Due Date: " + task.dueDate);
    }

    // Main method to test
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Task A", 2, "2025-07-20");
        scheduler.addAtBeginning(2, "Task B", 1, "2025-07-15");
        scheduler.addAtPosition(3, "Task C", 3, "2025-07-25", 2);

        scheduler.displayAllTasks();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();

        scheduler.searchByPriority(2);

        scheduler.removeById(2);
        scheduler.displayAllTasks();
    }
}

