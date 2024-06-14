public class Client {
    public static void main(String[] args) {
        DialogBox dialogBox = new DialogBox();
        dialogBox.setModalHelpText("This is modal help for the dialog box");
        dialogBox.showHelp();

        Panel panel = new Panel();

        panel.add(new Component());
        panel.add(new Component());

        panel.setWikiPageURL("https://example.com");

        panel.showHelp();
    }
}
