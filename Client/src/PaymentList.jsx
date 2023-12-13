import React, { useState, useEffect } from 'react';
import { getPaymentsByOutletId } from './services/user';

const PaymentsPage = () => {
  const [payments, setPayments] = useState([]);

  const outletId = sessionStorage.getItem('outletId');

  useEffect(() => {
    const fetchPayments = async () => {
      try {
        const response = await getPaymentsByOutletId(outletId);
        console.log("Payments details:", response.data);
        setPayments(response.data);
      } catch (error) {
        console.error("Error fetching payments:", error);
      }
    };

    fetchPayments();
  }, [outletId]);

  return (
    <div className="container mt-5">
      <h1 className="mb-4">Payments</h1>
      <table className="table">
        <thead>
          <tr>
            <th className="col-md-4">Payment Date</th>
            <th className="col-md-1"></th> {/* Empty column for spacing */}
            <th className="col-md-4">Time</th>
            <th className="col-md-3">Amount</th>
          </tr>
        </thead>
        <tbody>
          {payments.map((payment) => (
            <tr key={payment.paymentId}>
              <td className="col-md-4">
                {new Date(payment.paymentDate).toLocaleDateString()} {/* Format the date */}
              </td>
              <td className="col-md-1"></td> {/* Empty column for spacing */}
              <td className="col-md-4">{payment.appointment.appointmentTime}</td>
              <td className="col-md-3">${payment.total}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PaymentsPage;
