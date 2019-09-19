package collect.image.dao;

import collect.image.model.Images;
import collect.image.model.Tags;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("TagDAO")
@Transactional
public class TagDAOImpl implements TagDAO {

    private SessionFactory tagSessionFactory;

    @Autowired
    public void setTagSessionFactory(SessionFactory tagSessionFactory) {
        this.tagSessionFactory = tagSessionFactory;
    }

    @Override
    public List<Tags> allTags() {
        Session session = tagSessionFactory.getCurrentSession();
        return session.createQuery("from Tags").list();
    }

    @Override
    public void add(Tags tag) {
        Session session = tagSessionFactory.getCurrentSession();
        session.persist(tag);
    }

    @Override
    public void delete(Tags tag) {
        Session session = tagSessionFactory.getCurrentSession();
        session.delete(tag);
    }

    @Override
    public void edit(Tags tag) {
        Session session = tagSessionFactory.getCurrentSession();
        session.update(tag);


    }

    @Override
    public Tags getById(int id) {
        Session session = tagSessionFactory.getCurrentSession();
        return session.get(Tags.class, id);
    }

    @Override
    public List<Images> getImagesById(int id) {
        Session session = tagSessionFactory.getCurrentSession();
        return session.get(Tags.class, id).getImgs();
    }
}
