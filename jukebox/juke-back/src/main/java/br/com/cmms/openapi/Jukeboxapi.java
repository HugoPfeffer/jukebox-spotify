package br.com.cmms.openapi;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(description = "Documentation of Jukebox-Spotify endpoints", title = "Jukebox API", version = "0.0.1", contact = @Contact( name = "Gustavo Gianini", email = "gustavoogian@jukefy.com")))
public class Jukeboxapi extends Application{
    
}
