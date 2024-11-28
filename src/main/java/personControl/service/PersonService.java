package personControl.service;

import java.util.List;

import personControl.dao.PersonDAO;
import personControl.model.Address;
import personControl.model.Contact;
import personControl.model.Document;
import personControl.model.Person;

public class PersonService {

	private PersonDAO personDAO;

	public PersonService() {
		personDAO = new PersonDAO();
	}

	public void save(Person person) {
		if (person.getId() == null) {
			personDAO.save(person);
		} else {
			personDAO.update(person);
		}
	}

	public void update(Person person) {
		personDAO.update(person);
	}

	public void delete(Long id) {
		Person person = findById(id);
		if (person != null) {
			personDAO.delete(person);
		}
	}

	public Person findById(Long id) {
		return personDAO.findById(id);
	}

	public List<Person> findAll() {
		return personDAO.findAll();
	}

	public List<Person> findByName(String name) {
		return personDAO.findByName(name);
	}

	public void addAddress(Person person, Address address) {
		person.getAddresses().add(address);
		personDAO.updateAssociations(person);
	}

	public void addDocument(Person person, Document document) {
		person.getDocuments().add(document);
		personDAO.updateAssociations(person);
	}

	public void addContact(Person person, Contact contact) {
		person.getContacts().add(contact);
		personDAO.updateAssociations(person);
	}

	public void removeAddress(Person person, Address address) {
		person.getAddresses().remove(address);
		personDAO.updateAssociations(person);
	}

	public void removeDocument(Person person, Document document) {
		person.getDocuments().remove(document);
		personDAO.updateAssociations(person);
	}

	public void removeContact(Person person, Contact contact) {
		person.getContacts().remove(contact);
		personDAO.updateAssociations(person);
	}
}
