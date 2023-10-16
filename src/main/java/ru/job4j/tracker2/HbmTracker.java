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

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();         
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> result = List.of();
        try {
            session.beginTransaction();
             result = session.createQuery("Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> result = List.of();
        try {
            session.beginTransaction();
            result = session.createQuery("from Item i where name = :key", Item.class)
                            .setParameter("key", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}