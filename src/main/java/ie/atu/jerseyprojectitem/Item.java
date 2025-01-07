package ie.atu.jerseyprojectitem;

import jakarta.persistence.*;


@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "clothing_id")
    private Long clothingId;
    @Column(name = "image_url")
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getClothingId() {
        return clothingId;
    }

    public void setClothingId(Long clothingId) {
        this.clothingId = clothingId;
    }
}
