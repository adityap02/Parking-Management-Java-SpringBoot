### Parking Management System Using Java Springboot (practice project)

Parking Management System is developed as a learning project during Java training at Epam Systems. It showcases a robust application structure, adherence to clean code principles, and efficient data structures implementing parking operation management. 

## Project Structure

The project is organized into several key directories, reflecting a clear separation of concerns and modularity:

- **`src/main/java/com/epam/parking`**: Contains the core Java source files, organized under specific subdirectories:
  - **`database`**: Handles database configurations and operations.
  - **`entity`**: Defines data models and entities.
  - **`exceptions`**: Custom exception classes for specific error handling.
  - **`frontend`**: User interface components for interaction.
  - **`services`**: Core business logic and services for parking management.
- **`src/main/resources`**: Includes resource files like `log4j2.properties` for logging configurations.
- **`src/test/java`**: Contains test cases ensuring the reliability and functionality of the application.

## Technologies and Dependencies
The project utilizes a range of technologies:

- Java8: The primary programming language.
- Maven: For build management and dependency resolution.
- Java Persistence API (JPA):For object-relational mapping and database operations.
- Log4j For logging all the operations throughout the application.
- JUnit: For writing and executing test cases.
- Mockito For Mocking Obects and classes in JUnit test cases.

## Testing

The application includes a suite of test cases in the `src/test/java` directory, ensuring each component functions as expected. The tests cover a range of scenarios, from database interactions to service layer functionality.

## Clean Code Principles

Throughout its development, the project adheres to clean code principles. This includes:

- Clear and meaningful naming conventions.
- Modular design for easy maintenance and scalability.
- Efficient exception handling mechanisms.
- Comprehensive documentation and comments for clarity.

## Usage and Configuration

(Instructions on how to set up, configure, and run the application can be added here.)

## Contributing

Contributions to EPAM ParkMate are welcome. Please ensure to maintain code quality and adhere to the established clean code practices.

---

This README template provides a comprehensive overview of the Parking Management System, highlighting its structure, dependencies, testing practices, and adherence to clean code principles. Feel free to modify or expand any sections as needed for your specific project documentation.

# RD Training FEB 2021 – Project Documentation

## Name of Project: Smart Parking
### About: This Project will automate parking process at XYZ Shopping Mall. There is No Reserved Parking. Users have to pay for parking on hourly basis. Parking will be done on random available slots. 

#### Functionalities in the Project:

- Option 1: Create a Parking Area
Admin has option to create a Parking Area by inputting Parking Area Name and Number of Slots for that Parking area.

- Option 2: Park Vehicle
User will just provide the vehicle number and vehicle will be parked to random available slots. Also, In-Time of Vehicle should be automatically stored in the records.
- Option 3: Unpark the Vehicle
User will provide their vehicle number and vehicle will be unparked printing following details on screen: In-Time, Out-Time, Total Parked Hour, Amount to pay.
- Option 4: Print all Slots.
It will print current state of all parking slots. For slots having vehicle parked, it will show Parked Vehicle Number with parking slot number. For slots which are free, it will show “Free” with parking slot number. (Format: SlotNumber CurrentState)
- Option 5: Exit from Application .This option will close the application.

#### Note:
-	Project should follow Three-Layer-Architectural approach.
-	Coding Portion should follow OOP Concepts, Design Principle, Clean Code Principles & other standard guidelines.
-	For Console Based Model, Use Collection as Database. Further, it will extend to MySQL Server.
-	Further we’ll extend our project from Console Based to Web Based UI Project.
-	Make this as Maven Project Only.
