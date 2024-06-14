class Button extends Component {
    private String tooltipText;

    public void setTooltipText(String tooltipText) {
        this.tooltipText = tooltipText;
    }

    @Override
    public void showHelp() {
        if (tooltipText != null) {
            System.out.println("Tooltip: " + tooltipText);
        } else {
            super.showHelp();
        }
    }
}