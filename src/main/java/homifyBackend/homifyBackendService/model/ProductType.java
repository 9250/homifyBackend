package homifyBackend.homifyBackendService.model;

public enum ProductType {
    ENGINEERING(1), MARKETING(2);

    private long id;

    ProductType(long id) {
        this.id = id;
    }
}
