public class TextNormalizer {

    public static String processText(String input) {

        // 1. Remove leading/trailing whitespace
        String cleaned = input.trim();

        // Demonstrating strip()
        cleaned = cleaned.strip();

        // 2. Check if empty
        if (cleaned.isEmpty()) {
            return "EMPTY STRING";
        }

        // 3. Check for reserved word
        if (cleaned.equalsIgnoreCase("admin")) {
            return "RESERVED WORD";
        }

        // 4. Replace underscore with space
        // Example: temp_John_user -> temp John user
        String result = cleaned.replace("_", " ");

        // 5. Check startsWith and endsWith
        String lower = result.toLowerCase();

        if (lower.startsWith("temp") && lower.endsWith("user")) {
            result = result.concat(" FLAGGED");
        }

        // 6. Return final string
        return result;
    }

    public static void main(String[] args) {

        String input1 = " temp_John_user ";
        String input2 = " ADMIN ";
        String input3 = " ";

        System.out.println("Input  : " + input1);
        System.out.println("Output : " + processText(input1));

        System.out.println();

        System.out.println("Input  : " + input2);
        System.out.println("Output : " + processText(input2));

        System.out.println();

        System.out.println("Input  : " + input3);
        System.out.println("Output : " + processText(input3));

        // equals() demonstration
        String a = "admin";
        String b = "admin";

        System.out.println("\nequals() : " + a.equals(b));
    }
}