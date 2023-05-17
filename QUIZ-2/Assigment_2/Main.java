class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Insufficient arguments provided.");
            System.out.println("Usage: java Application <name> <age>");
            return;
        }
        String name = args[0];
        Integer age = 0;
        try {
            age = parseAge(args[1]);
            validateAge(age);
            System.out.println("Name of the person: " + name);
            System.out.println("Age of the person: " + age);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid value. Age must be a valid integer.");
        } catch (InvalidAgeException e) {
            System.out.println("Error has been occurred: " + e.getMessage());
        }
    }
    private static int parseAge(String arg) throws NumberFormatException {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid age value. Age must be a valid integer.");
        }
    }
    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age >= 60) {
            throw new InvalidAgeException("Age which entered must be between 18 and 60");
        }
    }
}
