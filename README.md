<div align=center>

# Parking Control API

<picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://api.iconify.design/simple-icons/spring.svg?color=white&height=60">
    <img align="center" alt="lucjos.in License" src="https://api.iconify.design/simple-icons/spring.svg?color=%230D1117&height=60">
</picture>
<picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://api.iconify.design/ic/twotone-plus.svg?color=white&height=60">
    <img align="center" alt="lucjos.in License" src="https://api.iconify.design/ic/twotone-plus.svg?color=%230D1117&height=60">
</picture>
<picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://api.iconify.design/simple-icons/postgresql.svg?color=white&height=60">
    <img align="center" alt="lucjos.in License" src="https://api.iconify.design/simple-icons/postgresql.svg?color=%230D1117&height=60">
</picture>

<p align="center">
    <br>
    <a href="./LICENSE" target="_blank">
        <picture>
            <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/github/license/lucjosin/parking-control-api?color=%230D1117&style=for-the-badge&labelColor=%230D1117">
            <img align="center" alt="TheWizardProject Twitter" src="https://img.shields.io/github/license/lucjosin/parking-control-api?color=white&style=for-the-badge&labelColor=white">
        </picture>
    </a>
</p>

Parking Control API built with [Spring Boot](https://spring.io) + [PostgreSQL](https://www.postgresql.org/)

</div>

## Dependencies

See [pom](./pom.xml) file.

- Spring Boot;
- Postgres;
- ModelMapper;
- Spring Fox (Swagger).

## Endpoints

> **Note** \
> After running the app, you can open `http://localhost:8080/api/swagger-ui/index.html` to see
more detailed information.

- **[GET]** /api/parkings;
- **[GET]** /api/parkings/{id};
- **[POST]** /api/parkings;
- **[PATCH]** /api/parkings/{id};
- **[DELETE]** /api/parkings/{id};

## Docker

See all [docker](./docker) configuration. \
Also, see [postgres schema](./docker/postgres/migration/1_schema.sql).

Use the `make` command to run/start/delete/stop the docker or [see the complete command](./Makefile).

| Make     | Description                                     |
|----------|-------------------------------------------------|
| dk-run   | Build & Run the local docker.`*`                |
| dk-start | Start the local docker.                         |
| dk-stop  | Stop the local docker.                          |
| dk-reset | Stop, Delete, Build and Start the local docker. |
| dk-prune | Delete all docker volumes.                      |
| help     | Show all available commands.                    |

`*` Use when running this docker for the first time.

