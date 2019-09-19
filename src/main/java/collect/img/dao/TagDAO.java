package collect.image.dao;

import collect.image.model.Images;
import collect.image.model.Tags;

import java.util.List;

public interface TagDAO {
    List<Tags> allTags();
    void add(Tags tag);
    void delete(Tags tag);
    void edit(Tags tag);
    Tags getById(int id);
    List<Images> getImagesById(int id);
}
