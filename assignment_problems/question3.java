package assignment_problems;
public class question3 {

    // Parses a CSV record and prints formatted inventory output or validation error
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the CSV string by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Extract and trim fields to format output
            String productName = fields[0].trim();
            String sku = fields[1].trim();
            String quantity = fields[2].trim();

            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
        }
    }

    public static void main(String[] args) {
        // Sample test cases from table
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
