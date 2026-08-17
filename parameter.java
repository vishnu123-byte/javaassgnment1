class ParameterExample {

    // Method with parameters
    static void addNumbers(int a, int b) {
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        // Passing values (arguments) to the parameters
        addNumbers(10, 20);
        addNumbers(5, 15);
    }
}
