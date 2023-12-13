import React, { useState, useEffect } from 'react';
import NavBar from './Navbar2';
import userLogo from './images/user-logo.png';
import { getAppointmentById } from './services/user';

const UserProfile = () => {

const fname = sessionStorage.getItem('fname');
const lname = sessionStorage.getItem('lname');
const userEmail = sessionStorage.getItem('email');
const userId = sessionStorage.getItem('userId');

  const [activeTab, setActiveTab] = useState('profile');
  const [appointments, setAppointments] = useState([]);

  // Fetching Appointment on First Page Render
  useEffect(() => {

    const fetchAppointments = async () => {
      // Axios Call to fetch appointments from DB
      const response = await getAppointmentById(userId);
      console.log("appointment details : ",response.data);
      setAppointments(response.data);
    };

    fetchAppointments();
  }, []);

  const handleTabChange = (tab) => {
    setActiveTab(tab);
  };

  return (
    <>
      <NavBar />
      <br />
      <br />
      <div className="container-fluid mt-5">
        <div className="row justify-content-center">
          <div className="col-12 col-md-8">
            <div className="card">
              <div className="card-header">
                <ul className="nav nav-tabs card-header-tabs">
                  <li className="nav-item">
                    <button
                      className={`nav-link ${activeTab === 'profile' ? 'active' : ''}`}
                      onClick={() => handleTabChange('profile')}
                    >
                      My Profile
                    </button>
                  </li>
                  <li className="nav-item">
                    <button
                      className={`nav-link ${activeTab === 'appointments' ? 'active' : ''}`}
                      onClick={() => handleTabChange('appointments')}
                    >
                      My Appointments
                    </button>
                  </li>
                </ul>
              </div>
              <div className="card-body">
                {activeTab === 'profile' && (
                  <div className="user-details">
                    <div className="text-center">
                      <img
                        src={userLogo} 
                        width={100}
                        alt="User"
                        className="user-image img-fluid rounded-circle"
                      />
                    </div>
                    <p>First Name : {fname}</p>
                    <p>Last Name : {lname}</p>
                    <p>Email : {userEmail}</p>
                  </div>
                )}
                {activeTab === 'appointments' && (
  <div className="user-appointments" style={{ maxHeight: '400px', overflowY: 'auto' }}>
    <div className="appointment-list">
      {appointments.map((appointment) => (
        <div key={appointment.id} className="appointment-item">
          <p>Date: {appointment.appointmentDate}</p>
          <p>Time: {appointment.appointmentTime}</p>
          <p>
            Status: <strong style={{ fontWeight: 'bold', color: appointment.status ? 'green' : 'red'  }}>{appointment.status ? 'Serviced' : 'Pending'}</strong>
          </p>
          <hr />
        </div>
      ))}
    </div>
    
  </div>
)}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default UserProfile;
