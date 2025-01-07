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

    @GetMapping("/clothing/{clothingId}")
    public List<Item> getItemsByClothingId(@PathVariable Long clothingId) {
        return itemRepository.findByClothingId(clothingId);
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found for ID: " + itemId));
    }
}
