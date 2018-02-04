package homifyBackend.homifyBackendService.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Professional {

    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String email;
    private String website;
    private String city;
    private String country;
    private long creationDate;
    private long lastUpdated;
    private Role role;

    private Set<Product> productSet;

    private ProfessionalType professionalType;

	private String header;

	private String latitude;

	private String longtitude;
}
