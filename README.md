CRUD API

The REST API performs CRUD operations on Animal objects as described below.

API Endpoints

Use POSTMAN to try the following endpoints:
Get list of Animals
Request

`GET /animal/all`

`http://localhost:8080/animal/all`

Get a specific Animal
Request

GET /animal/{animalId}

http://localhost:8080/animal/1

Get all animals containing the name blue
Request

GET /animal?name={name}

http://localhost:8080/animal?name=blue

Create a new Animal
Request

`POST /animal/new`

`http://localhost:8080/animal/new` --data '{ "name": "sample4", "scientificName" :"sample", "animalClass": "cat", "habitat": "home", "description": "may be fiesty"}'

Update an existing animal
Request

`PUT /animal/update/{animalId}`

`http://localhost:8080/animal/update/1` --data '{ "name": "sample14", "scientificName" :"simple", "animalClass": "dog", "habitat": "house", "description": "cannot be fiesty"}'

Delete an existing Animal
Request

`DELETE /animal/delete/{animalId}`

`http://localhost:8080/animal/delete/1`
