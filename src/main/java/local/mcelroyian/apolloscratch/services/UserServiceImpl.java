package local.mcelroyian.apolloscratch.services;

import local.mcelroyian.apolloscratch.models.User;
import local.mcelroyian.apolloscratch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Transactional
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
