# Spark Rest Web Service
## Build something using Spark Rest Service
---------------------------------------------

- ### **Add User**
``POST http://localhost:4567/users``
```
{
    "id": "1", 
    "email": "hido9x@gmail.com", 
    "firstName": "Hieu",
    "lastName": "Do"
}
```
*Result*
```
{
    "status": "SUCCESS"
}
```

- ### **Get All User**
``GET http://localhost:4567/users``

*Result*
```
{
    "status": "SUCCESS",
    "data": [
        {
            "id": "1",
            "firstName": "Hieu",
            "lastName": "Do",
            "email": "hido9x@gmail.com"
        }
    ]
}
```

- ### **Get User By ID**
``GET http://localhost:4567/users/:id``

``GET http://localhost:4567/users/1``

*Result*
```
{
    "status": "SUCCESS",
    "data": {
        "id": "1",
        "firstName": "Hieu",
        "lastName": "Do",
        "email": "hido9x@gmail.com"
    }
}
```
- ### **Edit User**
``PUT http://localhost:4567/users/:id``

``PUT http://localhost:4567/users/1``
```
{
    "id": "1", 
    "email": "hido9x@gmail.com", 
    "firstName": "Hang",
    "lastName": "Tran"
}
```
*Result*
```
{
    "status": "SUCCESS",
    "data": {
        "id": "1",
        "firstName": "Hang",
        "lastName": "Tran",
        "email": "hido9x@gmail.com"
    }
}
```

- ### **Delete User By ID**
``DELETE http://localhost:4567/users/:id``

``DELETE http://localhost:4567/users/1``

*Result*
```
{
    "status": "SUCCESS",
    "message": "User deleted"
}
```
- ### **Check Exist User By ID**
``OPTIONS http://localhost:4567/users/:id``

``OPTIONS http://localhost:4567/users/1``

*Result*
```
{
    "status": "SUCCESS",
    "message": "User exists"
}
```

## END
