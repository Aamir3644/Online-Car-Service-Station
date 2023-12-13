import React, { useState, useEffect } from 'react';
import Logo from './images/Logo2.png';
import { Link, useHistory } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
  const [isNavActive, setNavActive] = useState(false);
  const [isScrolled, setIsScrolled] = useState(false);

  const history = useHistory();

  const toggleNav = () => {
    setNavActive(!isNavActive);
  };

  const GoToServices = () => {
    history.push("/Services");
  };

  const GoToHome = () => {
    history.push("/");
  };

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 0) {
        setIsScrolled(true);
      } else {
        setIsScrolled(false);
      }
    };

    window.addEventListener('scroll', handleScroll);

    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  return (
    <nav className={`navbar navbar-expand-lg navbar-dark ${isScrolled ? 'fixed-top' : ''}`}>
      <div className="container-fluid">
        <a onClick={GoToHome} className="navbar-brand">
          <img src={Logo} alt="Logo" className="navbar-logo" width="140" height="auto" align="left" />
        </a>
        <button
          className={`navbar-toggler ${isNavActive ? 'active' : ''}`}
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded={isNavActive ? 'true' : 'false'}
          aria-label="Toggle navigation"
          onClick={toggleNav}
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className={`collapse navbar-collapse ${isNavActive ? 'show' : ''}`} id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item"><a onClick={GoToHome} className="nav-link">Home</a></li>
            <li className="nav-item"><a onClick={GoToServices} className="nav-link">Services</a></li>
            {/* <li className="nav-item"><a className="nav-link">Contact Us</a></li> */}
            <li className="nav-item"><a href="/Login" className="nav-link">Log In</a></li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
