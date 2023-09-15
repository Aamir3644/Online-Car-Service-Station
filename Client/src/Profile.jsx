import React, { useState } from 'react';
import { Container, Row, Col, Nav, Tab, TabContent } from 'react-bootstrap';
import AppointmentsSection from './AppointmentsSection';
//import ReviewsSection from './ReviewsSection';
import ProfileSection from './ProfileSection';
import PaymentsSection from './PaymentsSection';

const Dashboard = () => {
  const [activeTab, setActiveTab] = useState('appointments');

  const handleTabSelect = (tabKey) => {
    console.log('Tab selected:', tabKey);
    setActiveTab(tabKey);
  };

  console.log('Dashboard rendered with active tab:', activeTab);

  return (
    <Container fluid>
      <Row>
        <Col sm={2} className="bg-dark text-light py-3 vh-100">
          <Nav className="flex-column">
            <Nav.Item>
              <Nav.Link
                eventKey="appointments"
                className={activeTab === 'appointments' ? 'active' : ''}
                onClick={() => handleTabSelect('appointments')}
              >
                Appointments
              </Nav.Link>
            </Nav.Item>
            
            <Nav.Item>
              <Nav.Link
                eventKey="profile"
                className={activeTab === 'profile' ? 'active' : ''}
                onClick={() => handleTabSelect('profile')}
              >
                Profile
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link
                eventKey="payments"
                className={activeTab === 'payments' ? 'active' : ''}
                onClick={() => handleTabSelect('payments')}
              >
                Payments
              </Nav.Link>
            </Nav.Item>
          </Nav>
        </Col>
        <Col sm={10} className="p-3">
          <TabContent>
            <Tab.Pane eventKey="appointments">
              <AppointmentsSection />
            </Tab.Pane>
            <Tab.Pane eventKey="profile">
              <ProfileSection />
            </Tab.Pane>
            <Tab.Pane eventKey="payments">
              <PaymentsSection />
            </Tab.Pane>
          </TabContent>
        </Col>
      </Row>
    </Container>
  );
};

export default Dashboard;
