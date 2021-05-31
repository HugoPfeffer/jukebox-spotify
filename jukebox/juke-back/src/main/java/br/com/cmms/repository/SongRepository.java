package br.com.cmms.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Song;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SongRepository implements PanacheRepository<Song> {

}
