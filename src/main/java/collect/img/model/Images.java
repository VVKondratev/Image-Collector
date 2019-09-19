package collect.image.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "image")
public class Images {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "image_tag", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tags> tags = new ArrayList<>();






}
