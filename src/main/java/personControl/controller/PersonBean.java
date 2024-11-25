package personControl.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import personControl.model.Person;

@SuppressWarnings("deprecation")
@Named
@RequestScoped
public class PersonBean {

    @PersistenceContext
    private EntityManager em;

    private List<Person> persons;

    // Atributos do Formulário
    private String name;
    private String email;
    private String telephone;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Transactional
    public void save() {

    	Person person = new Person();
        person.setName(name);
        person.setEmail(email);
        person.setTelephone(telephone);

        em.persist(person);  

        name = "";
        email = "";
        telephone = "";
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
