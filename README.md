# Express Locker Backend

Languages: English | [简体中文](README.zh-CN.md)

Java / Spring Boot backend practice project for an express locker logistics system. It models users, couriers, cabinets, cabinet doors, storage orders, send orders, pickup codes, and basic administration flows.

## What It Covers

| Area | Included modules |
| --- | --- |
| User flows | username login, registration, password update, real-name verification, admin login |
| Locker operations | cabinet listing, add/delete, status switching, available door lookup |
| Storage orders | store parcel by cabinet door, pick parcel by pickup code |
| Courier orders | courier send order creation, courier order lookup, pickup by send code |
| Persistence | MyBatis-Plus mappers and XML mapper files for MySQL-backed data access |
| Caching | Redis configuration and Caffeine dependency for cache-oriented practice |

## Tech Stack

- Java 8
- Spring Boot 2.6
- Spring Web
- MyBatis-Plus
- MySQL connector
- Redis
- Maven
- JUnit 5 / Spring Boot test

## Project Structure

```text
express-locker-backend/
├─ src/main/java/com/yexuhang/express/
│  ├─ bean/                 # entity classes
│  ├─ config/               # shared result wrapper, Redis config, generator helper
│  ├─ controller/           # REST controllers
│  ├─ dto/                  # request DTOs
│  ├─ mapper/               # MyBatis-Plus mapper interfaces
│  └─ service/              # service interfaces and implementations
├─ src/main/java/com/yexuhang/express/mapper/xml/
├─ src/test/java/com/yexuhang/express/
├─ pom.xml
└─ README.md
```

## API Map

| Controller | Base path | Example endpoints |
| --- | --- | --- |
| `UsersController` | `/users` | `POST /login/username`, `POST /register`, `POST /admin/login`, `GET /details` |
| `CabinetsController` | `/cabinets` | `POST /all`, `POST /add`, `POST /delete`, `POST /setStatus` |
| `CabinetDoorsController` | `/cabinetDoors` | `GET /{cabinetId}/{sizeType}/availableDoors` |
| `StorageOrdersController` | `/storageOrders` | `POST /storeExpress`, `POST /pickExpress` |
| `SendExpressOrdersController` | `/sendExpressOrders` | `POST /sendExpress`, `GET /{courierId}/orders`, `POST /pickExpress` |
| `ExpressOrdersController` | `/expressOrders` | `POST /{cabinetId}/getAllExpressOrders`, `POST /pickExpressOrderByPickCode`, `POST /addExpressOrder` |

## Quick Start

Prerequisites:

- JDK 8 or newer
- Maven 3.8 or newer
- MySQL and Redis if you want to run the full application locally

Run the test suite:

```bash
mvn test
```

Build the project:

```bash
mvn package
```

Run the application after adding your local database and Redis configuration:

```bash
mvn spring-boot:run
```

This repository intentionally does not commit production credentials or local database connection strings. Use local environment-specific configuration outside Git for real deployments.

## Current Status

This is a learning and portfolio backend project, not a packaged production service. The repository is useful for reviewing Spring Boot controller/service/mapper structure, MyBatis-Plus usage, and logistics-domain API practice.

## Contributing

Small improvements are welcome. Good first contributions include:

- adding redacted example configuration
- documenting database schema assumptions
- adding controller/service tests
- improving validation and error messages
- tightening CORS and security defaults for deployment examples

See [CONTRIBUTING.md](CONTRIBUTING.md) before opening a pull request.

## Support

If this project saves you time, you can support future maintenance here: [Buy Me a Coffee](https://www.buymeacoffee.com/aolingge).

## License

MIT
