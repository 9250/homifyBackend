package homifyBackend.homifyBackendService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private long id;

    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String phone;
    protected String email;
    protected String website;
    protected String city;
    protected String country;
    protected long creationDate;
    protected long lastUpdated;
    protected Role role;

    public User() {
    }
}
