package collect.image.service;

import collect.image.dao.TagDAO;
import collect.image.model.Images;
import collect.image.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("TagSessionFactory")
public class TagServiceImpl implements TagService {
    private TagDAO tagDAO;

    @Autowired
    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Transactional
    @Override
    public List<Tags> allTags() {
        return tagDAO.allTags();
    }

    @Override
    public void add(Tags tag) {
        tagDAO.add(tag);
    }

    @Override
    public void delete(Tags tag) {
        tagDAO.delete(tag);
    }

    @Override
    public void edit(Tags tag) {
        tagDAO.edit(tag);
    }

    @Override
    public Tags getById(int id) {
        return tagDAO.getById(id);
    }

    @Override
    public List<Images> getImagesById(int id) { return tagDAO.getImagesById(id);
    }
}
