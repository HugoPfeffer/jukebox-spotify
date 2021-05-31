package br.com.cmms.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cmms.model.User;
import br.com.cmms.repository.UserRepository;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    
    public void insertUser(User user) {
        userRepository.persist(user);
    }

    public void listAllUsers() {
        userRepository.listAll();
    }

    public User listUserById(Long userId) {
        return userRepository.findById(userId);
    }

}
