package vttp2022.ssf.day17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.ssf.day17.services.BoardgameService;

@Controller
@RequestMapping(path="/boardgame")
public class BoardgameRestController {
    
    @Autowired
    private BoardgameService boardgameSvc;
    
    @GetMapping(path="{id}", produces="application/json") 
    public String getBoardgame(
            @RequestParam(name = "id", defaultValue = "1") Integer count) {

        if ((id < 1) || (count > 20)) {
            JsonObject errResp = Json.createObjectBuilder()
                    .add("error", "Valid dice count is between 1 and 10. Your count is %d".formatted(count))
                    .build();
            String payload = errResp.toString();
            // Return 400
            return ResponseEntity
                    // .status(HttpStatus.BAD_REQUEST)
                    .badRequest() //400
                    .body(payload);
        }
        
        
    

        // if ((count < 1) || (count > 20)) {
        //     JsonObject errResp = Json.createObjectBuilder()
        //             .add("error", "Valid game is between 1 and 20. Your count is %d".formatted(id))
        //             .build();
        //     String payload = errResp.toString();
        //     // Return 400
        //     return ResponseEntity
        //             // .status(HttpStatus.BAD_REQUEST)
        //             .badRequest() //400
        //             .body(payload);
        // }


        // // Get the dice roll
        // List<Integer> rolls = diceSvc.roll(count);

        // // Create the response payload
        // JsonObjectBuilder builder = Json
        //     .createObjectBuilder()
        //     .add("id", id);

        // // Create a JsonArray
        // JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        // for (Integer d: rolls)
        //     arrBuilder.add(d);
        // // Add JsonArray (rolls) to the response
        // builder = builder.add("rolls", arrBuilder);

        // // Get the JsonObject from JsonBuilder    
        // JsonObject resp = builder.build();

        // return ResponseEntity.ok(resp.toString());
    // }

}
