package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cmms.model.User;
import br.com.cmms.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    
    public void insertUser(User user) {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        userRepository.persist(user);
    }

    public List<User> listAllUsers() {
        return userRepository.listAll();
    }

    public User listUserById(Long userId) {
        return userRepository.findById(userId);
    }

}
