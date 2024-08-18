# REST API SPRINGBOOT and WEBPAGE CODEIGNITOR 3

## SpringBoot REST API

This is a sample project using SpingBoot that demonstrates the usage of Postgres for the database.

- `POST /api/lokasi`: Add location data.
- `GET /api/lokasi`: Display all location data in list form.
- `PUT /api/Lokasi`: Update/edit location data.
- `DELETE /api/Lokasi`: Delete location data.

- `POST /api/proyek`: Add project data including project location.
- `GET /api/proyek`: Display all project data including location.
- `PUT /api/proyek`: Update/edit project data.
- `DELETE /api/proyek`: Delete project data.

### PostgreSQL Tables

Creating 3 Tables

1. proyek

   ```sql
   nama_proyek     varchar(255),
   client          varchar(255),
   tgl_mulai       date,
   tgl_selesai     date,
   pimpinan_proyek varchar(255),
   keterangan      varchar(255),
   created_at      timestamp,
   id_pk           integer not null
        constraint proyek_pk
             primary key
   ```

2. lokasi

   ```sql
   id_pk       integer   not null
   constraint lokasi_pk
        primary key,
   nama_lokasi varchar(255),
   negara      varchar(255),
   provinsi    varchar(255),
   kota        varchar(255),
   created_at  timestamp not null
   ```

3. proyek_lokasi

   ```sql
   lokasi_id_pk integer not null
     constraint lokasi_fk
           references lokasi
           on delete cascade,
   proyek_id_pk integer not null
     constraint proyek_fk
           references proyek
           on delete cascade
   ```

## Codeignitor 3

This project is a web application built using the CodeIgniter 3 framework. It interacts with a REST API for managing projects and locations, providing CRUD (Create, Read, Update, Delete) operations for both entities.

### CRUD Operations

The application supports the following operations:

- Projects
- Create new projects
- View a list of projects
- Edit existing projects
- Delete projects
- Locations
- Create new locations
- View a list of locations
- Edit existing locations
- Delete locations
- Adding/Editing Data
- To add or edit data, use the provided forms on the respective pages.
- Data validation is performed before submission.

### Error Handling

Errors are handled within the application, and appropriate messages are displayed to the user.

### Features

- CRUD operations: Easily manage projects and locations.
- Modular design: Clean separation of concerns using the MVC pattern.
- Single View for Editing: Unified view for editing both projects and locations.
- REST API Integration: Seamless interaction with a backend REST API.
- Responsive Design: User-friendly interface compatible with various screen sizes.

## Routes

`/main - Home page listing all projects and locations.`
`/main/add_project - Add a new project.`
`/main/add_location - Add a new location.`
`/main/edit_data/{id}/{type} - Edit a project or location (depending on type).`
`/main/delete_project/{id} - Delete a project.`
`/main/delete_location/{id} - Delete a location.`
