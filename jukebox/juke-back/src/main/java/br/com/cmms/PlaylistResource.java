package br.com.cmms;

import java.util.List;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.db.UserDatabase;
import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.model.User;
import br.com.cmms.services.PlaylistService;
import br.com.cmms.services.SongService;
import br.com.cmms.services.UserService;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@Path("/jukebox")
public class PlaylistResource {
    
    @Inject
    private PlaylistService playlistService;
    @Inject
    private SongService songService;
    @Inject
    private UserService userService;
    @Inject
    @DataSource("dev")
    AgroalDataSource devDataSource;

    @Path("/dbtest")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Connection conn = null;
        Statement stmt = null;
        try {

            //STEP 1: Open a connection
            System.out.println("Connecting to database...");
            System.out.println("Creating table in given database...");
            conn = devDataSource.getConnection();
            stmt = conn.createStatement();

            //STEP 2: Execute queries
            String sql1 =  "INSERT INTO JUKEBOXTABLE SELECT * FROM (SELECT 100, 'Gianini', 'Huguintico', 22) AS tmp WHERE NOT EXISTS ( SELECT id FROM JUKEBOXTABLE WHERE id = 100 )";
            String sql2 = "select * from JUKEBOXTABLE";

            System.out.println("Inserting records into the table...");
            stmt.executeUpdate(sql1);

            System.out.println("Accessing data in table JUKEBOXTABLE...");
            ResultSet rs=stmt.executeQuery(sql2);
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));

            // STEP 3: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } 
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
        return "Executed queries";
    }

    @GET
    @Path("/playlist")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Playlist> getAllPlaylists() {
        return playlistService.generatePlaylists(userService.generateUsers());
    }

    @GET
    @Path("/playlist/{playlistId}")
    @Produces(MediaType.APPLICATION_JSON)

    public Playlist getPlaylistById(@PathParam("playlistId") int playlistId) {
        return playlistService.generatePlaylists(userService.generateUsers()).get(playlistId);
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)

    public User getUserById(@PathParam("userId") int userId) {
        return UserDatabase.getUsers().get(userId);
    }

    @Path("/user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return UserDatabase.getUsers();
    }

    @GET
    @Path("/song/{playlistId}")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Song> getSongsByPlaylistId(@PathParam("playlistId") int playlistId) {
        return songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId));
    }

    @GET
    @Path("/vote/{playlistId}/{songId}")
    @Produces(MediaType.APPLICATION_JSON)

    public Song voteSongByPlaylistIdandSongId(@PathParam("playlistId") int playlistId, @PathParam("songId") int songId) {
    songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId)).get(songId).vote();
    return songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId)).get(songId);
    }

@GET
@Path("/remove-vote/{playlistId}/{songId}")
@Produces(MediaType.APPLICATION_JSON)

public Song removeVoteSongByPlaylistIdandSongId(@PathParam("playlistId") int playlistId, @PathParam("songId") int songId) {
    songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId)).get(songId).removeVote();
    return songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId)).get(songId);
}
}
