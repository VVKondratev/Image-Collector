package collect.image.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tags {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "tag_name")
    private String tag_name;


    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "image_tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Images> imgs = new ArrayList<>();
}
