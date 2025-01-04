package ie.atu.jerseyprojectitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    private final String ClothingURL = "http://localhost:8082/clothing";

    @GetMapping("/{itemId}")
    public Map<String, Object> getItemDetailsById(@PathVariable Long itemId){
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        Long clothingId = item.getClothingId();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> clothingResponse = restTemplate.getForEntity(
                ClothingURL + "/" + clothingId, Map.class);

        Map<String, Object> clothing = clothingResponse.getBody();

        Map<String, Object> response = new HashMap<>();
        response.put("ItemId", item.getItemId());
        response.put("ItemName", item.getItemName());
        response.put("ClothingId", clothing);

        return response;
       }
}
