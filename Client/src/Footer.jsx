import React from 'react';
import './Footer.css';

function Footer()
{
  return (
    <div className="footerTest" style={{margin:0}}>
      <div id="motto">
        "Driving Excellence, Servicing Satisfaction"
      </div>

      <div id="legal">
          <br/>
      <p>&copy; {new Date().getFullYear()} Garage Masters. All rights reserved.</p>
        <p>Phone: 02382-856945 | Email: info@garagemasters.com</p>
        <p>Address: Infront of Sunbeam Infotech, Hinjewadi Road, Pune, Maharashtra</p>
      </div>
    </div>
  );
};

export default Footer;
