import {Link, useNavigate} from 'react-router-dom';
import {useEffect, useState} from "react";
import table from "../../commons/tables/table";
import Active from "./Active";

function User(props)
{
    const navigate = useNavigate();
    const [devices, setDevices] = useState([]);
    const [pageDevice, setPageDevice]= useState(0);
    const onBackDevice=()=>{setPageDevice(pageDevice -1 >-1 ? pageDevice-1:pageDevice)}
    const onNextDevice=()=>{setPageDevice(pageDevice +1 < devices.length/10 ? pageDevice+1:pageDevice)}
    function statistic()
    {

    }
    function search()
    {

    }
    function showError(message) {console.log(message); return(navigate("/error"));}
    function delog() { localStorage.clear(); return(navigate("/"));}
    useEffect(
        ()=>{
            //console.log(localStorage.getItem("rol"));
            if(localStorage.getItem("rol") !== "user")
                return(navigate("/error"));

            fetch("http://localhost:8080/device", {
                headers: {
                    "Content-Type": "application/json"},
                method: "get",
            })
                .then((response) => {
                    if (response.status === 200) return response.json();
                })
                .then((response) => {
                    if (!response)
                        showError("User fail");
                    else {
                        setDevices(response);
                    }
                })
        }, [])

    return(<div><h1>Bine ai venit user {props.name}</h1>
        <div>
            <h2>Your devices</h2>
            <div className="Button" onClick={statistic}>{<Active/>} <button>Statistic</button> </div>
            <div className="Button" onClick={search}><button>Search</button></div>
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
        </div>
    </div>);
}

export default User;