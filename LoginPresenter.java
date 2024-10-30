public class LoginPresenter {
    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void login() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (validateCredentials(username, password)) {
            view.showSuccess("Login successful!");
        } else {
            view.showError("Invalid credentials. Please try again.");
        }
    }

    private boolean validateCredentials(String username, String password) {
        // Basic validation logic (this could be enhanced)
        return username.equals("admin") && password.equals("password123");
    }
}
