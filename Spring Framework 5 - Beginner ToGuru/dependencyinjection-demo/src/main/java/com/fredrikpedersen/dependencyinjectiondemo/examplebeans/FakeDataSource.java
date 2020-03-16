package com.fredrikpedersen.dependencyinjectiondemo.examplebeans;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 18:31
 */

public class FakeDataSource {

    private String user;
    private String password;
    private String url;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
