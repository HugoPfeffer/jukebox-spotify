package br.com.cmms.services;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.db.userDatabase;
import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.model.User;

@ApplicationScoped
public class UserService {

    public User generateUsers() {
        User ggianini = new User();
        ggianini.setId(1L);
        ggianini.setName("Gustavo Gianini");
        ggianini.setEmail("ggianini@gmail.com");
        Playlist mpb = new Playlist();
        mpb.setId(1L);
        mpb.setName("mpb");
        Playlist rock = new Playlist();
        rock.setId(1L);
        rock.setName("rock");
        ggianini.getPlaylists().add(mpb);
        ggianini.getPlaylists().add(rock);
        userDatabase.getUsers().add(ggianini);
        Song aguasdemarco = new Song();
        aguasdemarco.setId(1L);
        aguasdemarco.setName("Águas de Março");
        aguasdemarco.setAuthor("Elis Regina");
        aguasdemarco.setDuration(123);
        Song omundoeummoinho = new Song();
        omundoeummoinho.setId(2L);
        omundoeummoinho.setName("O mundo é um Moinho");
        omundoeummoinho.setAuthor("Cartola");
        omundoeummoinho.setDuration(112);
        Song hatempos = new Song();
        hatempos.setId(3L);
        hatempos.setName("Há Tempos");
        hatempos.setAuthor("Legião Urbana");
        hatempos.setDuration(137);
        Song epitafio = new Song();
        epitafio.setId(4L);
        epitafio.setName("Epitáfio");
        epitafio.setAuthor("Titãs");
        epitafio.setDuration(105);
        ggianini.getPlaylists().get(0).getSongs().add(aguasdemarco);
        ggianini.getPlaylists().get(0).getSongs().add(omundoeummoinho);
        ggianini.getPlaylists().get(1).getSongs().add(hatempos);
        ggianini.getPlaylists().get(1).getSongs().add(epitafio);
        return ggianini;
    }

}
