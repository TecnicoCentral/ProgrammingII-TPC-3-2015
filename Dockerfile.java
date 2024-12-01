
FROM openjdk:21-jdk-slim

LABEL org.opencontainers.image.authors="saguileran@unal.edu.co"

RUN apt update 
RUN apt install -y python3-pip unzip curl

# add requirements.txt, written this way to gracefully ignore a missing file
COPY requirements.tx[t] .
RUN ([ -f requirements.txt ] \
    && pip3 install --no-cache-dir -r requirements.txt --break-system-packages) \
    || pip3 install --no-cache-dir jupyter jupyterlab --break-system-packages

USER root

# Download the kernel release
RUN curl -L https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip > ijava-kernel.zip

# Unpack and install the kernel
RUN unzip ijava-kernel.zip -d ijava-kernel \
    && cd ijava-kernel \
    && python3 install.py --sys-prefix

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

CMD ["jupyter", "lab", "--ip", "0.0.0.0", "--no-browser"]