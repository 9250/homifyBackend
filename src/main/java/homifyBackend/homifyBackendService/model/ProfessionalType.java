package homifyBackend.homifyBackendService.model;

public enum ProfessionalType {
    A(1),B(2),C(3),D(4);

    private long id;

    ProfessionalType(long id) {
        this.id = id;
    }
}
