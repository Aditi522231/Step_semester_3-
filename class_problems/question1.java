package class_problems;

// Class defining placement record attributes and methods
class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor initializing all three fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method printing one formatted line
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class question1 {

    public static void main(String[] args) {
        // Create three PlacementRecord objects
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each placement record in a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}