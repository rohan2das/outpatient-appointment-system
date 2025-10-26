#!/bin/bash

echo "🧪 Testing Outpatient Appointment System API Endpoints"
echo "=================================================="

BASE_URL="http://localhost:7007"

echo ""
echo "1. Testing User Registration..."
echo "POST $BASE_URL/api/auth/register"
curl -X POST $BASE_URL/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "patient1",
    "password": "password123",
    "fullName": "John Doe",
    "email": "john.doe@example.com",
    "role": "PATIENT"
  }' \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "2. Testing Doctor Registration..."
echo "POST $BASE_URL/api/auth/register"
curl -X POST $BASE_URL/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "doctor1",
    "password": "password123",
    "fullName": "Dr. Jane Smith",
    "email": "dr.jane@hospital.com",
    "role": "DOCTOR"
  }' \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "3. Testing Admin Registration..."
echo "POST $BASE_URL/api/auth/register"
curl -X POST $BASE_URL/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin1",
    "password": "password123",
    "fullName": "Admin User",
    "email": "admin@hospital.com",
    "role": "ADMIN"
  }' \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "4. Testing Get All Users..."
echo "GET $BASE_URL/api/users"
curl -X GET $BASE_URL/api/users \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "5. Testing Get All Patients..."
echo "GET $BASE_URL/api/patients"
curl -X GET $BASE_URL/api/patients \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "6. Testing Get All Doctors..."
echo "GET $BASE_URL/api/doctors"
curl -X GET $BASE_URL/api/doctors \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "7. Testing Get All Appointments..."
echo "GET $BASE_URL/api/appointments"
curl -X GET $BASE_URL/api/appointments \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "8. Testing Get All Admins..."
echo "GET $BASE_URL/api/admins"
curl -X GET $BASE_URL/api/admins \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "9. Testing Get All Availability Dates..."
echo "GET $BASE_URL/api/availability"
curl -X GET $BASE_URL/api/availability \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "10. Testing Get All Feedback..."
echo "GET $BASE_URL/api/feedback"
curl -X GET $BASE_URL/api/feedback \
  -H "Content-Type: application/json" \
  -w "\nStatus: %{http_code}\n" \
  -s

echo ""
echo "✅ API Testing Complete!"
echo "=================================================="
