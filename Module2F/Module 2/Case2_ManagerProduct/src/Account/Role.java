package Account;

import java.io.Serializable;

public class Role implements Serializable {
    private String role_name;

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

