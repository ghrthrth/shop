package by.skorohodov.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "public")
@Getter @Setter @Accessors(chain = true)
public class Product {

    @Id
    int id;
    String name;
    int count;
    int price;
    @Column(name = "category_id")
    int categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private Category category;
}
