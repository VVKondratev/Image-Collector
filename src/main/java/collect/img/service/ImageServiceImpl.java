package collect.img.service;

import collect.img.model.Images;
import collect.img.dao.ImgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SessionFactory")
public class ImgServiceImpl implements ImgService {
    private ImgDAO imgDAO;

    @Autowired
    public void setImgDAO(ImgDAO imgDAO) {
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
}
