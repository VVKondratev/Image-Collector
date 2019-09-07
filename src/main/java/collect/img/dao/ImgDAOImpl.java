package collect.img.dao;

import collect.img.model.Img;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("ImgDAO")
@Transactional
public class ImgDAOImpl  implements ImgDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Img> allImgs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Img").list();
    }

    @Override
    public void add(Img img) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(img);
    }

    @Override
    public void delete(Img img) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(img);
    }

    @Override
    public void edit(Img img) {
        Session session = sessionFactory.getCurrentSession();
        session.update(img);
    }

    @Override
    public Img getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Img.class, id);
    }
}
