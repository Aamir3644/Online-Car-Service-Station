import React from 'react';
import { Table } from 'react-bootstrap';

const PaymentsSection = () => {
  const payments = [
    { id: 1, date: '2023-09-01', amount: 50 },
    { id: 2, date: '2023-09-10', amount: 75 },
    // ... More payments
  ];

  return (
    <div>
      <h2>Payments</h2>
      <Table striped bordered responsive>
        <thead>
          <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Amount</th>
          </tr>
        </thead>
        <tbody>
          {payments.map(payment => (
            <tr key={payment.id}>
              <td>{payment.id}</td>
              <td>{payment.date}</td>
              <td>${payment.amount}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default PaymentsSection;
