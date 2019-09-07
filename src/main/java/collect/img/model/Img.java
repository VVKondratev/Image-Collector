package collect.img.model;

import javax.persistence.*;

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

    public void setId(int id){
        this.id = id;
    }

    public void setTags(String tags){
        this.tags = tags;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPathorurl(String pathorurl){
        this.pathorurl = pathorurl;
    }

    public int getId(){
        return(this.id);
    }

    public String getTags(){
        return(this.tags);
    }

    public String getTitle(){
        return(this.title);
    }

    public String getPathorurl(){
        return(this.pathorurl);
    }
}
