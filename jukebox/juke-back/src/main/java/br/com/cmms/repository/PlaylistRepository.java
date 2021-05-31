package br.com.cmms.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PlaylistRepository implements PanacheRepository<Playlist> {

}
