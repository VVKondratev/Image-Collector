package collect.img.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name = "imgs")
public class Img {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;


    @Column(name = "tags")
    private String tags;


    @Column(name = "title")
    private String title;


    @Column(name = "pathorurl")
    private String pathorurl;

}
