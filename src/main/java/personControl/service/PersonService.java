package personControl.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import personControl.model.Person;

@Stateless
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Person person) {
        if (person.getId() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }
    }

    public List<Person> pesquisarPorNome(String name) {
        return em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name", Person.class)
                 .setParameter("name", "%" + name + "%")
                 .getResultList();
    }
}
