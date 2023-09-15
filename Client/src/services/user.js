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

export async function loginUser(email, password) {
  const url = createUrl('/users/Login')
  console.log(url);
  const body = {email,password,}

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body)
    log("response", response)
    log("data", response.data)
    return response
  } catch (ex) {
    log(ex)
    return null
  }
}

export async function getManufac() {
  const url = createUrl('/manufacturer')
  console.log(url);

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url);
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
  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url);
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

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url);
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

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url);
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

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.post(url, body)
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

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.delete(url, { data: requestData });
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

  // wait till axios is making the api call and getting response from server
  try {
    const response = await axios.get(url);
    console.log("response", response);
    console.log("data", response.data);
    return response;
  } catch (ex) {
    log(ex)
    return null
  }
  
}




