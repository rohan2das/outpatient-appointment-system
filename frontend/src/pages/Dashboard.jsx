import { useState, useEffect } from 'react'
import { patientsAPI, doctorsAPI, appointmentsAPI, feedbackAPI } from '../services/api'
import { Users, Stethoscope, Calendar, MessageSquare, TrendingUp } from 'lucide-react'

const Dashboard = () => {
  const [stats, setStats] = useState({
    patients: 0,
    doctors: 0,
    appointments: 0,
    feedback: 0
  })
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const [patientsRes, doctorsRes, appointmentsRes, feedbackRes] = await Promise.all([
          patientsAPI.getAll(),
          doctorsAPI.getAll(),
          appointmentsAPI.getAll(),
          feedbackAPI.getAll()
        ])

        setStats({
          patients: patientsRes.data.length,
          doctors: doctorsRes.data.length,
          appointments: appointmentsRes.data.length,
          feedback: feedbackRes.data.length
        })
      } catch (error) {
        console.error('Error fetching stats:', error)
      } finally {
        setLoading(false)
      }
    }

    fetchStats()
  }, [])

  const statCards = [
    { label: 'Total Patients', value: stats.patients, icon: Users, color: 'bg-blue-500' },
    { label: 'Total Doctors', value: stats.doctors, icon: Stethoscope, color: 'bg-green-500' },
    { label: 'Appointments', value: stats.appointments, icon: Calendar, color: 'bg-purple-500' },
    { label: 'Feedback', value: stats.feedback, icon: MessageSquare, color: 'bg-orange-500' },
  ]

  if (loading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="text-gray-500">Loading dashboard...</div>
      </div>
    )
  }

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Dashboard</h1>
        <p className="text-gray-600 mt-2">Welcome to the Outpatient Appointment System</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
        {statCards.map((stat, index) => {
          const Icon = stat.icon
          return (
            <div key={index} className="bg-white rounded-xl shadow-md p-6">
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-sm text-gray-600 mb-1">{stat.label}</p>
                  <p className="text-3xl font-bold text-gray-800">{stat.value}</p>
                </div>
                <div className={`${stat.color} p-3 rounded-lg`}>
                  <Icon className="w-6 h-6 text-white" />
                </div>
              </div>
            </div>
          )
        })}
      </div>

      <div className="bg-white rounded-xl shadow-md p-6">
        <h2 className="text-xl font-semibold text-gray-800 mb-4">Quick Actions</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <div className="p-4 border border-gray-200 rounded-lg hover:border-primary-300 hover:bg-primary-50 transition-colors cursor-pointer">
            <h3 className="font-medium text-gray-800 mb-2">Schedule Appointment</h3>
            <p className="text-sm text-gray-600">Create a new appointment for a patient</p>
          </div>
          <div className="p-4 border border-gray-200 rounded-lg hover:border-primary-300 hover:bg-primary-50 transition-colors cursor-pointer">
            <h3 className="font-medium text-gray-800 mb-2">Add Doctor</h3>
            <p className="text-sm text-gray-600">Register a new doctor in the system</p>
          </div>
          <div className="p-4 border border-gray-200 rounded-lg hover:border-primary-300 hover:bg-primary-50 transition-colors cursor-pointer">
            <h3 className="font-medium text-gray-800 mb-2">View Reports</h3>
            <p className="text-sm text-gray-600">Check system statistics and reports</p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Dashboard

