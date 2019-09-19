package collect.image.service;

import collect.image.model.Images;
import collect.image.dao.ImageDAO;
import collect.image.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SessionFactory")
public class ImageServiceImpl implements ImageService {
    private ImageDAO imgDAO;

    @Autowired
    public void setImgDAO(ImageDAO imgDAO) {
        this.imgDAO = imgDAO;
    }

    @Transactional
    @Override
    public List<Images> allImgs() {
        return imgDAO.allImgs();
    }

    @Override
    public void add(Images img) {
        imgDAO.add(img);
    }

    @Override
    public void delete(Images img) {
        imgDAO.delete(img);
    }

    @Override
    public void edit(Images img) {
        imgDAO.edit(img);
    }

    @Override
    public Images getById(int id) {
        return imgDAO.getById(id);
    }

    @Override
    public List<Tags> getTagsById(int id) { return imgDAO.getTagsById(id);
    }
}
