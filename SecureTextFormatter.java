public class SecureTextFormatter {

    // Convert full name to Title Case
    public static String titleCase(String name) {

        name = name.trim().toLowerCase();

        String[] words = name.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            if (word.length() > 0) {
                String first = word.substring(0, 1).toUpperCase();
                String remaining = word.substring(1);

                result.append(first)
                      .append(remaining)
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    // Mask email
    public static String maskEmail(String email) {

        email = email.trim();

        int atIndex = email.indexOf("@");

        if (atIndex == -1) {
            return "Invalid Email";
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex);

        if (username.length() <= 3) {
            return username + "*****" + domain;
        }

        String visible = username.substring(0, 3);

        String masked = "*".repeat(username.length() - 3);

        return visible + masked + domain;
    }

    // Validate email
    public static boolean isValidEmail(String email) {

        return email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }

    // Reverse every word
    public static String reverseWords(String sentence) {

        String[] words = sentence.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            String reversed = new StringBuilder(word)
                    .reverse()
                    .toString();

            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }

    // Count vowels
    public static int countVowels(String sentence) {

        int count = 0;

        char[] characters = sentence.toLowerCase().toCharArray();

        for (char c : characters) {

            if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String fullName = " john WICK ";
        String email = "john.wick@example.com";
        String sentence = "Hello World From Java";

        // isBlank() demonstration
        System.out.println("Is name blank : " + fullName.isBlank());

        // Title Case
        String formattedName = titleCase(fullName);

        // Mask email
        String maskedEmail = maskEmail(email);

        // Validate email
        boolean validEmail = isValidEmail(email);

        // Reverse words
        String reversedWords = reverseWords(sentence);

        // Count vowels
        int vowelCount = countVowels(sentence);

        System.out.println("Formatted Name : " + formattedName);
        System.out.println("Masked Email : " + maskedEmail);
        System.out.println("Valid Email : " + validEmail);
        System.out.println("Reversed Words : " + reversedWords);
        System.out.println("Vowel Count : " + vowelCount);

        // Demonstrate == and equals()
        String a = new String("Java");
        String b = new String("Java");

        System.out.println();
        System.out.println("Using == : " + (a == b));
        System.out.println("Using equals() : " + a.equals(b));
    }
}