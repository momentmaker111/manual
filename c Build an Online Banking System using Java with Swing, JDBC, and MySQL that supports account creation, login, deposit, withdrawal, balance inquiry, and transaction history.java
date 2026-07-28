System.out.println(success
                ? "Student deleted successfully."
                : "Failed to delete student.");
    } else {
        System.out.println("Deletion cancelled.");
    }
}

// ---------------- Input Helpers ----------------

private static String readString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine().trim();
}

private static int readInt(String prompt) {
    while (true) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid whole number.");
        }
    }
}

private static double readDouble(String prompt) {
    while (true) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}

private static String readOptionalString(String prompt, String currentValue) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();
    return input.isEmpty() ? currentValue : input;
}

private static int readOptionalInt(String prompt, int currentValue) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();

    if (input.isEmpty())
        return currentValue;

    try {
        return Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.out.println("Invalid number, keeping current value.");
        return currentValue;
    }
}

private static double readOptionalDouble(String prompt, double currentValue) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();

    if (input.isEmpty())
        return currentValue;

    try {
        return Double.parseDouble(input);
    } catch (NumberFormatException e) {
        System.out.println("Invalid number, keeping current value.");
        return currentValue;
    }
}
}
