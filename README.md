# TWIC_Rest_Server

## Server

Once the server launched, you can access to the main page with the address http://localhost:8080/home

## API Villes

This is a Java-based API that exposes CRUD operations on a database of French cities.

### Prerequisites

- Java 8 or higher
- Spring Framework
- Maven

### How to use

1. Clone the repository to your local machine.

2. Build the project with Maven.

3. Run the API on a local or remote server.

4. Use HTTP methods to interact with the API:
  - **GET /api/all-villes**: Retrieves all cities from the database.
  - **GET /api/villes?codeInsee=<codeInsee>**: Retrieves a city from the database based on its INSEE code.
  - **POST /api/villes**: Inserts a new city into the database.
  - **PUT /api/villes**: Updates an existing city in the database.
  - **DELETE /api/villes?codeInsee=<codeInsee>**: Deletes a city from the database based on its INSEE code.

### Example usage

To retrieve all cities from the database, make a GET request to http://localhost:8080/api/all-villes.

To insert a new city into the database, make a POST request to http://localhost:8080/api/villes with the following parameters:

- **codeInsee**: The INSEE code of the city.
- **nom**: The name of the city.
- **codePostal**: The postal code of the city.
- **libelle**: The label of the city.
- **ligne**: The line of the city.
- **latitude**: The latitude of the city.
- **longitude**: The longitude of the city.
