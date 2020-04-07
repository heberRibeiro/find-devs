FROM maven:3.6.1-jdk-11-slim
COPY . /usr/share/maven/backend
CMD ["clean", "spring-boot:run"]
ENTRYPOINT ["mvn"]
