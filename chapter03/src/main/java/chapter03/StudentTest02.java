package chapter03;

public class StudentTest02 {
	Student s1 = new Student();
	Person p = s1; // up-casting(암시적, Implicity)
	Student s2 = (Student)p; // downcasting(명시적, Explicity)
	
}
