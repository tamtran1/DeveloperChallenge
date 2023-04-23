from openjdk:18-slim

workdir /tmp

copy . .

run ["javac", "-d", "out/", "-sourcepath", "src/", "src/developerchallenge/app/Process.java"]

entrypoint ["java", "-cp", "out/", "developerchallenge.app.Process"]