import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAPI {
    @Autowired
    RepositoryAPI repo;

    public ServiceAPI() {
    }

    public ServiceAPI(RepositoryAPI repo) {
        this.repo = repo;
    }

    public List<DogDTO> getPuppies() {
        return repo.getPuppies().stream().map(this::convertDog).toList();
    }

    public DogDTO getPuppy(String id) {
        Dog dog = repo.findPuppy(id);
        return convertDog(dog);
    }

    public DogDTO addPuppy(DogDTO dto) {
        Dog dog = repo.addPuppy(convertDTO(dto));
        return convertDog(dog);
    }

    public DogDTO updatePuppy(DogDTO dto) {
        Dog dog = repo.updatePuppy(convertDTO(dto));
        return convertDog(dog);
    }

    public void deletePuppy(String id) {
        repo.deletePuppy(id);
    }

    private DogDTO convertDog(Dog dog) {
        return new DogDTO(dog.getId(), dog.getName(), dog.getBreed(), dog.getBirthdate());
    }

    private Dog convertDTO(DogDTO dto) {
        return new Dog(dto.id(), dto.name(), dto.breed(), dto.birthdate());
    }
}
