package Product;

import java.io.Serializable;

public class Size implements Serializable {
    private String size;

    public Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
