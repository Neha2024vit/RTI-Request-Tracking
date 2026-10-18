# RTI Request Tracking and Deadline Compliance Monitoring System

A web-based application designed to simplify the submission and tracking of Right to Information (RTI) requests. The system provides separate access for citizens and officers, supports request management, and stores request information in a MySQL database.

## About the Project

The Right to Information Act, 2005, empowers citizens to request information from public authorities in India. Tracking requests and monitoring their progress can be challenging when information is managed manually.

This project demonstrates a digital approach to RTI request management through a web application built using Java, Spring Boot, and MySQL.

## Features

- **Citizen Registration and Login** — Allows citizens to create accounts and log in.
- **Officer Login** — Provides a separate login for authorized officers.
- **RTI Request Submission** — Enables citizens to submit requests with relevant details.
- **Request Tracking** — Allows users to view submitted requests and their status.
- **Officer Request Management** — Enables officers to access and manage RTI requests.
- **Database Integration** — Stores user and request information in MySQL.
- **Access Control** — Restricts protected features based on user roles.

*Note: Include deadline alerts, automated reminders, or compliance analytics here only if they are implemented in your current version.*

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot | Application framework |
| Spring Security | Authentication and access control |
| MySQL | Database management |
| HTML | Web page structure |
| CSS | Styling and responsive layout |
| JavaScript | Client-side interactions |
| Maven | Dependency and build management |
| Eclipse IDE | Development environment |

## Project Architecture

The application follows a layered web architecture:

1. **Presentation Layer:** HTML, CSS, and JavaScript provide the user interface.
2. **Controller Layer:** Spring Boot controllers handle incoming requests.
3. **Service Layer:** Contains application logic, where implemented.
4. **Repository Layer:** Handles database operations.
5. **Database Layer:** MySQL stores user accounts and RTI request records.

## Getting Started

### Prerequisites

Install the following software:

- Java Development Kit (JDK) 17
- MySQL Server
- Eclipse IDE or another Java IDE
- Maven (or use the Maven wrapper included in the project)


## How to Use

1. Register a citizen account.
2. Log in using the citizen credentials.
3. Submit an RTI request with a subject and description.
4. View the submitted request and its current status.
5. Log in as an authorized officer.
6. View and manage requests using the available officer features.

The exact screens and status options depend on the current implementation.

## Example RTI Request

**Subject:** Request for Information Regarding Road Repair Works

**Description:**

Please provide details of road repair works carried out in my locality during the last financial year, including the sanctioned budget, expenditure incurred, contractor details, and completion dates.

This is a sample request for testing the application and does not represent an actual RTI submission.

## Testing

Suggested functional tests include:

- Citizen registration with valid details
- Login with valid and invalid credentials
- Officer authentication
- Submission of RTI requests
- Viewing submitted requests
- Access control for protected pages
- Database persistence after application restart
- Request status updates, if implemented
- Deadline calculation and alerts, if implemented

Record actual pass/fail results after executing the tests.

## Future Enhancements

- Automated deadline reminders
- Deadline compliance dashboard
- Search and filtering by request status
- Email notifications
- Request history and audit logs
- Report generation and analytics
- Improved responsive user interface

## Security Notes

- Never commit database passwords or private credentials.
- Use password hashing rather than storing plaintext passwords.
- Protect officer-only endpoints with server-side authorization.
- Validate user input on the server.
- Use environment variables or secure configuration for sensitive settings.

## Academic Project

**Project Title:** RTI Request Tracking and Deadline Compliance Monitoring System  
**Student:** Sangana Sai Neha Reddy  
**Register Number:** 24MIC0050  
**Programme:** Integrated M.Tech in Computer Science and Engineering  
**Institution:** Vellore Institute of Technology

## References

- Government of India — Right to Information Act, 2005
- [RTI Online Portal](https://www.rtionline.gov.in/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/index.html)
- [Spring Security Documentation](https://docs.spring.io/spring-security/reference/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## License

This project was developed for academic and educational purposes. Add a suitable open-source license if you intend to permit reuse or redistribution.
