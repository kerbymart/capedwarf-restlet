# Use an image with Java installed
FROM eclipse-temurin:8-jre

LABEL authors="Kerby"
LABEL version="1.0"

# Set the CapeDwarf version
ENV CAPEDWARF_VERSION=2.0.0.Final
ENV CAPEDWARF_HOME=/var/lib/capedwarf

# Install unzip, download and extract CapeDwarf, and clean up in one RUN to reduce layers and image size
RUN apt-get update && apt-get install -y unzip && \
    wget https://download.jboss.org/capedwarf/CapeDwarf_WildFly_${CAPEDWARF_VERSION}.zip && \
    unzip CapeDwarf_WildFly_${CAPEDWARF_VERSION}.zip -d /var/lib/tmp && \
    mv /var/lib/tmp/CapeDwarf_WildFly_${CAPEDWARF_VERSION} $CAPEDWARF_HOME && \
    rm CapeDwarf_WildFly_${CAPEDWARF_VERSION}.zip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy the WAR file to the deployments directory and prepare for deployment
COPY ./deployments/ROOT.war $CAPEDWARF_HOME/standalone/deployments/
RUN touch $CAPEDWARF_HOME/standalone/deployments/ROOT.war.dodeploy

# Expose necessary ports
EXPOSE 8080 9990 8787

# Set the working directory to the CapeDwarf home
WORKDIR $CAPEDWARF_HOME

# Use entrypoint for starting CapeDwarf
ENTRYPOINT ["/bin/sh", "-c", "$CAPEDWARF_HOME/bin/standalone.sh -b 0.0.0.0 -c standalone-capedwarf.xml"]