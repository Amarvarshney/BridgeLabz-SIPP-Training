package linkedlist;

class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Remove process after execution
    public void removeProcess(ProcessNode toRemove) {
        if (head == null || toRemove == null) return;

        if (head == toRemove && head == tail) {
            head = tail = null;
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = tail;
        do {
            if (current == toRemove) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate the round-robin CPU scheduling
    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int processCount = countProcesses();

        ProcessNode current = head;

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                currentTime += execTime;

                // Update waiting and turnaround times
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    System.out.println("Process " + current.processId + " completed.");
                    ProcessNode temp = current.next;
                    removeProcess(current);
                    current = temp;
                    if (head == null) break;
                } else {
                    current = current.next;
                }
            } else {
                current = current.next;
            }

            displayProcesses();
        }

        calculateAverageTimes(processCount);
    }

    // Display processes in queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        ProcessNode current = head;
        System.out.println("\nCurrent Process Queue:");
        do {
            System.out.printf("P%d [Remaining: %d, Burst: %d, Priority: %d]\n",
                    current.processId, current.remainingTime, current.burstTime, current.priority);
            current = current.next;
        } while (current != head);
    }

    // Count total processes
    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // Calculate and display average waiting & turnaround time
    public void calculateAverageTimes(int totalProcesses) {
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        ProcessNode current = head;
        while (current != null) {
            totalWaitingTime += current.waitingTime;
            totalTurnaroundTime += current.turnaroundTime;
            current = current.next;
            if (current == head) break;
        }

        double avgWaiting = totalWaitingTime / totalProcesses;
        double avgTurnaround = totalTurnaroundTime / totalProcesses;

        System.out.printf("\nAverage Waiting Time: %.2f\n", avgWaiting);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaround);
    }

    // Main method to test
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);  // Time Quantum

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.addProcess(4, 8, 3);

        scheduler.simulate();
    }
}
