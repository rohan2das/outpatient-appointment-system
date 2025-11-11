import axios from 'axios'

const API_BASE_URL = 'http://localhost:7007/api'

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
})

// Auth API
export const authAPI = {
  register: (userData) => api.post('/auth/register', userData),
}

// Patients API
export const patientsAPI = {
  getAll: () => api.get('/patients'),
  getById: (id) => api.get(`/patients/${id}`),
  getByUserId: (userId) => api.get(`/patients/user/${userId}`),
  create: (patient) => api.post('/patients', patient),
  update: (id, patient) => api.put(`/patients/${id}`, patient),
  delete: (id) => api.delete(`/patients/${id}`),
}

// Doctors API
export const doctorsAPI = {
  getAll: () => api.get('/doctors'),
  getById: (id) => api.get(`/doctors/${id}`),
  getByUserId: (userId) => api.get(`/doctors/user/${userId}`),
  getAvailable: () => api.get('/doctors/available'),
  getBySpecialization: (specialization) => api.get(`/doctors/specialization/${specialization}`),
  create: (doctor) => api.post('/doctors', doctor),
  update: (id, doctor) => api.put(`/doctors/${id}`, doctor),
  delete: (id) => api.delete(`/doctors/${id}`),
}

// Appointments API
export const appointmentsAPI = {
  getAll: () => api.get('/appointments'),
  getById: (id) => api.get(`/appointments/${id}`),
  getByPatient: (patientId) => api.get(`/appointments/patient/${patientId}`),
  getByDoctor: (doctorId) => api.get(`/appointments/doctor/${doctorId}`),
  getByStatus: (status) => api.get(`/appointments/status/${status}`),
  getDoctorAppointmentsForDay: (doctorId, date) => 
    api.get(`/appointments/doctor/${doctorId}/date`, { params: { date } }),
  create: (appointment) => api.post('/appointments', appointment),
  update: (id, appointment) => api.put(`/appointments/${id}`, appointment),
  approve: (id) => api.put(`/appointments/${id}/approve`),
  reject: (id) => api.put(`/appointments/${id}/reject`),
  cancel: (id) => api.put(`/appointments/${id}/cancel`),
  delete: (id) => api.delete(`/appointments/${id}`),
}

// Availability API
export const availabilityAPI = {
  getAll: () => api.get('/availability'),
  getById: (id) => api.get(`/availability/${id}`),
  getByDoctor: (doctorId) => api.get(`/availability/doctor/${doctorId}`),
  getActiveByDoctor: (doctorId) => api.get(`/availability/doctor/${doctorId}/active`),
  getByDoctorAndDate: (doctorId, date) => 
    api.get(`/availability/doctor/${doctorId}/date`, { params: { date } }),
  create: (availability) => api.post('/availability', availability),
  update: (id, availability) => api.put(`/availability/${id}`, availability),
  delete: (id) => api.delete(`/availability/${id}`),
}

// Feedback API
export const feedbackAPI = {
  getAll: () => api.get('/feedback'),
  getById: (id) => api.get(`/feedback/${id}`),
  getByDoctor: (doctorId) => api.get(`/feedback/doctor/${doctorId}`),
  getByPatient: (patientId) => api.get(`/feedback/patient/${patientId}`),
  create: (feedback) => api.post('/feedback', feedback),
  update: (id, feedback) => api.put(`/feedback/${id}`, feedback),
  delete: (id) => api.delete(`/feedback/${id}`),
}

// Admins API
export const adminsAPI = {
  getAll: () => api.get('/admins'),
  getById: (id) => api.get(`/admins/${id}`),
  create: (admin) => api.post('/admins', admin),
  update: (id, admin) => api.put(`/admins/${id}`, admin),
  delete: (id) => api.delete(`/admins/${id}`),
}

// Users API (if needed)
export const usersAPI = {
  getAll: () => api.get('/users'),
  getById: (id) => api.get(`/users/${id}`),
}

export default api

