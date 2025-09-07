package optional.model;

public class Delivery {
    private String status;
    private boolean canceld;

    public Delivery(String status, boolean canceld) {
        this.status = status;
        this.canceld = canceld;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCanceld() {
        return canceld;
    }
}
