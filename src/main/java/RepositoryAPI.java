import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepositoryAPI {

    private final Map<String, Dog> puppyStorage;

    public RepositoryAPI() {
        puppyStorage = new HashMap<String, Dog>();
        puppyStorage.put("1", new Dog("1", "Big", "Great Dane", "2023-01-01"));
        puppyStorage.put("2", new Dog("2", "Small", "Chihuahua", "2023-01-01"));
    }

    public List<Dog> getPuppies() {
        return puppyStorage.values().stream().toList();
    }

    public Dog findPuppy(String id) {
        return puppyStorage.get(id);
    }

    public Dog addPuppy(Dog dog) {
        puppyStorage.put(dog.getId(), dog);
        return dog;
    }

    public Dog updatePuppy(Dog dog) {
        puppyStorage.replace(dog.getId(), dog);
        return dog;
    }

    public void deletePuppy(String id) {
        puppyStorage.remove(id);
    }
}
