#  Bank Branch Locator 

A full-stack web application for locating Development Bank of Ethiopia branches across the country.

##  Features

- Interactive map showing all DBE branches
- Search branches by district or city
- Geolocation-based branch finding
- Responsive design for mobile and desktop
- Detailed branch information with services offered


##  Getting Started

### Prerequisites

- Java 17 or higher
- Node.js 14 or higher
- Maven
- Git

### Backend Setup

1. Navigate to the backend folder:
   ```bash
   cd backend
2. Run the Spring Boot application:
     ./mvnw spring-boot:run
3. The backend will start on http://localhost:8081

### Frontend Setup

1. Navigate to the frontend folder:
   cd frontend 
2. Install dependencies:
    npm install
3. Start the development server:
    npm start
4. The frontend will open on http://localhost:3000

##  Technology Stack
Backend
Spring Boot 3.5.5 - Java framework

Spring Data JPA - Database operations

H2 Database - In-memory database for development

Maven - Dependency management

Frontend
React 18 - Frontend framework

React Leaflet - Interactive maps

Axios - HTTP client for API calls

CSS3 - Styling

## API Endpoints
GET /api/branches - Get all branches

GET /api/branches/nearest?location={district} - Search branches by location

GET /api/branches/nearby?lat={latitude}&lon={longitude}&radius={km} - Find nearby branches

GET /api/branches/city?city={cityName} - Get branches by city

## Database Schema
The application uses the following main entity:

BankBranch
id (Long) - Primary key

name (String) - Branch name

address (String) - Physical address

city (String) - City name

phone (String) - Contact number

latitude (Double) - Geographic coordinate

longitude (Double) - Geographic coordinate

services (String) - Services offered

## License
This project is developed for educational and demonstration purposes as part of the Development Bank of Ethiopia internship program.
