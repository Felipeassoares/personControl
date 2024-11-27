package personControl.service;

import personControl.model.Person;
import personControl.model.Address;
import personControl.model.Document;
import personControl.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonService {

	private EntityManager em;

	public PersonService() {
		em = Persistence.createEntityManagerFactory("personControl").createEntityManager();
	}

	public void save(Person person) {
		em.getTransaction().begin();
		if (person.getId() == null) {
			em.persist(person);
		} else {
			em.merge(person);
		}
		em.getTransaction().commit();
	}

	public void update(Person person) {
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
	}

	public void delete(Long id) {
		Person person = findById(id);
		if (person != null) {
			em.getTransaction().begin();
			em.remove(person);
			em.getTransaction().commit();
		}
	}

	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	public List<Person> findAll() {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
		return query.getResultList();
	}

	public List<Person> findByName(String name) {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name", Person.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	public void addAddress(Person person, Address address) {
		em.getTransaction().begin();
		person.getAddresses().add(address);
		em.merge(person);
		em.getTransaction().commit();
	}

	public void addDocument(Person person, Document document) {
		em.getTransaction().begin();
		person.getDocuments().add(document);
		em.merge(person);
		em.getTransaction().commit();
	}

	public void addContact(Person person, Contact contact) {
		em.getTransaction().begin();
		person.getContacts().add(contact);
		em.merge(person);
		em.getTransaction().commit();
	}

	public void removeAddress(Person person, Address address) {
		em.getTransaction().begin();
		person.getAddresses().remove(address);
		em.merge(person);
		em.getTransaction().commit();
	}

	public void removeDocument(Person person, Document document) {
		em.getTransaction().begin();
		person.getDocuments().remove(document);
		em.merge(person);
		em.getTransaction().commit();
	}

	public void removeContact(Person person, Contact contact) {
		em.getTransaction().begin();
		person.getContacts().remove(contact);
		em.merge(person);
		em.getTransaction().commit();
	}
}
