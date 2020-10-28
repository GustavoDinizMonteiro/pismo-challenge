FROM ubuntu:18.04

# Install Basic.
RUN \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update -y && \
  apt-get upgrade -y && \
  apt-get install -y build-essential && \
  apt-get install -y software-properties-common && \
  apt-get install -y git

# Install Java.
RUN \
  apt-get install -y default-jdk

# Install Maven
RUN \
  apt-get install -y maven && \
  rm -rf /var/lib/apt/lists/*

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64

# Set environment variables.
ENV HOME /root

# Define working directory.
WORKDIR /root

# Cloning and install dependencies
RUN \
  git clone https://github.com/GustavoDinizMonteiro/pismo-challenge.git && \
  (cd pismo-challenge && mvn install -DskipTests)

# Define working directory.
WORKDIR /root/pismo-challenge
  
CMD ./mvnw spring-boot:run