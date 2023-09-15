import { useState , useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { Link, useHistory  } from 'react-router-dom';
import { toast } from 'react-toastify'
import { login } from './features/authSlice'
import { loginUser as loginUserApi } from './services/user'
export default function SignIn()
{ 

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [user, setUser] = useState(''); // State to store user data

  // get the history object
  const history = useHistory()

  // get dispatcher object
  const dispatch = useDispatch()

  const loginUser = async () => {
    if (email.length == '') {
      toast.error('Please enter email')
    } else if (password.length == '') {
      toast.error('Please enter password')
    } else {
      // call register api
      const response = await loginUserApi(email, password)
      console.log(response);
      // parse the response
      if (response['status'] == 200) {
        // parse the response's data and extract the token
        // Login successful
        const userData = response.data; // Assuming the API response contains user data
        console.log(userData)
        setUser(userData); // Store user data in state
        console.log("cute",user.fname)
        // store the token for making other apis
        // sessionStorage['token'] = true
        sessionStorage['userId'] = userData.userId
        sessionStorage['fname'] = userData.fname
        sessionStorage['lname'] = userData.lname
        sessionStorage['role'] = userData.role

        // update global store's authSlice with status = true
        dispatch(login())

        toast.success(`Welcome ${userData .fname} to Garage Masters`)

        // go back to login
        //Later I have to add the logic of knowing its a Admin or Customer and Route according to it
        //
        history.push('/Services')
      } else {
        toast.error('Invalid user name or password')
      }
    }
  }

    return((
        <div className="container-fluid" >
            <br/><br/><br/><br/>
          <h1 style={{ textAlign: 'center', margin: 10 }}>Login</h1>
    
          <div className='row'>
            <div className='col'></div>
            <div className='col'>
              <div className='form'>
                <div className='mb-3'>
                  <label htmlFor=''>Email</label>
                  <input
                    type='text'
                    className='form-control'
                    onChange={(e) => {
                      setEmail(e.target.value)
                    }}
                  />
                </div>
                <div className='mb-3'>
                  <label htmlFor=''>Password</label>
                  <input
                    type='password'
                    className='form-control'
                    onChange={(e) => {
                      setPassword(e.target.value)
                    }}
                  />
                </div>
                <div className='mb-3'>
                  <div className='mb-3'>
                    Don't have an account? <Link to='/SignUp'>Register here</Link>
                  </div>
                  <button onClick={loginUser} className='btn btn-success'>
                    Login
                  </button>
                </div>
              </div>
            </div>
            <div className='col'></div>
          </div>
        </div>
      )
    );

}