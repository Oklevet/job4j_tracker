package ru.job4j.tracker2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private Session session;

    @Override
    public void init() {
        session = sf.openSession();
    }

    @Override
    public Item add(Item item) {
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(int id) {
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<Item> findAll() {
        session.beginTransaction();
        List<Item> result =
                session.createQuery("from ru.job4j.tracker2.Item", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        session.beginTransaction();
        List<Item> result =
                session.createQuery("from ru.job4j.tracker2.Item i where name = :key", Item.class)
                        .setParameter("key", key).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}