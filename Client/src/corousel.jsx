import React from 'react';
import { Carousel } from 'react-bootstrap';
import '../node_modules/bootstrap/dist/css/bootstrap.css';
import bosch from './images/BOSCH.png';
import textar from './images/TEXTAR.png';
import sachs from './images/SACHS.png';
import ntn from './images/NTN.png';
import valeo from './images/VALEO.jpg';

export default function CompanyLogosCarousel() {
  // Array of company logos
  const companyLogos = [bosch, textar, sachs, ntn, valeo];

  return (
    <div className="container">
      <div className="carousel-container">
        <Carousel interval={3000} pauseOnHover={true}>
          {companyLogos.map((logo, index) => (
            <Carousel.Item key={index}>
              <div className="d-flex justify-content-center align-items-center">
                <img
                  src={logo}
                  alt={`Company Logo ${index + 1}`}
                  width={200} // Set the desired width
                  height="auto" // Maintain aspect ratio
                />
              </div>
            </Carousel.Item>
          ))}
        </Carousel>
      </div>
    </div>
  );
}
