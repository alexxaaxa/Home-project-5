class ReservationSystem {
    private Map<Integer, Boolean> tables;

    public ReservationSystem(int numTables) {
        tables = new HashMap<>();
        for (int i = 1; i <= numTables; i++) {
            tables.put(i, false); // false means table is available
        }
    }

    public void displayAvailableTables() {
        System.out.println("Available Tables:");
        tables.entrySet().stream()
                .filter(entry -> !entry.getValue())
                .map(Map.Entry::getKey)
                .forEach(tableNumber -> System.out.println("Table " + tableNumber));
    }

    public boolean reserveTable(int tableNumber) {
        if (tables.containsKey(tableNumber) && !tables.get(tableNumber)) {
            tables.put(tableNumber, true);
            System.out.println("Table " + tableNumber + " has been reserved.");
            return true;
        } else {
            System.out.println("Table " + tableNumber + " is not available.");
            return false;
        }
    }

    public boolean changeReservationTable(int currentTable, int newTable) {
        if (!tables.containsKey(currentTable) || !tables.containsKey(newTable)) {
            System.out.println("Invalid table numbers.");
            return false;
        }

        if (!tables.get(currentTable) && tables.get(newTable)) {
            tables.put(currentTable, true);
            tables.put(newTable, false);
            System.out.println("Table reservation changed from " + currentTable + " to " + newTable + ".");
            return true;
        } else {
            System.out.println("One of the tables is not available for changing reservation.");
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem(5); // Creating a system with 5 tables
        reservationSystem.reserveTable(3);
        reservationSystem.reserveTable(4);
        reservationSystem.displayAvailableTables();
        reservationSystem.changeReservationTable(3, 1);
        reservationSystem.displayAvailableTables();
    }
}