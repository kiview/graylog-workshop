Graylog Workshop
================

Getting Started
---------------

Start the Graylog server and the databases using `docker-compose`:
```
docker-compose up
```

Checkout the Graylog web interface is running on `localhost:9000`.
Username and password is `admin`.

Configure a UPD GELF input for your Graylog node and check everything is working by manually sending a message using `Ncat`:
```
echo '{"version": "1.1","host":"example.org","short_message":"A short message that helps you identify what is going on","full_message":"Backtrace here\n\nmore stuff","level":1,"_user_id":9001,"_some_info":"foo","_some_env_var":"bar"}' | nc -u -w 1 localhost 12201
```

Try out the Spring-Boot app
---------------------------

Start the Spring-Boot demo app using the dedicated `docker-compose` file:
```
docker-compose -f docker-compose-app.yml -p graylog-sping-demo-app up
```

Checkout the existing logging behaviour by testing the exposed REST endpoints:
* `/log`
* `/warn`
* `/errorLog`
* `/exception`
```
curl localhost:8080/info
```

Configure the Docker Log Driver
-------------------------------

Next we want to configure the container of the Spring-Boot app to use the Docker GELF log driver.
Log at the [officla docs](https://docs.docker.com/config/containers/logging/gelf/) to find out how to do it.
Docker-Compose also provides support for configuring the log driver: https://docs.docker.com/compose/compose-file/compose-file-v2/#logging