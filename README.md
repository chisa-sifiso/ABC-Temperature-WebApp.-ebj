<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Employee Temperature Monitoring EJB Application</title>
</head>
<body>
    <h1>Employee Temperature Monitoring EJB Application</h1>
    
  <p>
        This project is an Enterprise JavaBeans (EJB) based web application used to monitor and record the temperature readings of employees. The application allows for the creation, storage, and retrieval of employee temperature data and offers additional functionality to calculate the count of employees whose temperature readings are above or below certain thresholds.
    </p>

   <h2>Technologies Used</h2>
    <ul>
        <li><strong>Enterprise JavaBeans (EJB)</strong> - Used to manage the business logic and data operations for employee records.</li>
        <li><strong>Java Persistence API (JPA)</strong> - Used to map the Employee entity to the database and handle persistence operations.</li>
        <li><strong>GlassFish Server</strong> - The application is deployed as an EJB module on the GlassFish application server.</li>
        <li><strong>JSP & Servlets</strong> - Used to handle HTTP requests and render HTML pages.</li>
    </ul>

  <h2>Project Structure</h2>
    <p>The project is structured into the following key components:</p>

   <ul>
        <li>
            <strong>Model</strong> (Employee entity):
            <ul>
                <li><strong>Employee.java:</strong> Represents an employee with fields for <code>id</code>, <code>name</code>, and <code>tempReading</code>. The entity is annotated with <code>@Entity</code> to make it a JPA entity that can be persisted in the database.</li>
            </ul>
        </li>
     <li>
            <strong>Business Logic</strong> (EJB):
            <ul>
                <li>
                    <strong>AbstractFacade.java:</strong> This abstract class provides generic methods for performing CRUD operations (create, read, update, delete) on any JPA entity. It serves as the base class for the <code>EmployeeFacade</code>.
                </li>
                <li>
                    <strong>EmployeeFacade.java:</strong> This class extends <code>AbstractFacade</code> and implements <code>EmployeeFacadeLocal</code>. It manages the <code>Employee</code> entity and contains methods to determine the number of employees with high or low temperature readings.
                    <ul>
                        <li><code>determineNumberOfHighTemperatureEmployees()</code>: Queries the database to count employees with a temperature reading above 38 degrees Celsius.</li>
                        <li><code>determineNumberOfLowTemperatureEmployees()</code>: Queries the database to count employees with a temperature reading of 38 degrees Celsius or below.</li>
                    </ul>
                </li>
                <li>
                    <strong>EmployeeFacadeLocal.java:</strong> Defines the local interface for the <code>EmployeeFacade</code>, exposing business methods like <code>create(Employee employee)</code> and methods to calculate the temperature counts.
                </li>
            </ul>
        </li>

  <li>
            <strong>Presentation Layer</strong> (Servlets):
            <ul>
                <li><strong>EmployeeDetailsServlet.java:</strong> Handles requests to capture and persist employee temperature readings in the database.</li>
                <li><strong>GetHighTemperesCountServlet.java:</strong> Fetches the number of employees with high temperature readings (greater than 38°C).</li>
                <li><strong>GetLowTemperaCountServlet.java:</strong> Fetches the number of employees with low temperature readings (38°C or below).</li>
                <li><strong>LogoutServlet.java:</strong> Handles user logout and session invalidation.</li>
            </ul>
        </li>
    </ul>

   <h2>Database Model</h2>
    <p>The application uses the <strong>Employee</strong> entity to represent employees and their temperature readings:</p>
    <ul>
        <li><strong>ID</strong> (Long) - Unique identifier for each employee.</li>
        <li><strong>Name</strong> (String) - Name of the employee.</li>
        <li><strong>Temperature Reading</strong> (Double) - Represents the employee's recorded temperature.</li>
    </ul>

   <h2>How the Business Logic Works</h2>
    <p>The core of the business logic resides in the <strong>EmployeeFacade</strong> EJB class, which extends the <strong>AbstractFacade</strong> class. Here's an overview of how the business logic is implemented:</p>
    <ul>
        <li><strong>Create Employee:</strong> When an employee's details are submitted via the form, the <code>EmployeeDetailsServlet</code> calls the <code>create(Employee employee)</code> method from the <code>EmployeeFacadeLocal</code> interface. This method uses JPA to persist the employee data to the database.</li>
        <li><strong>Count High Temperature Employees:</strong> The <code>determineNumberOfHighTemperatureEmployees()</code> method is used to count all employees whose temperature readings are above 38°C. It uses a JPQL query to perform this task.</li>
        <li><strong>Count Low Temperature Employees:</strong> Similarly, the <code>determineNumberOfLowTemperatureEmployees()</code> method counts employees with a temperature of 38°C or below. This data is then forwarded to the JSP for display.</li>
    </ul>

  <h2>How to Run the Project</h2>
    <ol>
        <li>Ensure that you have <strong>GlassFish Server</strong> installed and configured.</li>
        <li>Clone the repository: <code>git clone https://github.com/your-github-username/Employee-Temperature-EJB.git</code></li>
        <li>Open the project in your preferred Java EE IDE (e.g., NetBeans, IntelliJ IDEA).</li>
        <li>Build the project and generate a WAR file.</li>
        <li>Deploy the WAR file to GlassFish.</li>
        <li>Access the application by navigating to the GlassFish server's URL (e.g., <code>http://localhost:8080/Employee-Temperature-EJB</code>).</li>
    </ol>

  <h2>Endpoints</h2>
    <ul>
        <li><code>/capture_employee_details.html</code> - Form to capture employee temperature details.</li>
        <li><code>/get_high_temp_cnt.html</code> - Retrieve the count of employees with high temperature readings.</li>
        <li><code>/get_low_temp_cnt.html</code> - Retrieve the count of employees with low temperature readings.</li>
        <li><code>/LogoutServlet.do</code> - Logout the user and invalidate the session.</li>
    </ul>

  <h2>Author</h2>
    <p>
        Developed by Sifiso.
    </p>

   <h2>License</h2>
    <p>
        This project is licensed under the <strong>MIT License</strong>.
    </p>
</body>
</html>
