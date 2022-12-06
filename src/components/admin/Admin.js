import {Link, useNavigate} from 'react-router-dom';
import {useEffect, useState} from "react";
import table from "../../commons/tables/table";
function Admin()
{
    const navigate = useNavigate();
    const [persons, setPersons] = useState([]);
    const [devices, setDevices] = useState([]);
    const [pagePersons, setPagePersons]= useState(0);
    const [pageDevice, setPageDevice]= useState(0);
    function createUser(){}
    function deleteUser(){}
    function updateUser(){}
    function searchUser(){}
    function createDevice(){}
    function deleteDevice(){}
    function updateDevice(){}
    function searchDevice(){}
    function showError(message) {console.log(message); return(navigate("/error"));}
    function delog() { localStorage.clear(); return(navigate("/"));}
    const onBackPersons=()=>{setPagePersons(pagePersons -1 >-1 ? pagePersons-1:pagePersons)}
    const onNextPersons=()=>{setPagePersons(pagePersons +1 < persons.length/10 ? pagePersons+1:pagePersons)}
    const onBackDevice=()=>{setPageDevice(pageDevice -1 >-1 ? pageDevice-1:pageDevice)}
    const onNextDevice=()=>{setPageDevice(pageDevice +1 < devices.length/10 ? pageDevice+1:pageDevice)}
     useEffect(
        ()=>{
            if(localStorage.getItem("rol") !== "admin")
                return(navigate("/error"));

            fetch("http://localhost:8080/person", {
                headers: {
                    "Content-Type": "application/json"},
                method: "get",
            }).then((response) => {
                    if (response.status === 200) return response.json();
                }).then((response) => {
                    if (!response)
                        showError("Admin fail");
                    else {
                        setPersons(response);
                    }
                })
            }, [])

    return(<div><h1>Bine ai venit admin {localStorage.getItem("user")}</h1>
        <div>
            <h2>Users</h2>
            <div className="Button" onClick={createUser}><button>Create</button></div>
            <div className="Button" onClick={deleteUser}><button>Delete</button></div>
            <div className="Button" onClick={updateUser}><button>Update</button></div>
            <div className="Button" onClick={searchUser}><button>Search</button></div>
        </div>
        {persons && <div style={{width: "50%", boxShadow: "3px 6px 3px #ccc"}}>
            <table cellSpacing={"0"}
                   style={{width: "100%", height: "auto", padding: "5px 10 px"}}>
            <thead><tr>
                <th>User</th>
                <th>Pass</th>
                <th>Rol</th>
            </tr></thead>
            <tbody>{persons.slice(10 * pagePersons, 10*pagePersons+10).map((person)=>{return(<tr key={person.id}>
                <td>{person.username}</td>
                <td>{person.userPassword}</td>
                <td>{person.rol}</td>
            </tr>)})}</tbody>
            <tfoot><tr><td></td>
            <td style={{padding: "10px 0"}}>
                <button onClick={onBackPersons}>Back</button>
                <label style={{padding: "0 lem"}}>{pagePersons+1}</label>
                <button onClick={onNextPersons}>Next</button>
            </td></tr></tfoot>
        </table> </div>}
        <div>
            <h2>Devices</h2>
            <div className="Button" onClick={createDevice}><button>Create</button></div>
            <div className="Button" onClick={deleteDevice}><button>Delete</button></div>
            <div className="Button" onClick={updateDevice}><button>Update</button></div>
            <div className="Button" onClick={searchDevice}><button>Search</button></div>
        </div>
        {devices && <div style={{width: "50%", boxShadow: "3px 6px 3px #ccc"}}>  <table cellSpacing={"0"}
                                                                                        style={{width: "100%", height: "auto", padding: "5px 10 px"}}>
            <thead><tr>
                <th>Person</th>
                <th>Description</th>
                <th>Adress</th>
                <th>Consumption</th>
            </tr></thead>
            <tbody>{devices.slice(10 * pageDevice, 10*pageDevice+10).map((device)=>{return(<tr key={device.id}>
                <td>{device.person}</td>
                <td>{device.description}</td>
                <td>{device.address}</td>
                <td>{device.consumption}</td>
            </tr>)})}</tbody>
            <tfoot>
            <tr><td></td>
                <td style={{padding: "10px 0"}}>
                    <button onClick={onBackDevice}>Back</button>
                    <label style={{padding: "0 lem"}}>{pageDevice+1}</label>
                    <button onClick={onNextDevice}>Next</button>
                </td></tr>
            </tfoot>

        </table> </div>}
        <div className="Button" onClick={delog}><button>Delog</button></div>
    </div>);
}
export default Admin;