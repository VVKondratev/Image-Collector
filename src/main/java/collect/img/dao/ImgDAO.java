package collect.img.dao;



import collect.img.model.Img;

import java.util.List;

public interface ImgDAO {
    List<Img> allImgs();
    void add(Img img);
    void delete(Img img);
    void edit(Img img);
    Img getById(int id);
}
