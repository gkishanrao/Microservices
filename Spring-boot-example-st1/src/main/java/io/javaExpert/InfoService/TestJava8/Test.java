package io.javaExpert.InfoService.TestJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;

import com.google.gson.Gson;

//Java code to find the luckiest person
class Test {

	// Driver Program to test above function
	public static void main(String[] args) {
		
		


String name1="Kishan";
String name2="Kishan";
String name3=new String("Hello");
String name4=new String("Hello");

System.out.println("Test.main()"+(name1.equals(name2)));
System.out.println("Test.main()"+(name1==name2));
System.out.println("Test.main()"+(name3==(name4)));


		
		

		// ArrayList<String> nameList=new ArrayList<>();//Remove Elements
		CopyOnWriteArrayList<String> nameList = new CopyOnWriteArrayList<>();// Add Elements

		// LinkedList<String> strList=new
		// LinkedList<String>(Arrays.asList("Kishan","Suresh","Vikram","Vikrant"));
		List<String> strList = Arrays.asList("Kishan", "Suresh", "Vikram", "Vikrant");
		// CopyOnWriteArrayList<E>
		nameList.addAll(strList);

		Iterator<String> it = nameList.iterator();

		while (it.hasNext()) {
			String strlist = it.next();
			if (strlist.equals("Kishan")) {
				// it.remove();
				nameList.add("Sunitha");

			}
		}

		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println(" /////////////////");
		
		
		String future = "";
		String orginal = "kishan";
		
			
		
		for (int i = 0; i < orginal.length(); i++) {
		//	orginal = orginal.charAt(i);
			future = orginal.charAt(i) + future;
		} 
		System.out.println(future);
		if (orginal.equalsIgnoreCase(future)) {
			System.out.print(future + " " + "String is palendrome");
		} else
			System.out.print(future + " " + "String is Not palendrome");

	
	StringBuffer strb=new StringBuffer();
	strb.append(orginal);
	
	String ss=strb.reverse().toString();
	
	if(orginal.equalsIgnoreCase(ss)){
	
		System.out.print(future + " " + " is palendrome");
	} else
		System.out.print(future + " " + " is Not palendrome");

	System.out.println("+++++++++++++++++++++++++++\b");
	
	List<String> list = Arrays.asList("Hello ", 
            "G", "E", "E", "K", "S!");

//list.parallelStream().forEachOrdered(System.out::print);
	
	
Employee[] emp = {
        new Employee("Jing", "Red", 51000, "IT"),
        new Employee("Abu", "Green", 71600, "IT"),
        new Employee("Mon", "Black", 35187, "Sales"),
        new Employee("K", "Yellow", 47100, "Marketing"),
        new Employee("L", "Pink", 62001, "IT"),
        new Employee("D", "Blue", 32001, "Sales"),
        new Employee("W", "Brown", 42361, "Marketing")};
System.out.println("EMP="+emp.toString());
Gson gson= new Gson();

String gs= gson.toJson(emp);

System.out.println("GSON"+gs);




List<Employee> lt = Arrays.asList(emp);
lt.stream().filter(x->x.getSalary() > 47100 ).sorted()
.map(Employee::getFirstName).collect(Collectors.toList()).forEach(System.out::print);
System.out.print("--------------------------");




List < String > fruits = new ArrayList < String > ();
fruits.add("Orange");
fruits.add("Apple");
fruits.add("Mango");
fruits.add("Banana");

List<String> fts= fruits.stream().sorted().collect(Collectors.toList());
fts.forEach(p-> System.out.println(p));



List < String > sortedList = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
System.out.println("=======0:"+sortedList);

List < String > sortedList1 = fruits.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
System.out.println("=======1:"+sortedList1);

List < String > sortedList2 = fruits.stream().sorted().collect(Collectors.toList());
System.out.println("========2:"+sortedList2);


List < Employee > employeesSortedList2 = lt.stream()
    .sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList()); //ascending order
System.out.println(employeesSortedList2);

List < Employee > employeesSortedList2 = lt.stream()
    .sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList()); //decending order
System.out.println(employeesSortedList2);


	}
}
class Employee
{
   private String firstName;
   private String lastName;
   private int salary; 
   private String department;
   
   // constructor 
   public Employee(String firstName, String lastName, 
      int salary, String department)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.department = department;
   } 

   // set firstName
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   // get firstName
   public String getFirstName()
   {
      return firstName;
   }

   // set lastName
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   // get lastName
   public String getLastName()
   {
      return lastName;
   }

   // set salary
   public void setSalary(int salary)
   {
      this.salary = salary;
   }

   // get salary
   public int getSalary()
   {
      return salary;
   }

   // set department
   public void setDepartment(String department)
   {
      this.department = department;
   }

   // get department
   public String getDepartment()
   {
      return department;
   }

   // return Employee's first and last name combined
   public String getName()
   {
      return String.format("%s %s", getFirstName(), getLastName());
   }

   // return a String containing the Employee's information
   @Override
   public String toString() 
   {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
   } 
}
