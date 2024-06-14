class DialogBox extends Container {
    private String modalHelpText;

    public void setModalHelpText(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            // Show modal window with help text
            System.out.println("Modal help: " + modalHelpText);
        } else {
            super.showHelp(); 
        }
    }
}