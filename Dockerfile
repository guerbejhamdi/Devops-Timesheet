FROM openjdk:8-jdk-alpine
EXPOSE 8090
ADD /target/timesheet-devopss-3.0.war TimesheetDevops.war
ENTRYPOINT ["java", "-jar", "TimesheetDevops.war"]
