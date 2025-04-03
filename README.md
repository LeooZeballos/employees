# Proyecto de Gestión de Vehículos

This project is an employee management system.
It was created as a challenge for the Back End Engineer position at myHotel.

## Table of contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Requirements

- Java 17
- Maven
- MySQL
- Docker (optional)

## Installation

### Steps

1. Clone the repository
2. Create a MySQL database named `hotel_db`. Skip this step if you are using Docker.
3. Create a `app.key` and `app.pub` files in the resources folder. You can generate them using openssl. More info below
   in [OpenSSL](#openssl) section.
4. Run the application using `mvn compile exec:java` or `docker compose up` if you have Docker installed.
5. The application will be running on `http://localhost:9090`.

### OpenSSL

#### Generate a private key

```bash
openssl genpkey -algorithm RSA -out app.key
```

#### Generate a public key

```bash
openssl rsa -pubout -in app.key -out app.pub
```

## Usage

You can find the API documentation in the `src/main/resources/static` folder.
There, you will find
the [Employees.postman_collection.json](src/main/resources/static/Employees.postman_collection.json)
file that contains the Postman collection.

## License

Copyright (c) 2025 Leonel Ayrton Zeballos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
