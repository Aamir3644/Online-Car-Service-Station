import React, { useState, useEffect } from 'react';
import { getAppointmentByOutletId, updateAppointmentStatus } from './services/user';
import { useHistory  } from 'react-router-dom';

const AdminDashboard = () => {
  const [appointments, setAppointments] = useState([]);

  const outletId = sessionStorage.getItem('outletId');

  const history = useHistory()

  useEffect(() => {
    const fetchAppointments = async () => {
      try {
        const response = await getAppointmentByOutletId(outletId);
        console.log("Appointment details:", response.data);
        setAppointments(response.data);
      } catch (error) {
        console.error("Error fetching appointments:", error);
      }
    };

    fetchAppointments();
  }, [outletId]);

  const updateStatus = async (id) => {
    try {
      // Update status in the database
      await updateAppointmentStatus(id, true); // Pass true as the new status

      // Update status in the state
      setAppointments((prevAppointments) =>
        prevAppointments.map((appointment) =>
          appointment.appointmentId === id
            ? { ...appointment, status: true } // Update status to true
            : appointment
        )
      );
    } catch (error) {
      console.error("Error updating status:", error);
    }
  };

  const getStatusColor = (status) => {
    return status ? 'text-success' : 'text-danger';
  };

  const navigateToPayments = () => {
    // Navigate to the payments page
    history.push('/PaymentList');
  };

  return (
    <div className="container mt-5">
        <div className="d-flex justify-content-end mb-3">
        <button className="btn btn-primary" onClick={navigateToPayments}>
          View Payments
        </button>
      </div>
      <h1 className="mb-4">Admin Dashboard</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Username</th>
            <th>Car Manufacturer</th>
            <th>Car Model</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {appointments.map((appointment) => (
            <tr key={appointment.appointmentId}>
              <td>{appointment.appointmentDate}</td>
              <td>{appointment.appointmentTime}</td>
              <td>{appointment.user.fname} {appointment.user.lname}</td>
              <td>{appointment.manufacturer.manufacturerName}</td>
              <td>{appointment.model.modelName}</td>
              <td className={getStatusColor(appointment.status)}>
                {appointment.status ? 'Serviced' : 'Pending'}
              </td>
              <td>
                {!appointment.status && (
                  <button
                    className="btn btn-success"
                    onClick={() => updateStatus(appointment.appointmentId)}
                  >
                    Mark as Serviced
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AdminDashboard;
