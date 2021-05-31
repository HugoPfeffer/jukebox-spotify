package br.com.cmms.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User>{
    
}
