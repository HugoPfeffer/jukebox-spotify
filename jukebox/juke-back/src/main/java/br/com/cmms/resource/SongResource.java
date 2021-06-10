package br.com.cmms.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.cmms.model.Song;
import br.com.cmms.services.SongService;

@Path("/song")
@Tag(name = "Song")
public class SongResource {

    @Inject
    SongService songService;


    // List all Songs
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> listAllSongs(){
       return songService.listAllSongs();
    }

    // List Song by ID
    @GET
    @Path("{songId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getSongById(@PathParam("songId") Long songId) {
        return songService.listSongById(songId);
    }

    // Insert new Song
    @POST
    @RolesAllowed("admin")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertSong(Song song){
        songService.insertSong(song);
    }

}
