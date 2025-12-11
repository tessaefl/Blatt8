package h2;

public class SimpleList {
    private Node head;

    public SimpleList() {
        // Der Kopfknoten speichert den Dummy-Wert Integer.MIN_VALUE
        this.head = new Node(Integer.MIN_VALUE);
    }

    public Node getFirst() {
        return head.next;
    }

    public Node getLast() {
        Node current = head;
        // Durchläuft die Liste bis zum letzten Knoten (dessen next == null ist)
        while (current.next != null) {
            current = current.next;
        }

        // Wenn current immer noch head ist, ist die Liste leer
        if (current == head) {
            return null;
        }
        return current;
    }

    public void append(int newValue) {
        Node newNode = new Node(newValue);
        Node last = head;

        // Sucht den aktuell letzten Knoten
        while (last.next != null) {
            last = last.next;
        }
        // Hängt den neuen Knoten an
        last.next = newNode;
    }

    public Node findFirst(int value) {
        // Startet die Suche nach dem ersten Datenknoten
        Node current = head.next;

        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean insertAfter(int preValue, int newValue) {
        Node predecessor = findFirst(preValue);

        if (predecessor != null) {
            Node newNode = new Node(newValue);

            // 1. Neuer Knoten übernimmt den Nachfolger des Vorgängers
            newNode.next = predecessor.next;
            // 2. Vorgänger zeigt nun auf den neuen Knoten
            predecessor.next = newNode;
            return true;
        }
        return false;
    }

    public boolean delete(int value) {
        // Beginnt beim Kopf, um Zugriff auf den Vorgänger des zu löschenden Knotens zu
        // haben
        Node current = head;

        while (current.next != null) {
            if (current.next.value == value) {
                // Umbiegen des Zeigers: Der Vorgänger zeigt nun auf den Nachfolger des
                // Nachfolgers
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
