package ie.atu.jerseyprojectitem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByClothingId(Long ClothingId);
}
