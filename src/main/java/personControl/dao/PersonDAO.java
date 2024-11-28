package personControl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import personControl.model.Person;

public class PersonDAO {

    private EntityManager em;

    public PersonDAO() {
        em = Persistence.createEntityManagerFactory("personControl").createEntityManager();
    }

    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void update(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public List<Person> findByName(String name) {
        return em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name", Person.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    public void updateAssociations(Person person) {
        em.getTransaction().begin();
        em.merge(person); 
        em.getTransaction().commit();
    }
}
