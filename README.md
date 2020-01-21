# Adverts API Server

This is a study project for EPAM Course

## Installation


1. Download and install [PostgreSQL](https://www.postgresql.org/download/)
2. Run PostgreSQL Server and create database `adverts_db` with user `admin` and password `pass`
3. Create tables (schemas are described below)
4. Clone git repository to your local computer
5. Open project in Intellij IDEA Ultimate
6. Run Tomcat Server

## Database schemas

Table `customer` :
```sql
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL
);
```

Table `advert` :
```sql
CREATE TABLE advert (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    title VARCHAR(350) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    advert_category VARCHAR(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    creation_date DATE NOT NULL
);
```

## Documentation

### 1. Customer

#### 1.1 Add customer

Request: `POST /api/customer`

Request Headers:
```
Content-Type: application/json
Accept: application/json
```

Request body:
```
{
    "firstName": STRING,
    "lastName": STRING,
    "email": STRING,
    "category": ENUM("INDIVIDUAL", "ENTITY")
}
```

Response body:
```
{
    "id": INTEGER
    "firstName": STRING,
    "lastName": STRING,
    "email": STRING,
    "category": ENUM("INDIVIDUAL", "ENTITY")
}
```

Response status: `201 CREATED`

#### 1.2 Get customer by id

Request: `GET /api/customer/{id}`

Request Headers:
```
Accept: application/json
```

Response body:
```
{
    "id": INTEGER
    "firstName": STRING,
    "lastName": STRING,
    "email": STRING,
    "category": ENUM("INDIVIDUAL", "ENTITY")
}
```

Response status: `200 OK`

### 2. Advert

#### 2.1 Add advert

Request: `POST /api/adverts`

Request Headers:
```
Content-Type: application/json
Accept: application/json
```

Request body:
```
{
    "userId": INTEGER,
    "title": STRING,
    "content": STRING,
    "advertCategory": ENUM("FOR_SALE", "SERVICES", "JOBS", "HOUSING")
    "phoneNumber": STRING
}
```

Response body:
```
{
    "id": INTEGER
    "userId": INTEGER,
    "title": STRING,
    "content": STRING,
    "advertCategory": ENUM("FOR_SALE", "SERVICES", "JOBS", "HOUSING")
    "phoneNumber": STRING
}
```

Response status: `201 CREATED`

#### 2.2 Get advert by id

Request: `GET /api/adverts/{id}`

Request Headers:
```
Accept: application/json
```

Response body:
```
{
    "id": INTEGER
    "userId": INTEGER,
    "title": STRING,
    "content": STRING,
    "advertCategory": ENUM("FOR_SALE", "SERVICES", "JOBS", "HOUSING")
    "phoneNumber": STRING
}
```

Response status: `200 OK`

#### 2.3 Get adverts by customer id

Request: `GET /api/customer/{id}/adverts`

Request Headers:
```
Accept: application/json
```

Response body:
```
[
    {
        "id": INTEGER
        "userId": INTEGER,
        "title": STRING,
        "content": STRING,
        "advertCategory": ENUM("FOR_SALE", "SERVICES", "JOBS", "HOUSING")
        "phoneNumber": STRING
    }
]
```

Response status: `200 OK`

#### 2.4 Get all adverts

Request: `GET /api/adverts`

Request Headers:
```
Accept: application/json
```

Response body:
```
[
    {
        "id": INTEGER
        "userId": INTEGER,
        "title": STRING,
        "content": STRING,
        "advertCategory": ENUM("FOR_SALE", "SERVICES", "JOBS", "HOUSING")
        "phoneNumber": STRING
    }
]
```

Response status: `200 OK`

#### 2.5 Delete advert

Request: `DELETE /adverts/{id}`

Response status: `204 NO CONTENT`