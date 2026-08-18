public class StringAnalyzer {

    public static void main(String[] args) {

        String sentence = "Java is fun and Java is powerful";
        char target = 'J';

        // 1. Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        int wordCount = words.length;

        // 2. First and last word
        String firstWord = words[0];

        // substring() demonstration
        int lastSpace = sentence.lastIndexOf(" ");
        String lastWord = sentence.substring(lastSpace + 1);

        // 3. First and last occurrence of J
        int firstIndex = sentence.indexOf(target);
        int lastIndex = sentence.lastIndexOf(target);

        // 4. Lexicographic comparison
        int comparison = firstWord.compareTo(lastWord);

        // 5. Convert sentence to character array
        char[] characters = sentence.toCharArray();

        // First character
        char firstCharacter = characters[0];

        // ASCII value
        int asciiValue = (int) firstCharacter;

        // String.valueOf() demonstration
        String asciiString = String.valueOf(asciiValue);

        System.out.println("Word Count : " + wordCount);
        System.out.println("First Word : " + firstWord);
        System.out.println("Last Word : " + lastWord);
        System.out.println("First 'J' index : " + firstIndex);
        System.out.println("Last 'J' index : " + lastIndex);
        System.out.println("Comparison (first vs last word) : " + comparison);
        System.out.println("First Character : " + firstCharacter);
        System.out.println("ASCII Value : " + asciiString);
    }
}