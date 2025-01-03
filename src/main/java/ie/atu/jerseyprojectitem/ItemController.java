package ie.atu.jerseyprojectitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/clothing/{CLothingId}")
    public List<Item> getItemByCLothing(@PathVariable Long CLothingId){
        return itemRepository.findByClothingId(CLothingId);
    }
}
