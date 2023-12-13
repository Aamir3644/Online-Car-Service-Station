import React, { useState } from 'react';
import { Button, Form, Container, Row, Col, Image } from 'react-bootstrap';
import cc from './images/cc.jpg';
import paypal from './images/paypal.png';
import gpay from './images/gpay2.png';
import Navbar2 from './Navbar2';
import Footer from './Footer';
import { toast } from 'react-toastify'
import {useHistory} from 'react-router-dom';
import {saveAppointment,deleteFromCartForUser} from './services/user';

const Payments = (props) => {
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedPaymentMethod, setSelectedPaymentMethod] = useState(null);
  const totalAmount = 100;
  const { car, model, outlet } = props.location.state;
  const userId = sessionStorage.getItem('userId');

  const history = useHistory();

  const paymentMethods = [
    { name: 'Credit Card', image: cc },
    { name: 'PayPal', image: paypal },
    { name: 'Google Pay', image: gpay },
    // ... More payment methods
  ];


  const today = new Date();
  const currentHour = today.getHours();

  const validateDate = (date) => {
    const selected = new Date(date);
    return selected >= today;
  };

  const validateTime = (time) => {
    const selectedHour = parseInt(time.split(':')[0]);
    return selectedHour >= 9 && selectedHour <= 22 && (selectedHour > currentHour || (today.getDate() !== selectedDate.getDate()));
  };

  const handleDateChange = (date) => {
    if (validateDate(date)) {
      setSelectedDate(date);
    } else {
      toast.error('Please select a valid date.');
    }
  };

  const handleTimeChange = (time) => {
    if (validateTime(time)) {
      setSelectedTime(time);
    } else {
      toast.error('Please select a valid time between 9 AM and 10 PM.');
    }
  };

  const confirmPayment = async () => {
    console.log(selectedDate);
    console.log(selectedTime);
    console.log(selectedPaymentMethod);

      const response = await saveAppointment(
        selectedDate, selectedTime, false , userId , outlet, car, model
      );

      const response1 = await deleteFromCartForUser(userId);
    
      console.log(response);
      if (response != null) {
        toast.success(`Payment Confirmed and Appointment Booked !!`);
        history.push('/');
      } else {
        toast.error('Error while booking appointment...');
      }
    
};

  return (
    <>
    <Navbar2/>
    <Container className="mt-4">
        <br/>
      <h2>Select Appointment Date and Time</h2>
      <Form>
        <Row>
          <Col>
            <Form.Group>
              <Form.Label>Date</Form.Label>
              <Form.Control type="date" value={selectedDate} onChange={e => handleDateChange(e.target.value)} />
            </Form.Group>
          </Col>
          <Col>
            <Form.Group>
              <Form.Label>Time</Form.Label>
              <Form.Control
                type="time"
                value={selectedTime}
                onChange={e => handleTimeChange(e.target.value)}
              />
            </Form.Group>
          </Col>
        </Row>
      </Form>
        <br/>
      <h2>Select Payment Method</h2>
      <Row>
        {paymentMethods.map(method => (
          <Col key={method.name} md={4} className="mb-3">
            <div className={`payment-method card ${selectedPaymentMethod === method ? 'selected' : ''}`} onClick={() => setSelectedPaymentMethod(method)}>
              <Image src={method.image} alt={method.name} className="card-img-top" style={{ height: '190px' }}/>
              <div className="card-body">
                <h5 className="card-title">{method.name}</h5>
              </div>
            </div>
          </Col>
        ))}
      </Row>
            <br/>
      <h2>Checkout Details</h2>
      <div className="checkout-summary">
        <p>Appointment Date: {selectedDate}</p>
        <p>Appointment Time: {selectedTime}</p>
        <p>Selected Payment Method: {selectedPaymentMethod ? selectedPaymentMethod.name : ''}</p>
        <p>Total Amount: {totalAmount}</p>

        <Button variant="primary" onClick={confirmPayment}>Confirm Payment</Button>
      </div>
    </Container>
    <br/>
    <br/>
    <Footer/>
    </>
  );
};

export default Payments;
