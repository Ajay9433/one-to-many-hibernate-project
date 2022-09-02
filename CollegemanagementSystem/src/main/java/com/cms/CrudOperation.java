package com.cms;

import javax.swing.JOptionPane;

import com.cms.entity.Course;
import com.cms.entity.Instructor;
import com.cms.model.InstructorDTO;
import com.cms.service.CourseService;
import com.cms.service.InstructorService;
import com.cms.serviceimpl.CourseServiceImpl;
import com.cms.serviceimpl.InstructorServiceImpl;

public class CrudOperation {
	static InstructorService instructorService = new InstructorServiceImpl();
	static CourseService courseService = new CourseServiceImpl();

	// we are performing crud instructor
	public static void crudInstructor() {
		String xx;
		while (true) {
			System.out.println("============================================================================");
			System.out.println("Press c. for add instructor details\n"
					+ "Press r. for read details\n Press u.for update details\n Press d.for delete details\n"
					+ " Press q for quit");
			System.out.println("============================================================================");
			xx = JOptionPane.showInputDialog("Enter choice", "Type here");

			switch (xx) {

			case "c":
				Instructor instructor1 = new Instructor();
				instructor1.setFirstName("Diya");
				instructor1.setLastName("Mishra");
				instructor1.setEmail("diya@gmail.com");

				instructorService.saveInstructor(instructor1);
				System.out.println("data saved successfully");
				break;

			case "r":

				try {

					InstructorDTO ins = instructorService
							.getInstructorById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
					System.out.println("Instructor details: ");
					System.out.println("Id: " + ins.getInsId());
					System.out.println("FirstName: " + ins.getFirstName());
					System.out.println("LastName: " + ins.getLastName());
					System.out.println("Email: " + ins.getEmail());

					System.out.println("Assigned Course");

					for (Course c : ins.getCourse()) {
						System.out.println("courses: " + c.getTitle());
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				break;

			case "u":

				Instructor ins = new Instructor();
				ins.setFirstName("diya kumar");
				ins.setLastName("sharma");
				ins.setEmail("diya.k@gmail.com");

				InstructorDTO upinst = instructorService.updaInstructor(
						Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")), ins);
				System.out.println("Instructor updated successfully");
				break;

			case "d":

				instructorService.deleteInstructor(
						Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
				break;

			case "q":
				crudOpeartion();
				break;

			}// end of switch
		}
	} // crud instructor

	// we are performing crud course operation
	public static void crudCourse() {
		String in;
		while (true) {
			System.out.println("============================================================================");
			System.out.println("Press c. for add Course details\n"
					+ "Press r. for read details\n Press u.for update details\n Press d.for delete details\n"
					+ " Press q for quit ");
			System.out.println("============================================================================");
			in = JOptionPane.showInputDialog("Enter choice", "Type here");

			switch (in) {
			case "c":
				Course course1 = new Course();
				course1.setTitle("Java");
				course1.setPrice(30000.50);

				courseService.saveCourse(course1);
				System.out.println("Course details saved successfully");
				break;

			case "r":
				try {
					// InstructorDTO
					// insDto=instructorService.getInstructorById(Integer.parseInt(JOptionPane.showInputDialog("Enter
					// id", "type here")));

					Course course = courseService
							.getCourseById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
					System.out.println("Course details: ");
					System.out.println("Id: " + course.getId());
					System.out.println("Course Title: " + course.getTitle());
					System.out.println("Fees: " + course.getPrice());
					System.out.println("Assigned Instructor Name: " + course.getInstructor().getFirstName() + " "
							+ course.getInstructor().getLastName());

				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "u":

				Course coursee = new Course();
				coursee.setTitle("Python");
				coursee.setPrice(15000.40);

				Course upcrs = courseService.updateCourse(
						Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")), coursee);
				System.out.println("Course updated successfully");
				break;

			case "d":

				courseService
						.deleteCourse(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
				break;
			case "q":
				crudOpeartion();
				break;
			default:
				System.out.println("wrong input");

			}// switch
		}
	} // crud course

	// this method is responsible for adding instructor to course
	public static void assignCourseToInstructor() {

		// for quick execution we have hard coded instructor id and course id later
		// we will convert it to variable
		instructorService.assignCourseToInstructor(1, 1);
		System.out.println("course assigned to instructor");

	}// assign

	public static void crudOpeartion() {

		int input;
		while (true) {
			System.out.println("============================================================================");
			System.out.println("Press 1. for instructor details\n Press 2. for course details\n"
					+ "Press 3. for assign course to instructor\n Press 4. for quit");
			input = Integer.parseInt(JOptionPane.showInputDialog("Enter choice", "Type here"));
			System.out.println("============================================================================");

			switch (input) {

			case 1:
				crudInstructor();
				break;

			case 2:
				crudCourse();
				break;

			case 3:
				assignCourseToInstructor();
				break;
			case 4:
				App.mainFrame();
				break;

			}
		} // end of do

	}
}
