import java.util.Scanner;

public class ConsoleLoginView implements ILoginView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    @Override
    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }
}
