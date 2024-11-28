package personControl.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import personControl.model.Address;
import personControl.model.Contact;
import personControl.model.Document;
import personControl.model.Person;
import personControl.service.PersonService;

@Named("bean")
public class PersonBean {

	private Person person;
	private List<Person> personList;
	private PersonService personService;

	@PostConstruct
	public void init() {
		personService = new PersonService();
		person = new Person();
		personList = personService.findAll();
	}

	public String save() {
		if (person.getId() == null) {
			personService.save(person);
		} else {
			personService.update(person);
		}
		init();
		return "index";
	}

	public void edit(Long id) {
		person = personService.findById(id);
	}

	public void delete(Long id) {
		personService.delete(id);
		personList = personService.findAll();
	}

	public void searchByName() {
		personList = personService.findByName(person.getName());
	}

	public void addAddress(Address address) {
		personService.addAddress(person, address);
	}

	public void addDocument(Document document) {
		personService.addDocument(person, document);
	}

	public void addContact(Contact contact) {
		personService.addContact(person, contact);
	}

	public void removeAddress(Address address) {
		personService.removeAddress(person, address);
	}

	public void removeDocument(Document document) {
		personService.removeDocument(person, document);
	}

	public void removeContact(Contact contact) {
		personService.removeContact(person, contact);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
}
