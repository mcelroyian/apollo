package local.mcelroyian.apolloscratch.repositories;

import org.springframework.data.repository.CrudRepository;
import local.mcelroyian.apolloscratch.models.User;

public interface UserRepository extends CrudRepository<User, Long> {


}
