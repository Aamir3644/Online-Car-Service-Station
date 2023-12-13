import { useState , useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { Link, useHistory  } from 'react-router-dom';
import { toast } from 'react-toastify';
import { login } from './features/authSlice';
import { loginUser as loginUserApi } from './services/user';
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
    if (email.length === '' || password.length === '') {
      toast.error('Please enter both email and password');
      return;
    }

    try {
      // call login API
      const response = await loginUserApi(email, password);

      if (response.status === 200) {
        const { token, user } = response.data; // Destructure token and user from the response

        // Store token and user data in sessionStorage or localStorage
        sessionStorage.setItem('token', token);
        sessionStorage.setItem('userId', user.userId);
        sessionStorage.setItem('fname', user.fname);
        sessionStorage.setItem('lname', user.lname);
        sessionStorage.setItem('role', user.role);
        sessionStorage.setItem('email', user.email);

        // update global store's authSlice with status = true
        dispatch(login());

        toast.success(`Welcome ${user.fname} to Garage Masters`);

        if (user.role === 'ROLE_ADMIN') {
          // Assuming outlet information is present in the user object
          sessionStorage.setItem('outletId', user.outlet ? user.outlet.outletId : null);
          history.push('/Dashboard');
        } else {
          history.push('/Services');
        }
      } else {
        toast.error('Invalid user name or password');
      }
    } catch (error) {
      console.error('Error during login:', error.response.data);
      toast.error('An error occurred during login');
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