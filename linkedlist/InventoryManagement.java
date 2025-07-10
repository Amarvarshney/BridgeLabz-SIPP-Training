package linkedlist;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private ItemNode head;

    // Add item at beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Add item at specific position (1-based)
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode temp = head;
        int index = 1;

        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item by Item ID
    public void removeById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        } else {
            System.out.println("Item ID not found.");
        }
    }

    // Update quantity
    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by Item ID
    public void searchById(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                printItem(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found with ID " + itemId);
    }

    // Search by Item Name
    public void searchByName(String name) {
        ItemNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(name)) {
                printItem(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("Item not found with name " + name);
    }

    // Calculate total value of inventory
    public void calculateTotalValue() {
        double total = 0.0;
        ItemNode current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        System.out.printf("Total Inventory Value: $%.2f\n", total);
    }

    // Display all items
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode current = head;
        while (current != null) {
            printItem(current);
            current = current.next;
        }
    }

    // Sort by item name or price (ascending/descending)
    public void sortInventory(String field, boolean ascending) {
        head = mergeSort(head, field.toLowerCase(), ascending);
        System.out.println("Inventory sorted by " + field + " (" + (ascending ? "asc" : "desc") + ")");
    }

    private ItemNode mergeSort(ItemNode head, String field, boolean ascending) {
        if (head == null || head.next == null) return head;

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, field, ascending);
        ItemNode right = mergeSort(nextOfMiddle, field, ascending);

        return sortedMerge(left, right, field, ascending);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, String field, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean comparison;
        if (field.equals("price")) {
            comparison = ascending ? (a.price <= b.price) : (a.price > b.price);
        } else { // itemName
            comparison = ascending ? (a.itemName.compareToIgnoreCase(b.itemName) <= 0)
                                   : (a.itemName.compareToIgnoreCase(b.itemName) > 0);
        }

        if (comparison) {
            a.next = sortedMerge(a.next, b, field, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, field, ascending);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;

        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printItem(ItemNode item) {
        System.out.printf("ID: %d | Name: %s | Qty: %d | Price: $%.2f\n",
                item.itemId, item.itemName, item.quantity, item.price);
    }

    // Main to test the functionalities
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtEnd("Laptop", 101, 5, 999.99);
        inventory.addAtBeginning("Mouse", 102, 20, 19.99);
        inventory.addAtEnd("Keyboard", 103, 15, 49.99);
        inventory.addAtPosition("Monitor", 104, 10, 199.99, 2);

        inventory.displayInventory();
        inventory.updateQuantity(103, 18);
        inventory.searchByName("monitor");
        inventory.searchById(105);

        inventory.calculateTotalValue();
        inventory.sortInventory("Price", true);
        inventory.displayInventory();

        inventory.removeById(101);
        inventory.displayInventory();
    }
}
