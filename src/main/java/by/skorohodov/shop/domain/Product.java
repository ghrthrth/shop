package by.skorohodov.shop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "public")
@Getter @Setter @Accessors(chain = true)
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue
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
