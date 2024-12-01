FROM mysql:latest

USER mysql
# Set environment variables for the new user
ENV MYSQL_USER=dba
ENV MYSQL_PASSWORD=$123465789
ENV MYSQL_DATABASE=University

# # Run the following commands to create the new user and grant them the necessary permissions
RUN mysqld
# RUN mysql -u root -p -h 127.0.0.1 -e "CREATE USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';" 
# RUN mysql -u root -p -h 127.0.0.1 -e "GRANT ALL PRIVILEGES ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'%';" 
# RUN mysql -u root -p -h 127.0.0.1 -e "FLUSH PRIVILEGES;"

# EXPOSE 3306

FROM eclipse-temurin:21-jdk-jammy

RUN apt-get update
RUN apt-get install -y python3-pip unzip

# add requirements.txt, written this way to gracefully ignore a missing file
COPY requirements.tx[t] .
RUN ([ -f requirements.txt ] \
    && pip3 install --no-cache-dir -r requirements.txt) \
    || pip3 install --no-cache-dir jupyter jupyterlab

USER root

# Download the kernel release
RUN curl -L https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip > ijava-kernel.zip

# Unpack and install the kernel
RUN unzip ijava-kernel.zip -d ijava-kernel \
    && cd ijava-kernel \
    && python3 install.py --sys-prefix

# RUN pip3 install mysql_kernel \
#     && python3 -m mysql_kernel.install

# Set up the user environment

ENV NB_USER saguileran
ENV NB_UID 1000
ENV HOME /home/$NB_USER

RUN adduser --disabled-password \
    --gecos "Default user" \
    --uid $NB_UID \
    $NB_USER

COPY . $HOME
RUN chown -R $NB_UID $HOME

USER $NB_USER



# Expose port 3306 to allow connections to the database
EXPOSE 3306


# Launch the notebook server
WORKDIR $HOME

CMD ["jupyter", "notebook", "--ip", "0.0.0.0", "--no-browser"]

# to execute use "docker build --tag "mysqljava" ."
# then "docker run --detach 'image_name'"