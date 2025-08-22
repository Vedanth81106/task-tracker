![Java](https://img.shields.io/badge/Java-24-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![React](https://img.shields.io/badge/React-18-blue)

# Task Tracker

A full-stack **Task Management Application** built with **Spring Boot, PostgreSQL, and React**.  
It allows users to create and manage task lists, track progress, and organize tasks efficiently.  

---

##  Features
-  Create, update, delete task lists
-  Add and manage individual tasks within lists
-  Track progress of each list (based on completed tasks)
-  Data stored in **PostgreSQL**
-  RESTful API built with **Spring Boot**
-  Frontend with **React + Vite**
-  Exception handling and validations

---

### Note
This project was developed as part of my learning journey.  
- The **backend (Spring Boot + PostgreSQL)** was fully implemented by me.  
- The **frontend (React)** was adapted from a tutorial while I focused mainly on backend integration and API development.  

Future plans include building my own custom frontend and adding features like authentication, JWT security, and Docker deployment.

---

## Tech Stack
**Backend**
- Java 24
- Spring Boot 3
- Spring Data JPA
- PostgreSQL

**Frontend**
- React
- Vite
- TailwindCSS 

---

## Getting Started

### Prerequisites
Make sure you have the following installed:
- [Java 24](https://www.oracle.com/java/technologies/downloads/)  
- [Maven](https://maven.apache.org/)  
- [PostgreSQL](https://www.postgresql.org/)  
- [Node.js & npm](https://nodejs.org/) (for frontend)

---
### Backend Setup (Spring Boot)
#### 1. Clone the repository:
```bash
   git clone https://github.com/Vedanth81106/task-tracker.git
   cd task-tracker/backend
```
   
#### 2. Update application.properties with your PostgreSQL configuration:
```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/tasktracker
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
```
#### 3. Run the backend:
```bash
  mvn spring-boot:run
```
The backend will start at:
http://localhost:8080/api

### Frontend Setup (React)

#### 1. Navigate to frontend folder:
```bash
  cd ../frontend
```
#### 2. Install dependencies:
```bash
  npm install
```
#### 3. Run the frontend:
```bash
  npm run dev
```
The frontend will run at:
 http://localhost:5173/

## API Endpoints

### Task Lists
- `GET /api/task-lists` - Get all task lists
- `POST /api/task-lists` - Create a new task list  
- `GET /api/task-lists/{id}` - Get task list by ID
- `PUT /api/task-lists/{id}` - Update task list
- `DELETE /api/task-lists/{id}` - Delete task list

### Tasks
- `GET /api/task-lists/{task-list-id}/tasks` - Get all tasks in a task list
- `POST /api/task-lists/{task-list-id}/tasks` - Create a new task
- `GET /api/task-lists/{task-list-id}/tasks/{task-id}` - Get task by ID
- `PUT /api/task-lists/{task-list-id}/tasks/{task-id}` - Update a task
- `DELETE /api/task-lists/{task-list-id}/tasks/{task-id}` - Delete a task

## Screenshots

<img width="563" height="364" alt="image" src="https://github.com/user-attachments/assets/679d5eeb-20f8-4bc6-994f-5f69d95dec96" />

<img width="870" height="589" alt="image" src="https://github.com/user-attachments/assets/8166d4c7-fd4b-473b-b672-f60b9b288987" />

<img width="600" height="620" alt="image" src="https://github.com/user-attachments/assets/30433c02-c663-4381-90f1-6f8f6cde471c" />


