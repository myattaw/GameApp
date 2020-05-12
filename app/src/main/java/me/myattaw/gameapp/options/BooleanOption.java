package me.myattaw.gameapp.options;

public enum BooleanOption {

    SHOW_DEBUG("Show Debug", true),
    SHOW_FPS("Show Game FPS", false);

    private String label;
    private boolean enable;

    BooleanOption(String label, boolean enable) {
        this.label = label;
        this.enable = enable;
    }

    public String getLabel() {
        return label;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}
