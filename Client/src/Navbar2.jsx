import React, { useState, useEffect } from 'react';
import Logo from './images/Logo2.png';
import { useDispatch } from 'react-redux';
import { Link, useHistory } from 'react-router-dom';
import { logout } from './features/authSlice';
import './Navbar.css';

function Navbar() {
  const history = useHistory();
  const dispatch = useDispatch();

  // logout the user
  const logoutUser = () => {
    // clear the session storage changes
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('fname');
    sessionStorage.removeItem('lname');
    sessionStorage.removeItem('role');

    // hide the navigation bar
    dispatch(logout());

    // redirect to the login page
    history.push('/');
  }

  const [isNavActive, setNavActive] = useState(false);
  const [isScrolled, setIsScrolled] = useState(false);

  const toggleNav = () => {
    setNavActive(!isNavActive);
  };

  const GoToServices = () => {
    history.push("/Services");
  }

  const GoToHome = () => {
    history.push("/");
  }

  const GoToProfile = () => {
    history.push("/Profile");
  }

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
            <li className="nav-item"><a onClick={GoToProfile} className="nav-link">Account</a></li>
            <li className="nav-item"><a onClick={logoutUser} className="nav-link">Log Out</a></li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
