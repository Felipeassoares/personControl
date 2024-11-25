package personControl.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import personControl.model.Person;

@Named
@Stateless
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void searchAllPersons() {
        persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public void searchPersonByName(String name) {
        persons = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name", Person.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
    }
}

