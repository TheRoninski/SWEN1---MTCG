package at.ron.mtcg.model;
import com.fasterxml.jackson.annotation.JsonProperty;




public class Users {
    @JsonProperty("Username")
    private String username;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("Token")
    private String token;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users(UserCredentials credentials) {
        username = credentials.username;
        password = credentials.password;
    }
}
