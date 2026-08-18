import java.util.Arrays;

public class PalindromeAnagram {

    // Check palindrome
    public static boolean isPalindrome(String str) {

        // Remove spaces and punctuation
        String cleaned = str.replaceAll("[^A-Za-z0-9]", "");

        // Convert to lowercase
        cleaned = cleaned.toLowerCase();

        String reversed = new StringBuilder(cleaned)
                .reverse()
                .toString();

        return cleaned.equals(reversed);
    }

    // Check anagram
    public static boolean isAnagram(String str1, String str2) {

        String s1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        String str1 = "A man a plan a canal Panama";
        String str2 = "listen";
        String str3 = "silent";

        // Palindrome
        boolean palindrome = isPalindrome(str1);

        // Anagram
        boolean anagram = isAnagram(str2, str3);

        // Cleaned string
        String cleaned = str1.replaceAll("[^A-Za-z0-9]", "");

        // Regex validation
        boolean valid = cleaned.matches("[A-Za-z0-9]+");

        // Contains "plan"
        boolean containsPlan = str1.toLowerCase().contains("plan");

        // String formatting
        String report = String.format(
                "Palindrome : %b | Anagram : %b",
                palindrome,
                anagram
        );

        // String.join()
        String finalReport = String.join(
                "\n",
                "Palindrome Check : \"" + str1 + "\" -> " + palindrome,
                "Anagram Check : \"" + str2 + "\" & \"" + str3 + "\" -> " + anagram,
                "Formatted Report : [ " + report + " ]",
                "Contains 'plan' : " + containsPlan,
                "Alphanumeric Validation : " + valid
        );

        System.out.println(finalReport);

        // Demonstrate intern()
        String x = new String("Java");
        String y = new String("Java");

        boolean beforeIntern = (x == y);

        x = x.intern();
        y = y.intern();

        boolean afterIntern = (x == y);

        System.out.println();
        System.out.println("Before intern(), == : " + beforeIntern);
        System.out.println("After intern(), == : " + afterIntern);

        // hashCode()
        System.out.println(
                "HashCodes equal for interned strings : "
                        + (x.hashCode() == y.hashCode())
        );
    }
}