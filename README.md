# Saas Product Import project
SaaS Products Import test project.

This project generates an executable jar file called **import.jar**.
The executable can be found in the *\target* folder of the project.

#Where to find the project
The code and executables can be downloaded from the following public GitHub repository.

````
https://github.com/Feldetestas/getApp
````

## Prerequisites
### To compile the project
The following are the components that need to be installed in order to compile the project.

- Java SDK v1.8.0_152
- Maven v3.3.9

### To run the importer tool
The following are the components that need to be installed in order to run the importer tool.

- JRE v1.8.0_152

##Using the importer.jar
The executable jar file expects two parameters:

- The provider's name
- The path to the source file.

If the parameters are incorrect and error will be displayed.

There are two known providers using different formats:

- capterra: The source format is a *yaml* file.
- softwareadvice: The source format is  a *json* file.

The following are examples of how to use the tool

````
java -jar import.jar capterra \path\capterra.yaml
````

````
java -jar import.jar softwareadvice \path\softwareadvice.json
```` 

#Future lines

* We could create a webservice exposing an import method. The web service could have the following signature. This import end-point would do job our current executable jar file is doing.


````
 @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("getapp/{provider}")
````

````
    public Response import(@PathParam("provider") String providerName)
```` 

* With the webservice in place we could just a web application to allow our providers to directly upload the files.

* We could consider to use a more complex architecture using for example a platform like Apache Kafka, where we could have our different producers, like the providers, and our consumers that would be any application that is interested in the imported data. 



