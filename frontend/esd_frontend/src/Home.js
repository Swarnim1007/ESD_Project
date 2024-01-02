import { useState, useEffect } from 'react'

import loginService from './services/login'

import Notification from './components/Notification'
import LoginForm from './components/LoginForm'
import NavBar from './components/NavBar'
import RoomExchangeForm from './components/RoomExchangeForm'

const Home = () => {
    // user state will store the logged in user object, if no login has been done yet then it will be null
    const [user, setUser] = useState(null)
    

    // Will store the bills of the logged in user
    //const [ bills, setBills ] = useState([])

    // These states are used to control the notifications that show up at the top of the screen for events like 
    // login, signup, watchlist creation, etc.
    const [notification, setNotification] = useState(null)
    const [notificationType, setNotificationType] = useState(null)

    // Create a notification at the top of the screen with given message for 10 seconds 
    // Notifications are of two types, "error" and "success"
    // The appearance of these two notifications can be adjusted via the index.css file
    const notificationHandler = (message, type) => {
        setNotification(message)
        setNotificationType(type)

        setTimeout(() => {
            setNotificationType(null)
            setNotification(null)
        }, 3000)
    }

    // Function that handles login of users
    const handleLogin = async (credentials) => {
        try {
            const userObject = await loginService.login(credentials)
            console.log("user object", userObject);
            if(userObject == '0') throw new Error();

            setUser(userObject)
            setNotificationType("AvilableRequest")
            window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
            // console.log("The User Id is ",window.localStorage.getItem('loggedInUser'))

            notificationHandler(`Logged in successfully as ${userObject.firstName}`, 'success')

        }
        catch (exception) {
            notificationHandler(`Log in failed, check username and password entered`, 'error')
        }
    };
    const handleExchangeRequest = async (details) => {

        

        try {
            notificationHandler(`Submitted successfully `, 'success')

        }
        catch (exception) {
            notificationHandler(`Submission Unsuccessful`, 'error')
        }
    };



    // Effect Hook that parses the local storage for 'loggedInUser' and sets the "user" state if a valid match is found
    // This enables user to login automatically without having to type in the credentials. Caching the login if you will.
    useEffect(() => {
        const loggedInUser = window.localStorage.getItem('loggedInUser')
        if (loggedInUser)
            setUser(JSON.parse(loggedInUser))

        
    }, [])

    return (
        <div>
            <home>
                {/* Header of the page */}
                <div className='text-center page-header p-2 regular-text-shadow regular-shadow'>
                    <div className='display-4 font-weight-bold'>
                        Room Exchange
                    </div>
                </div>

                {/* Notification component that will render only when the notification state is not null */}



                {
                    /* Show Login form when no login has happened */
                    user === null &&
                    <LoginForm startLogin={handleLogin} />
                }


                {
                    /* Show NavBar when login has happened */
                    user !== null && (
                        <div>
                            <NavBar user={user} setUser={setUser} />
                            <RoomExchangeForm startSubmit={handleExchangeRequest} />
                        </div>
                    )
                    // <NavBar user={user} setUser={setUser}/>
                }
                <Notification notification={notification} type={notificationType} />

                {
                    /* Show Bills of the User when login has happened */
                    // user !== null &&
                    // <Bills
                    //   bills={bills}
                    //   payBill={payBill}
                    // />
                }
            </home>

        </div>
    );
};

export default Home;
