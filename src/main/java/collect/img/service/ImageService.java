package collect.img.service;

import collect.img.model.Images;

import java.util.List;

public interface ImgService {
    List<Images> allImgs();
    void add(Images img);
    void delete(Images img);
    void edit(Images img);
    Images getById(int id);
}
