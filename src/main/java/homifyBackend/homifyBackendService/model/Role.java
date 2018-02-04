package homifyBackend.homifyBackendService.model;

public enum Role {
    ADMIN(0), NORMAL(1);

    private long id;

    Role(long id) {
        this.id = id;
    }
}
