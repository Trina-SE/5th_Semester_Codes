class Component implements ComponentWithContextualHelp {
    private Container container;

    public void setContainer(Container container) {
        this.container = container;
    }

    public void showHelp() {
        if (container != null) {
            container.showHelp();
        } else {
            System.out.println("No contextual help available.");
        }
    }
}