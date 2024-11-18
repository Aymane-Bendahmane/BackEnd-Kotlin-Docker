# Practice App 
## Description
A kotlin/spring boot app includes unit testing  and docker config

## Prerequisites
How to use the app in docker container
Before running the Docker container, ensure that you have the following prerequisites installed:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)

## Usage

### Build the Docker Image
To build the Docker image for your Java application, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the root directory of your Java application project.
3. Run the following command to build the Docker image:
   ```shell
   docker build -t your-image-name .
Replace your-image-name with the desired name for your Docker image.

###  Configuration
You can configure your application using environment variables passed to the Docker container. The following environment variables are available:

1. DATABASE_URL: URL of the PostgreSQL database (e.g., jdbc:postgresql://localhost:5432/products)
2. DATABASE_USERNAME: Username for the database connection
3. DATABASE_PASSWORD: Password for the database connection
Make sure to set these environment variables according to your specific database configuration.
###  Run the Docker Container
Once the Docker image is built, you can run a container based on it. Follow these steps:

Open a terminal or command prompt.
Run the following command to start the Docker container:
   ```shell
   docker-compose up -d 

