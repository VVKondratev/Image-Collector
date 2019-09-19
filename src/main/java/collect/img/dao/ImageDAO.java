package collect.image.dao;



import collect.image.model.Images;
import collect.image.model.Tags;

import java.util.List;

public interface ImageDAO {
    List<Images> allImgs();
    void add(Images img);
    void delete(Images img);
    void edit(Images img);
    Images getById(int id);
    List<Tags> getTagsById(int id);
}
