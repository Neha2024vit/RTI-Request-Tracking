RTI Request Tracking System - Login Upgrade
Requirements: JDK 17, MySQL 8, Eclipse with Maven.
1. In MySQL run: CREATE DATABASE rti_tracking;
2. Edit src/main/resources/application.properties: replace CHANGE_ME with your MySQL password and change the officer password.
3. Eclipse: File > Import > Maven > Existing Maven Projects; select the extracted folder containing pom.xml.
4. Right-click project > Maven > Update Project.
5. Run RtiTrackingApplication.java and open http://localhost:8080/
Citizen: use Sign Up, then log in.
Officer: officer@rti.gov.in with configured rti.officer.password. Initial account is created only if email doesn't already exist.
Hibernate ddl-auto=update should preserve tables and add owner_id. Existing older requests have no owner and remain visible to officers but not citizens. Back up database first.
Academic local prototype only: CSRF is disabled for simplicity; configure CSRF and HTTPS before public deployment.