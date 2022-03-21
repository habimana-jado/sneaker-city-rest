# sneaker-city EShop Displaying latest sneakers and placing them in cart

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [How to run](#how-to-run)

## General Info

This project is a coding challenge application that allows registration/viewing and cart manipulation of shoes in respect to their size availability.
This is a backend application only.
  
## Technologies
This project is created with:
* Java 8 - Spring boot V 2.5.2
* Hibernate 4.3.1
* Maven V 3.6.2

## How to run
Project is implemented in Java 8 Spring boot V 2.5.2 with maven V 3.6.2

To start: 
* Install Jdk 1.8 and above
* Install maven
* Install Postgres Database and adjust application.properties located in resources(Db username, Db password and create Database sneakercity_db)
* Run command "mvn clean install -DskipTests" at root directory to install required dependencies
* Run Java Main class 'SneakerCityRest' or run command "mvn spring-boot:run" at root directory to start the application

Note: The application is running on port 8080. You can change it by changing server.port in application.properties

After starting the application, use Curl or postman to make requests.

Key endpoints exposed include:

  * POST  http://localhost:8080/register-product                  For registering new Product with its sizes available
  * GET   http://localhost:8080/find-available-products           For Viewing registered Products
  * GET   http://localhost:8080/find-available-size/{productId}   For Viewing size available based on one product
  
  
  * POST  http://localhost:8080/add-cart                          For adding shoe into cart
  * GET   http://localhost:8080/view-cart                         For Viewing shoes in cart
  * GET   http://localhost:8080/checkout-cart                     For completing all cart shoes purchase 
  


Register Product with available sizes Sample Object
{
    "brandName": "Nike",
    "model": "Air Force 1",
    "price": 5000.0,
    "releaseDate": "2001-03-02",
    "productSizes": [
        {
            "description": "Medium",
            "quantity": 20,
            "size": 45
        },
        {
            "description": "Small",
            "quantity": 10,
            "size": 39
        }
    ]
}



Add Product to Cart request Sample Object
{
    "quantity":5,
    "productSizeId":"2dc375de-8fec-4516-b8f3-bde85e6afbe9"
}
