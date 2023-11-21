package swaglabs.model;

public enum SwaplabsUser {
    STANDARD_USER("standard_user","secret_sauce");

        public final  String username;
        public final String password;

    SwaplabsUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
