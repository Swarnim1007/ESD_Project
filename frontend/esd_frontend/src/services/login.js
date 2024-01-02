import axios from 'axios'

// The API endpoint where login data is sent to
const loginBaseUrl = `/api/v1/login`
const id = 0;
const login = async (credentials) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  try{
    console.log("Cred ",credentials)
    const response = await axios.post(loginBaseUrl, credentials)
    console.log("Login Response ",response.data)
    return response.data;
  }
  catch(error){
    console.log(error)
  }
  

  
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  
  return id;
}

// Export the method as an object so that it can be accessible outside this file as a service
const exportObject = { login }
export default exportObject