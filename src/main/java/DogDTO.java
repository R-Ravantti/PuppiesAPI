import com.fasterxml.jackson.annotation.JsonProperty;

public record DogDTO(@JsonProperty String id, @JsonProperty String name,
                     @JsonProperty String breed, @JsonProperty String birthdate) {
}
