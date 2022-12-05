package org.sreekanth.ngm;

import io.helidon.common.configurable.Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public JsonArray items() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple","Fruit", 3));
        items.add(new Item("Banana", "Fruit", 2));
        items.add(new Item("Peach", "Fruit", 3));
        items.add(new Item("Broccoli", "Vegetable", 3));
        items.add(new Item("Kale", "Vegetable", 5));
        items.add(new Item("Chicken alfredo", "Pasta", 7));
        items.add(new Item("Pie", "Dessert", 4));
        JsonArrayBuilder jsonBuilder = JSON.createArrayBuilder();
        for(Item item:items){
            jsonBuilder.add(JSON.createObjectBuilder()
                    .add("name", item.getName())
                    .add("category", item.getCategory())
                    .add("price", item.getPrice())
            );
        }
        return jsonBuilder.build();
    }
}
