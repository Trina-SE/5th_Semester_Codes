class Panel extends Container {
    private String modalHelpText;
    private String wikiPageURL;

    public void setModalHelpText(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    public void setWikiPageURL(String wikiPageURL) {
        this.wikiPageURL = wikiPageURL;
    }

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            // Show modal window with help text
            System.out.println("Modal help: " + modalHelpText);
        } else if (wikiPageURL != null) {
            // Open a wiki page
            System.out.println("Open wiki page: " + wikiPageURL);
        } else {
            super.showHelp();
        }
    }
}