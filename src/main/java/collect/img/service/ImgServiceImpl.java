package collect.img.service;

import collect.img.dao.ImgDAOImpl;
import collect.img.model.Img;
import collect.img.dao.ImgDAO;
import org.hibernate.SessionFactory;
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
    public List<Img> allImgs() {
        return imgDAO.allImgs();
    }

    @Override
    public void add(Img img) {
        imgDAO.add(img);
    }

    @Override
    public void delete(Img img) {
        imgDAO.delete(img);
    }

    @Override
    public void edit(Img img) {
        imgDAO.edit(img);
    }

    @Override
    public Img getById(int id) {
        return imgDAO.getById(id);
    }
}
