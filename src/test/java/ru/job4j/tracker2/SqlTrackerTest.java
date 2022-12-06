package ru.job4j.tracker2;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    /*
    public Connection init() throws ClassNotFoundException, SQLException {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
             throw new IllegalStateException(e);
        }
    }

     @Test
    public void findAll() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.findAll();
            assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllAfterAdd() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            tracker.add(new Item("qwe"));
            tracker.findAll();
            assertThat(tracker.findByName("name").size(), is(1));
            assertThat(tracker.findByName("qwe").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            tracker.add(item1);
            assertThat(tracker.delete(item1.getId()), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItemInvalid() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.delete(1111), is(false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            tracker.add(item1);
            assertThat(tracker.replace(item1.getId(), new Item("qwe")), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItemInvaid() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            tracker.add(item1);
            assertThat(tracker.replace(999, new Item("qwe")), is(false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByNameItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
     public void findByIdItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            Item item2 = new Item("asd");
            tracker.add(item1);
            tracker.add(item2);
            System.out.println(item1);
            System.out.println(tracker.findById(0));
            System.out.println(tracker.findByName("name"));
            System.out.println(tracker.findAll().toString());
            assertThat(tracker.findById(item1.getId()).getName(), is("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}