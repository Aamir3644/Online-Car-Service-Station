import axios from 'axios'
import { createUrl, log } from '../utils/utils'

export async function registerUser(fname,lname,email,password,role,outlet_id) {
  const url = createUrl('/users/SignUp')
  const body = {fname,lname,email,password,role,outlet_id}

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body)
    log(response.data)
    return response.data
  } catch (ex) {
    log(ex)
    return null
  }
}

export async function loginUser(email, passwd) {
  const url = createUrl('/users/Login')
  console.log(url);
  const body = {email,passwd}

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body)
    log("response", response)
    
    return response
  } catch (ex) {
    log(ex)
    return null
  }
}

export async function getManufac() {
  const url = createUrl('/manufacturer')
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };
  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function getModelById(selectedCar) {
  const url = createUrl(`/model/${selectedCar}`)
  console.log(url);
  
  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };
  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function getOutlets() {
  const url = createUrl('/outlet')
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function getServices() {
  const url = createUrl('/services')
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };
  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function addToCart(service_id, user_id) {
  const url = createUrl('/cart')
  console.log(url);
  console.log("in axios - sId -",service_id);
  console.log("in axios - uId -",user_id);
  const body = {
    "serviceId": service_id,
    "userId": user_id
  }

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };
  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body,config)
    log("response of AddToCart - ", response)
    log("data of AddToCart - ", response.data)
    return response
  } catch (ex) {
    log(ex)
    return null
  }
}

export async function RemoveFromCart(service_id, user_id) {
  const url = createUrl('/cart')
  console.log("in remove from cart - axios - sId -",service_id);
  console.log("in add to cart - axios - uId -",user_id);
  console.log("cart delete axios - ",url);
  
  const requestData = {
    serviceId: service_id,
    userId: user_id
  };

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.delete(url, { data: requestData },config);
    log("response", response)
    log("data", response.data)
    return response
  } catch (ex) {
    log(ex)
    return null
  }
}


export async function getCartById(userId) {
  const url = createUrl(`/cart/${userId}`)
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function getAppointmentById(userId) {
  const url = createUrl(`/appointment/${userId}`)
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  }; 

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function saveAppointment(appointmentDate, appointmentTime, status, userId, outletId, manufacturerId, modelId) {
  const url = createUrl('/appointment');
  const body = {
    appointmentDate,
    appointmentTime,
    status,
    user: {
      userId
    },
    outlet: {
      outletId
    },
    manufacturer: {
      manufacturerId
    },
    model: {
      modelId,
      manufacturer: {
        manufacturerId
      }
    }
  };

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  try {
    const response = await axios.post(url, body, config)
    log(response.data)
    return response.data
  } catch (ex) {
    log(ex)
    return null
  }
}

export async function deleteFromCartForUser(user_id) {
  const url = createUrl(`/cart/deleteItemsForUser/${user_id}`)

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.delete(url,config);
    log("response", response)
    log("data", response.data)
    return response
  } catch (ex) {
    log(ex)
    return null
  }
}


export async function getAppointmentByOutletId(outletId) {
  const url = createUrl(`/appointment/outlet/${outletId}`)
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}

export async function updateAppointmentStatus(appointmentId, newStatus) {
  const url = createUrl(`/appointment/update-status/${appointmentId}`);
  console.log("url", url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  try {
    const response = await axios.put(url, { status: newStatus },config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex);
    return null;
  }
}

export async function getPaymentsByOutletId(outletId) {
  const url = createUrl(`/payments/outlet/${outletId}`);
  console.log(url);

  const token = sessionStorage.getItem('token');

  // Configure headers with the token
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
    },
  };

  try {
    const response = await axios.get(url,config);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex);
    return null;
  }
}

