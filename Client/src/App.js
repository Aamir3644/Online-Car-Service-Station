import React from 'react';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import Home from './Home';
import Services from './Services';
import SignIn from './SignIn';
import SignUp from './SignUp';
import Payments from './Payments';
import Profile from './Profile';
import Dashboard from './Dashboard';
import PaymentList from './PaymentList';

// used to register react-toastify

import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

export default function App()
{

    return(
      <div>
      <Router>
        <Switch>
        <Route exact path="/" component={Home}></Route>
        <Route exact path="/Services" component={Services}></Route>
        <Route exact path="/Login" component={SignIn}></Route>
        <Route exact path="/SignUp" component={SignUp}></Route>
        <Route exact path="/Payments" component={Payments}></Route>
        <Route exact path="/Profile" component={Profile}></Route>
        <Route exact path="/Dashboard" component={Dashboard}></Route>
        <Route exact path="/PaymentList" component={PaymentList}></Route>
        </Switch>
      </Router>
      <ToastContainer />
      </div>
    );
}

