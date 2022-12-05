package org.sreekanth.ngm;

import io.helidon.common.configurable.Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class FrontEndResource {

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String home() {
        String indexFile = Resource.create("web/index.html").string();
        return indexFile;
    }

    @Path("/inventory")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String listing() {
        String indexFile = Resource.create("web/inventory.html").string();
        return indexFile;
    }

}
