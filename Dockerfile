FROM openjdk:8-jre-alpine

ENV HOME=/home/robot-controller_felipe_lucas

WORKDIR $HOME

ADD robot-controller_felipe_lucas.jar robot-controller_felipe_lucas.jar

CMD ["java", "-jar", "robot-controller_felipe_lucas.jar"]