## Ejemplos realizados en el Meetup de Elastic Stack

### Prerequisitos
* Tener instalado Docker
    + [Windows](https://docs.docker.com/docker-for-windows/)
    + [Mac](https://docs.docker.com/docker-for-mac/)
    + [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
    + [Fedora](https://docs.docker.com/install/linux/docker-ce/fedora/)

### Instrucciones
**1.** En la carpeta example-cluster consta la configuración de docker-compose para levantar un cluster de elasticsearch con dos nodos. 
* Para levantar los contenedores, ejecutar:
```console
foo@bar:~$ cd example-cluster
foo@bar:~$ docker-compose up -d
```
* Para detener uno de los servicios (estando dentro de example-cluster):
```console
foo@bar:~$ docker-compose stop es02
```
* Para iniciar el servicio previamente detenido (estando dentro de example-cluster):
```console
foo@bar:~$ docker-compose start es02
```

* ##### URL de Cerebro
    [Cerebro](http://localhost:9000)

    En la url que solicita Cerebro de conexión a elasticsearch poner: http://es01:9200

***

**2.** En la carpeta example-java se encuentra el ejemplo de como enviar logs desde java usando log4j y logback (para ver el ejemplo con logback ir al branch example-logback).
* Para iniciar el Elastic Stack (elasticsearch, filebeat y kibana):
```console
foo@bar:~$ cd example-java/docker
foo@bar:~$ docker-compose up -d
```
* Para generar logs ejecutar los tests que se encuentran en: **meetup-elastic-stack/example-java/src/test/java/com/todo1/meetup/HelloShould.java**
* Se pueden revisar los logs indexados en Elasticsearch desde [Kibana](http://localhost:5601)

***

**3.** En la carpeta log-generator/executable se encuentra el archivo **log-generator.jar** con el cual se pueden generar logs para las prácticas realizadas en el meetup.

* **Instrucciones de uso de la librería**
```console
uso: java -jar log-generator.jar [-d DELAY] [-i ITERATIONS]

argumentos:

  -i ITERATIONS,  Numero de iteraciones. Tenga en cuenta que se pueden
                  generar 5 trazas aleatoriamente en cada iteración. 
                  Valor por defecto: 50

  -d DELAY,       Delay después de cada iteración (en milisegundos).
                  Valor por defecto: 1000


ejemplo:

  java -jar log-generator.jar -d 500 -i 50

  Este ejemplo indica que se realizan 50 iteraciones, con un tiempo 
  de 500ms entre cada iteración.

```

* Para iniciar el Elastic Stack (elasticsearch, filebeat, logstash y kibana):
```console
foo@bar:~$ cd log-generator/docker
foo@bar:~$ docker-compose up -d
```
