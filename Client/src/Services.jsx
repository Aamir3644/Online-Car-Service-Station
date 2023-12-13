import React from 'react';
import { useState,useEffect } from 'react'
import './Services.css';
import Footer from './Footer';
import Navbar from './Navbar';
import Navbar2 from './Navbar2';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';
import {RxCrossCircled} from 'react-icons/rx';
import {FaCartPlus} from 'react-icons/fa';
import { login } from './features/authSlice';
import { useDispatch, useSelector } from 'react-redux';
import { toast } from 'react-toastify'
import { getManufac, getModelById, getOutlets, getServices, addToCart, RemoveFromCart, getCartById } from './services/user'


export default function ServicesPage() {
  
  const [selectedCar, setSelectedCar] = useState('');
  const [selectedModel, setSelectedModel] = useState('');

  
  // use selector accepts a function which passes the store global state
  const loginStatus = useSelector((state) => state.auth.status)
  console.log(loginStatus);
    
  const [outlets, setOutlets] = useState([]);
  const [selectedOutlet, setSelectedOutlet] = useState('');
  
  const [cartItems, setCartItems] = useState([]);
  
  const [cars,setCars] = useState([]);
  const [carModels,setCarModels] = useState([]);
  
  useEffect(() => {   
    const fetchData = async () => {
      try {
        
        const response = await getManufac();
        const response2 = await getOutlets();
        const response3 = await getServices();
        
        console.log("data", response.data);
        console.log("data", response2.data);
        console.log("data of services : ", response3.data);
        
        setCars(response.data);
        debugger;
        setOutlets(response2.data);
        setServices(response3.data);

        if(loginStatus == true)
        {
          var userId = sessionStorage.getItem('userId');
          const response4 = await getCartById(userId);
          console.log("data of services in cart : ", response4.data);
          setCartItems(response4.data);
        }
        
      } catch (error) {
        console.error(error); 
      }
    };
    
    fetchData();
  }, [])


  useEffect(() => {
    const fetchCarModels = async () => {
      try {
        console.log("inside fetchCarModels");
        if (selectedCar) {
          const response = await getModelById(selectedCar)
          console.log("response -", response);
          console.log("data -", response.data);
          setCarModels(response.data);
        }
      } catch (error) {
        console.error(error); 
      }
    };
    
    fetchCarModels();
  }, [selectedCar]); // Fetch when selectedCar changes
  

  const [services,setServices] = useState([]);

  const history = useHistory();

  const handleOutletChange = (args) => {
    setSelectedOutlet(args.target.value);
    console.log("selected outlet info - ", args.target.value)
    // sessionStorage['outlet'] = args.target.value;
  };

  const handleCarChange = (args) => {
    setSelectedCar(args.target.value);
    setSelectedModel('');
    console.log("selected manufacturer info - ", args.target.value)
    // sessionStorage['car'] = args.target.value;
  };

  const handleModelChange = (args) => {
    setSelectedModel(args.target.value);
    console.log("selected model info - ", args.target.value)
    // sessionStorage['model'] = args.target.value;
  };


  const AddToCart = async (service) => {
        
    if(loginStatus != true)
    {
      toast.warning('To add items to your cart, Please Log in or Create an account.')
      history.push("/Login");
      return;
    }

    //getting userId of user from session storage and using it to add data to cart table
    var userId = sessionStorage.getItem('userId');
    
    console.log("user Id of User - ",userId);
    console.log("service Id of Service - ",service.serviceId);

    const response = await addToCart(service.serviceId,userId);
    console.log(response.data);

    if (!cartItems.find(item => item.id === service.serviceId)) {
      setCartItems([...cartItems, service]);
    }
  };

  const removeCartItem = async (itemId) => {
    var userId = sessionStorage.getItem('userId');
    const response = await RemoveFromCart(itemId,userId);
    console.log(response.data);
    const updatedCartItems = cartItems.filter((item) => item.serviceId !== itemId);
    setCartItems(updatedCartItems);
  };

  const totalPrice = cartItems.reduce((acc, item) => acc + item.price, 0);


  const GoToPayments = () =>{

    if (!selectedCar || !selectedModel || !selectedOutlet) {
      toast.error('Please select a car manufacturer, model, and outlet before proceeding.');
      return;
    }
    
    history.push("/Payments", {
      car: selectedCar,
      model: selectedModel,
      outlet: selectedOutlet,
    });
  }

  return (
    <>
      {!loginStatus && <Navbar/>}
      {loginStatus &&<Navbar2/>}
      <div style={{ minHeight: '65vh' }}>
        <div className="container mt-5 ">
          <div className="row">
            <div className="col-md-8">
              <div className="card p-4 shadow">
                <h1 className="mb-4">Choose a Car and Model</h1>
                <div style={{ display: 'flex', gap: '20px' }}>
                <div style={{ flex: 1 }}>
                <div className="form-group">
                  <label htmlFor="selectCar">Select a Car:</label>
                  <select
                    id="selectCar"
                    className="form-control"
                    value={selectedCar}
                    onChange={handleCarChange}
                  >
                    <option value="">Select Car</option>
                    {cars.map((car) => (
                      <option key={car.manufacturerId} value={car.manufacturerId}>
                        {car.manufacturerName}
                      </option>
                    ))}
                  </select>
                  {}
                </div>
                <div className="form-group mt-4">
                  <label htmlFor="selectModel">Select a Model:</label>
                  <select
                    id="selectModel"
                    className="form-control"
                    value={selectedModel}
                    onChange={handleModelChange}
                    disabled={!selectedCar}
                  >
                    <option value="">Select Model</option>
                    {selectedCar &&
                      carModels.map((model, index) => (     
                        <option key={index} value={model.modelId}>
                          {model.modelName}
                          {console.log("model object -",model.modelId)}
                        </option>
                      ))}
                  </select>
                </div>
                <br/>
                
                <div style={{ flex: 1 }}>
                  <div className="form-group">
                    <label htmlFor="selectOutlet">Select an Outlet:</label>
                    <select
                      id="selectOutlet"
                      className="form-control"
                      value={selectedOutlet}
                      onChange={handleOutletChange}
                    >
                      <option value="">Select Outlet</option>
                      {outlets.map((outlet,index) => (
                        <option key={index} value={outlet.outletId}>
                          {outlet.name} - {outlet.address}
                        </option>
                      ))}
                    </select>
                  </div>
                </div>
                </div>
                </div>

                {/*selectedCar && selectedModel &&*/ 
                (
                  <div>
                    <br/>
                    <h2>Services:</h2>
                    {services.map((service) => (
                      <div
                        key={service.serviceId}
                        className="card p-4 mt-3 shadow"
                      >
                        <h3>{service.name}</h3>
                        <p>Description: {service.description}</p>
                        <p>Duration: {service.duration}</p>
                        <p>Price: Rs.{service.price}</p>
                        {cartItems.find(item => item.serviceId === service.serviceId) ? (
                          <button className="btn btn-success" disabled style={{width:'150px'}}>
                            Added to Cart
                          </button>
                          
                        ) : (
                          <button
                            className="btn btn-primary"
                            onClick={() => AddToCart(service)}
                            style={{width:'150px'}}
                          >
                            Add to Cart
                          </button>
                          // <FaCartPlus onClick={() => AddToCart(service)} size="30px"/>
                          
                        )}
                      </div>
                    ))}
                  </div>
                )}
              </div>
            </div>

            <div className="col-md-4">
              {cartItems.length > 0 && (
                <div className="card p-4 shadow">
                  <h3>Shopping Cart</h3>
                  <table className="table table-bordered">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th colSpan="2">Price</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      {cartItems.map((item) => (
                        <tr key={item.serviceId}>
                          <td >{item.name}</td>
                          <td>Rs.{item.price}</td>
                          <td align="right">
                            {/* <button className="btn btn-danger" onClick={() => removeCartItem(item.id)}>
                              Remove</button> */}
                            <RxCrossCircled className="text-danger" size="18px" onClick={() => removeCartItem(item.serviceId)}/>
                          </td>
                        </tr>
                      ))}
                      <tr>
                        <td colSpan="2" className="text-right">
                          Total:
                        </td>
                        <td>Rs.{totalPrice}</td>
                      </tr>
                    </tbody>
                  </table>
                  <button onClick={GoToPayments} className="btn btn-primary btn-block mt-3">
                    Proceed to Checkout
                  </button>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}
