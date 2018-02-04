package homifyBackend.homifyBackendService.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Product {

    private long id;

    private Set<Professional> professional = new HashSet<>();

    private ProductType productType;

    private String header;

    private String title;

    private String description;

    private long startDate;

    private long endDate;
}
