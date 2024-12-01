FROM ubuntu/mysql:latest

LABEL org.opencontainers.image.authors="saguileran@unal.edu.co"

RUN apt update  && apt -y upgrade
RUN apt install -y python3-pip unzip python3-venv
RUN apt install -y curl wget
RUN apt install -y openjdk-21-jdk
# RUN apt install -y mysql-server

# add requirements.txt, written this way to gracefully ignore a missing file
COPY requirements.tx[t] .
RUN ([ -f requirements.txt ] \
    && pip install --no-cache-dir -r requirements.txt ) \
    || pip install --no-cache-dir jupyter jupyterlab 

    # Download the kernel release
RUN curl -L https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip > ijava-kernel.zip

# Unpack and install the kernel
RUN unzip ijava-kernel.zip -d ijava-kernel \
    && cd ijava-kernel \
    && python3 install.py --sys-prefix

# # Installing mysql kernel
# RUN pip3 install mysql_kernel \
#     && python3 -m mysql_kernel.install

ENV MYSQL_DATABASE=Universidad
ENV MYSQL_USER=dba
ENV MYSQL_PASSWORD=$123456789
ENV MYSQL_ROOT_PASSWORD=$123456789

# Expose port 3306 to allow connections to the database
EXPOSE 3306


# Change mysql to listen on 0.0.0.0
# ADD bind_0.cnf /etc/mysql/conf.d/bind_0.cnf
# # setup our entry point
# ADD init.sh /init.sh
# RUN chmod 755 /*.sh
# ENTRYPOINT ["/init.sh"]

RUN mysql -u root -p ${MYSQL_ROOT_PASSWORD} --protocol=tcp -e "CREATE USER '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD';"
# RUN mysql -u root -h 127.0.0.1 -e "GRANT ALL PRIVILEGES ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'%';"
# RUN mysql -u root -h 127.0.0.1 -e "FLUSH PRIVILEGES;"
# Set up the user environment

ENV NB_USER=saguileran
ENV NB_UID=7777
ENV HOME=/home/$NB_USER

RUN adduser --disabled-password \
    --gecos "Default user" \
    --uid $NB_UID \
    $NB_USER

COPY . $HOME
RUN chown -R $NB_UID $HOME

USER $NB_USER



# Launch the notebook server
WORKDIR $HOME

CMD ["jupyter", "notebook", "--ip", "0.0.0.0", "--no-browser"]

# to execute use "docker build --tag "mysqljava" ."
# then "docker run --detach 'image_name'"
# docker images
# docker run image_id
# https://www.bezkoder.com/docker-compose-spring-boot-mysql/