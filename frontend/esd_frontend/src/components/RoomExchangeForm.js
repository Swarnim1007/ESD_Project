// RoomExchangeForm.js

import React, { useEffect, useState } from 'react';
import './RoomExchangeForm.css';
import Notification from './Notification';
import axios from 'axios';


const loginBaseUrl = `/api/swapApplication/exchange-request`;

const RoomExchangeForm = ({ startSubmit }) => {
    // State to manage form fields

    const [preferredRoomNo, setPreferredRoom] = useState('');
    const [message, setReason] = useState('');
    const [notificationIndex, setNotificationIndex] = useState(0);
    const [requests, setRequests] = useState(
        []
    );





    useEffect(() => {
        const handleGetList = async () => {
            try {


                const studentID = window.localStorage.getItem('loggedInUser')
                console.log("To handlelist ", studentID)
                const response = await axios.get(`api/swapApplication/getNotification/${studentID}`, {
                    headers: {
                        "access-control-allow-origin": "*",
                    }
                });
                
                // //console.log("Alumni Data: ","response: ", response.data.length);
                // for (let i = 0; i < response.data.length; i++) {
                //     // console.log("Inside Loop ",response.data[i]);
                //     arr.push(response.data[i]);
                // }

                // const data = response.data[0];

                console.log("Reciving Data ", response.data)
                setRequests(response.data)
            } catch (error) {
                console.error('Failed to fetch data:', error);
            }
        };

        handleGetList();
    }, []); // Make sure to include the dependency array

    // ...

    // In your handleExchangeRequest function
    const handleAccept = async (e) => {
        e.preventDefault();

        const swapId = notificationIndex;
        const accept = "YES"
        const details = {
            swapId,
            accept
        };

        try {

            const response = await axios.post(`/api/swapApplication/exchange-response`, details);
            console.log(response);
            const studentID = window.localStorage.getItem('loggedInUser')
            const updatedList = await axios.get(`api/swapApplication/getNotification/${studentID}`, {
                headers: {
                    "access-control-allow-origin": "*",
                }
            });

            setRequests(updatedList.data);

        } catch (error) {
            console.error('Registration Failed:', error);
        }
    }

    const handleReject = async (e) => {
        e.preventDefault();

        const swapId = notificationIndex;
        const accept = "NO"
        const details = {
            swapId,
            accept
        };

        try {

            const response = await axios.post(`/api/swapApplication/exchange-response`, details);
            console.log(response);

            const studentID = window.localStorage.getItem('loggedInUser')
            const updatedList = await axios.get(`api/swapApplication/getNotification/${studentID}`, {
                headers: {
                    "access-control-allow-origin": "*",
                }
            });

            setRequests(updatedList.data);

        } catch (error) {
            console.error('Registration Failed:', error);
        }
    }

    const handleExchangeRequest = async (e) => {
        e.preventDefault();
        console.log("")
        const studentId = localStorage.getItem('loggedInUser');
        console.log(studentId);

        const details = {
            studentId,
            preferredRoomNo,
            message
        };

        try {
            console.log("Student Details", details);
            const response1 = await axios.post(loginBaseUrl, details);
            console.log(response1);

            // After making the request, you might want to update the list again.
            // Depending on your use case, you might want to fetch the updated list or just add the new request to the existing list.
            const studentID = window.localStorage.getItem('loggedInUser')
            const updatedList = await axios.get(`api/swapApplication/getNotification/${studentID}`, {
                headers: {
                    "access-control-allow-origin": "*",
                }
            });

            setRequests(updatedList.data);

            // Redirect or perform actions upon successful login
        } catch (error) {
            console.error('Registration Failed:', error);
        }

        startSubmit(details);

        setPreferredRoom('');
        setReason('');
    };





    return (

        <>
            <div class="row m-5">
                <div class="col-12 col-md-8">
                    <form onSubmit={handleExchangeRequest}>
                        {/* <label className="currentRoom">Current Room:
                            <input
                                type="text"
                                id="currentRoom"
                                value={currentRoom}
                                onChange={(e) => setCurrentRoom(e.target.value)}
                                required
                            />
                        </label> */}
                        <label className="preferredRoom">Preferred Room:
                            <input
                                type="text"
                                id="preferredRoom"
                                value={preferredRoomNo}
                                onChange={(e) => setPreferredRoom(e.target.value)}
                                required
                            />
                        </label>
                        <label className="reason">Reason for Exchange:
                            <textarea
                                id="reason"
                                value={message}
                                onChange={(e) => setReason(e.target.value)}
                                required
                            ></textarea>
                        </label>
                        <button type="submit">Submit Request</button>
                    </form>
                </div>
                
                <div class="col-6 col-md-4 mt-5">
                    <ul class="list-group" >
                        {requests.map((request, index) => (
                            <div key={index}>
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    Room No B{request.roomNo}
                                    <span class="badge  badge-pill">
                                        <form onSubmit={handleAccept} id='accept-form'>
                                            <input type="hidden" name="hiddenInput" value={index} />
                                            <button type="submit" class="btn btn-success" onClick={(e) => setNotificationIndex(request.swapId)}>Accept</button>
                                        </form>
                                    </span>
                                    <span class="badge  badge-pill">
                                        <form onSubmit={handleReject} id='reject-form'>
                                            <button type="submit" class="btn btn-danger" onClick={(e) => setNotificationIndex(request.swapId)}>Reject</button>
                                        </form>
                                    </span>
                                </li>
                            </div>
                        ))}
                    </ul>
                </div>
            </div>
            <div>
            </div>


        </>




    );
};

export default RoomExchangeForm;
