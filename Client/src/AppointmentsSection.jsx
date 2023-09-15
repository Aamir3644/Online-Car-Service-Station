import React from 'react';
import { Table } from 'react-bootstrap';

const AppointmentsSection = () => {
  const appointments = [
    { id: 1, date: '2023-09-01', time: '10:00 AM', status: 'Scheduled' },
    { id: 2, date: '2023-09-02', time: '11:30 AM', status: 'Completed' },
    // ... More appointments
  ];

  console.log('AppointmentsSection rendered');
  return (
    <div>
      <h2>Appointments</h2>
      <Table striped bordered responsive>
        <thead>
          <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {appointments.map(appointment => (
            <tr key={appointment.id}>
              <td>{appointment.id}</td>
              <td>{appointment.date}</td>
              <td>{appointment.time}</td>
              <td>{appointment.status}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default AppointmentsSection;
