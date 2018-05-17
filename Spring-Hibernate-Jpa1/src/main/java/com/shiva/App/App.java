package com.shiva.App;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.shiva.config.AppConfig;
import com.shiva.entity.Person;
import com.shiva.service.PersonService;


public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	System.out.println("");
    	System.out.println("JPA");
    	System.out.println("");
    	PersonService personService=context.getBean(PersonService.class);
    	personService.addPerson(new Person(1,"A","A","A"));
    	personService.addPerson(new Person(2,"B","B","B"));
    	
    	List<Person> persons=personService.getAll();
    	for(Person p:persons)
    	{
    		System.out.println("Id: "+p.getId());
    		System.out.println("First Name: "+p.getFirstName());
    		System.out.println("Last name: "+p.getLastName() );
    		System.out.println("Email: "+p.getEmail());
    	}
    	context.close();
    }
    
}
