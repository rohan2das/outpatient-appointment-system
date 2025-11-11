# Outpatient Appointment System - Frontend

A modern React frontend for the Outpatient Appointment System built with Vite, React Router, and Tailwind CSS.

## Features

- 🎨 Modern, responsive UI with Tailwind CSS
- 🔐 Authentication (Login/Register)
- 👥 Patient Management
- 👨‍⚕️ Doctor Management
- 📅 Appointment Scheduling
- ⏰ Availability Management
- ⭐ Feedback System
- 🛡️ Admin Management
- 📊 Dashboard with Statistics

## Tech Stack

- **React 18** - UI library
- **Vite** - Build tool
- **React Router** - Routing
- **Tailwind CSS** - Styling
- **Axios** - HTTP client
- **Lucide React** - Icons

## Getting Started

### Prerequisites

- Node.js 16+ and npm/yarn
- Backend server running on `http://localhost:7007`

### Installation

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend will be available at `http://localhost:3000`

### Building for Production

```bash
npm run build
```

The built files will be in the `dist` directory.

## Project Structure

```
frontend/
├── src/
│   ├── components/      # Reusable components
│   │   └── Layout.jsx   # Main layout with sidebar
│   ├── context/         # React context
│   │   └── AuthContext.jsx
│   ├── pages/          # Page components
│   │   ├── Login.jsx
│   │   ├── Register.jsx
│   │   ├── Dashboard.jsx
│   │   ├── Patients.jsx
│   │   ├── Doctors.jsx
│   │   ├── Appointments.jsx
│   │   ├── Availability.jsx
│   │   ├── Feedback.jsx
│   │   └── Admins.jsx
│   ├── services/        # API services
│   │   └── api.js
│   ├── App.jsx         # Main app component
│   ├── main.jsx        # Entry point
│   └── index.css       # Global styles
├── index.html
├── package.json
├── vite.config.js
└── tailwind.config.js
```

## API Integration

The frontend communicates with the backend API running on `http://localhost:7007`. All API calls are centralized in `src/services/api.js`.

## Features Overview

### Dashboard
- Overview statistics (patients, doctors, appointments, feedback)
- Quick action cards

### Patient Management
- View all patients
- Create/Edit/Delete patients
- Search functionality

### Doctor Management
- View all doctors
- Create/Edit/Delete doctors
- Filter by specialization
- View available doctors

### Appointment Management
- Schedule appointments
- View all appointments
- Approve/Reject/Cancel appointments
- Filter by status

### Availability Management
- Set doctor availability dates and times
- View active availability
- Manage availability schedules

### Feedback System
- Submit feedback with ratings
- View all feedback
- Filter by patient or doctor

### Admin Management
- Manage administrator accounts
- View admin details

## Development

The app uses Vite for fast development with HMR (Hot Module Replacement). Changes to files will automatically reload in the browser.

## Notes

- The login is currently a mock implementation. In production, you should implement proper authentication with JWT tokens.
- All API endpoints are configured to work with the backend on port 7007.
- The app uses localStorage for session management (mock implementation).

