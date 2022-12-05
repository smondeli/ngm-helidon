package org.sreekanth.ngm;

import io.helidon.common.configurable.Resource;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/")
public class FrontEndResource {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String home() {
        return Resource.create("web/index.html").string();
    }

    @Path("/inventory")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String inventory() {
        return Resource.create("web/inventory.html").string();
    }

    @Path("/items")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray listing() {
        return JSON.createArrayBuilder()
                .add(JSON.createObjectBuilder()
                        .add("name", "Apple")
                        .add("price", 3)
                        .add("category", "Fruit")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Banana")
                        .add("price", 2)
                        .add("category", "Fruit")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Peach")
                        .add("price", 3)
                        .add("category", "Fruit")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Broccoli")
                        .add("price", 3)
                        .add("category", "Vegetable")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Kale")
                        .add("price", 5)
                        .add("category", "Vegetable")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Chicken alfredo")
                        .add("price", 7)
                        .add("category", "Pasta")
                )
                .add(JSON.createObjectBuilder()
                        .add("name", "Pie")
                        .add("price", 4)
                        .add("category", "Dessert")
                )
                .build();
    }
}
