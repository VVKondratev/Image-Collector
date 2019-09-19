package collect.image.dao;

import collect.image.model.Images;
import collect.image.model.Tags;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ImageDAO")
@Transactional
public class ImageDAOImpl implements ImageDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Images> allImgs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Images").list();
    }

    @Override
    public void add(Images img) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(img);
    }

    @Override
    public void delete(Images img) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(img);
    }

    @Override
    public void edit(Images img) {
        Session session = sessionFactory.getCurrentSession();
           session.update(img);
    }

    @Override
    public Images getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Images.class, id);
    }

    @Override
    public List<Tags> getTagsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Images.class, id).getTags();
    }
}
