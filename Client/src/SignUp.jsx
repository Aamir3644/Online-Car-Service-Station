import "../node_modules/bootstrap/dist/css/bootstrap.css";
import { useState } from 'react'
import { Link , useHistory} from 'react-router-dom'
import { toast } from 'react-toastify'
import { registerUser as registerUserApi } from './services/user'

export default function SignUp()
{
  const [fname, setFirstName] = useState('')
  const [lname, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [role, setRole] = useState('Customer')
  const [outlet_id, setOutlet] = useState(null)

  // get the navigation object
  const history = useHistory()

  const registerUser = async () => {
    if (fname.length == '') {
      toast.error('Please enter first name')
    } else if (lname.length == '') {
      toast.error('Please enter last name')
    } else if (email.length == '') {
      toast.error('Please enter email')
    } else if (password.length == '') {
      toast.error('Please enter password')
    } else if (confirmPassword.length == '') {
      toast.error('Please confirm password')
    } else if (password !== confirmPassword) {
      toast.error('Password does not match')
    } else {
      // call register api
      setOutlet(1);
      console.log(outlet_id);
      const response = await registerUserApi(
        fname,
        lname,
        email,
        password,
        role,
        outlet_id 
      )
        console.log(response);
      // parse the response
      if (/*response['status'] == 200*/ response != null) {
        toast.success('Successfully registered a new user')

        // go back to login
        history.push('/Login')
      } else {
        toast.error('Error while registering a new user, please try again')
      }
    }
  }

    return(<>
        <div>
            <br/>
      <h1 style={{ textAlign: 'center', margin: 10 }}>Register User</h1>

      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <div className='form'>
            <div className='mb-3'>
              <label htmlFor=''>First Name</label>
              <input
                type='text'
                className='form-control'
                onChange={(e) => {
                  setFirstName(e.target.value)
                }}
              />
            </div>

            <div className='mb-3'>
              <label htmlFor=''>Last Name</label>
              <input
                type='text'
                className='form-control'
                onChange={(e) => {
                  setLastName(e.target.value)
                }}
              />
            </div>

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
              <label htmlFor=''>Confirm Password</label>
              <input
                type='password'
                className='form-control'
                onChange={(e) => {
                  setConfirmPassword(e.target.value)
                }}
              />
            </div>

            <div className='mb-3'>
              <div className='mb-3'>
                Already got an account? <Link to='/Login'>Login here</Link>
              </div>
              <button onClick={registerUser} className='btn btn-success'>
                Register
              </button>
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
    </>)
}