package personControl.controller;

import personControl.model.Person;
import personControl.model.Address;
import personControl.model.Document;
import personControl.model.Contact;
import personControl.service.PersonService; 

import javax.annotation.PostConstruct;
import javax.inject.Named;

import java.util.List;

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
		person.getAddresses().add(address);
	}

	public void addDocument(Document document) {
		person.getDocuments().add(document);
	}

	public void addContact(Contact contact) {
		person.getContacts().add(contact); 
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
