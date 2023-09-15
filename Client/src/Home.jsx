import React from 'react';
import oilChangeImage from './images/Oil Change.jpg';
import EngineTuningImg from './images/Engine Tune Up.jpg';
import AC from './images/AC Service.jpg'
import howItWorks from './images/hiw2.png';
import Navbar from './Navbar';
import Footer from './Footer';
import Corousel from './corousel';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';
import { useSelector } from 'react-redux';
import Navbar2 from './Navbar2';

function Home()
{
  const history = useHistory();

  const loginStatus = useSelector((state) => state.auth.status)
  console.log(loginStatus);

  const GoToServices = () =>{
    history.push("/Services");
  }

  return (
    
    <div >
      {!loginStatus && <Navbar/>}
      {loginStatus &&<Navbar2/>}
      
          <section className="hero-section  text-center py-5">
          {/* <h1>Welcome to Garage Masters</h1> */}
          <h3 className="mb-4">Get the best car maintenance and repair services.</h3>
          <h4 className="mb-4">Don't wait in a queue. Take your service appointment online!</h4>
          </section>
        
  <section className="services-section py-5">
  <div className="container">
    <h2 className="text-center mb-4">Our Services</h2>
    <div className="row">
      <div className="col-lg-4 mb-4">
        <div className="card service-card text-center">
          <img src={oilChangeImage} className="card-img-top" alt="Oil Change" />
          <div className="card-body" onClick={GoToServices}>
            <h3 className="card-title">Oil Change</h3>
            <p className="card-text">Keep your engine running smoothly with our oil change services.</p>
          </div>
        </div>
      </div>

      {/* <div className="col-lg-4 mb-4">
        <div className="card service-card text-center">
          <img src={BrakeRepairImg} className="card-img-top" alt="Brake Repair" />
          <div className="card-body" onClick={GoToServices}>
            <h3 className="card-title">Brake Repair</h3>
            <p className="card-text">Ensure your safety with our professional brake repair services.</p>
          </div>
        </div>
      </div> */}

      <div className="col-lg-4 mb-4" >
        <div className="card service-card text-center" >
          <img src={AC} className="card-img-top" alt="ACVent Refresh" style={{ height: '278px' }} />
          <div className="card-body" onClick={GoToServices}>
            <h3 className="card-title">AC Vent Refresh</h3>
            <p className="card-text">Reviving your cabin air quality with AC vent cleanings,  promoting a fresher driving experience.</p>
          </div>
        </div>
      </div>

      <div className="col-lg-4 mb-4">
        <div className="card service-card text-center">
          <img src={EngineTuningImg} className="card-img-top" alt="Engine Tune-up" />
          <div className="card-body" onClick={GoToServices}>
            <h3 className="card-title">Engine Tune-up</h3>
            <p className="card-text">Improve the performance and efficiency of your vehicle with our engine tune-up services.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

     
      <section>
        <div className="container text-center">
          <h2 className="mb-4">How GarageMasters Works?</h2>
          <img src={howItWorks} className="img-fluid" alt="How It Works" />
        </div>
      </section>

      <section className="testimonials-section  py-5">
        <div className="container">
          <h2 className="text-center mb-4">Customer Reviews</h2>
          <div className="row">
            <div className="col-lg-4">
              <div className="testimonial-card text-center p-4 mb-4">
                <p className="testimonial-text">"Garage Masters provides excellent service. My car is always in good hands with their knowledgeable technicians."</p>
                <p className="testimonial-author">- Aamir Khan</p>
              </div>
            </div>
            <div className="col-lg-4">
              <div className="testimonial-card text-center p-4 mb-4">
                <p className="testimonial-text">"I highly recommend Garage Masters for their professionalism and quality work. They always go above and beyond."</p>
                <p className="testimonial-author">- Shahrukh Khan</p>
              </div>
            </div>
            <div className="col-lg-4">
              <div className="testimonial-card text-center p-4 mb-4">
                <p className="testimonial-text">"Garage Masters provides best service. They are the best in this industry !!"</p>
                <p className="testimonial-author">- Salman Khan</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <div className="container">
      <h2>Original Spare Parts</h2>
      <h5>Extended Warranty with GarageMasters</h5>
      </div>
      <br/>
      <Corousel />
      <br/><br/><br/>
      
      <Footer />
    </div>
  );
};

export default Home;
