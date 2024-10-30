public class Main {
    public static void main(String[] args) {
        ILoginView view = new ConsoleLoginView();
        LoginPresenter presenter = new LoginPresenter(view);
        presenter.login();
    }
}
