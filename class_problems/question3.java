package class_problems;
public class question3 {

    // Validates if the file extension is one of the allowed types (pdf, docx, zip)
    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        // Find the index of the last dot
        int lastDotIndex = filename.lastIndexOf('.');

        // Extract extension starting right after the dot
        String extension = filename.substring(lastDotIndex + 1);

        // Check if extension matches allowed list (case-insensitively)
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        // Sample test cases from table
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}