package by.skorohodov.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category", schema = "public")
@Getter @Setter @Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Product> product;
}
