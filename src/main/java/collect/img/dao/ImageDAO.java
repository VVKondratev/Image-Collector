package collect.img.dao;



import collect.img.model.Images;

import java.util.List;

public interface ImgDAO {
    List<Images> allImgs();
    void add(Images img);
    void delete(Images img);
    void edit(Images img);
    Images getById(int id);
}
