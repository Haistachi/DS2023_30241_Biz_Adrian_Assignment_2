import {Link, useNavigate} from 'react-router-dom';
import {useEffect, useState} from "react";
import table from "../../commons/tables/table";
import Calendar from "./Calendar";
import {findDeviceActive, findOwnerDevices, getDevices} from "./user-api";
import Active from "./Active";

function User(props)
{
    const navigate = useNavigate();
    const [name, setName] = useState("");
    const [devices, setDevices] = useState([]);
    const [pageDevice, setPageDevice]= useState(0);
    const [chartData, setChartData]= useState([]);
    const [calendarDate, setCalendarDate] = useState(new Date());
    const [idDevice, setIdDevice] = useState("");
    const [activeChart, setActiveChart] = useState(false);
    const onBackDevice=()=>{setPageDevice(pageDevice -1 >-1 ? pageDevice-1:pageDevice)}
    const onNextDevice=()=>{setPageDevice(pageDevice +1 < devices.length/10 ? pageDevice+1:pageDevice)}
    function importData()
    {
        return({
            labels: chartData.map((data) => data.hour),
                datasets: [
            {
                label: "Device Consume",
                data: chartData.map((data) => data.deviceConsume),
                backgroundColor: [
                    "rgba(75,192,192,1)",
                    "#ecf0f1",
                    "#50AF95",
                    "#f3ba2f",
                    "#2a71d0",
                ],
                borderColor: "black",
                borderWidth: 2
            }
        ]
        });
    }
    function statistic()
    {
        findDeviceActive(idDevice, calendarDate,(res, stat, err)=>{if(err) console.log(err);
        else {console.log(res);
            console.log(res.map((active) => active.consumption));
            setChartData(res.map((active) => active.consumption));
        }});
        setActiveChart(true);
    }
    function showError(message) {console.log(message); return(navigate("/error"));}
    function delog() { localStorage.clear(); return(navigate("/"));}
    useEffect(
        ()=>{
            //console.log(localStorage.getItem("rol"));
            if(localStorage.getItem("rol") !== "user")
                return(navigate("/error"));
            setName(localStorage.getItem("name"));
            findOwnerDevices(name,(res, stat, err)=>{if(err) console.log(err);
            else {console.log(res);
                setDevices(res);
                console.log(Array.isArray(res));
            }});
        }, [])

    return(<div><h1>Bine ai venit user {props.name}</h1>
        <div>
            <div className="Button" >{<Calendar date={calendarDate} setDate={setCalendarDate}/>}
                <button onClick={statistic}>Statistic</button> </div>
            {activeChart && <Active chartData={chartData} date={calendarDate}/>}
            <label htmlFor={"idDevice"}>Device: </label>
            <input readOnly={idDevice} type={"idDevice"} placeholder={idDevice} id={"idDevice"} name={"idDevice"}
                   style={{width: "20%", boxShadow: "3px 6px 3px #ccc"}}></input>
            <h2>Your devices</h2>
            {devices && <div style={{width: "80%", boxShadow: "3px 6px 3px #ccc"}}>
                <table cellSpacing={"0"} style={{width: "100%", height: "auto", padding: "5px 10 px", textAlign:"center"}}>
                <thead><tr>
                    <th>ID</th>
                    <th>Person</th>
                    <th>Description</th>
                    <th>Adress</th>
                    <th>Consumption</th>
                </tr></thead>
                <tbody>{devices.slice(10 * pageDevice, 10*pageDevice+10).map((device)=>{return(<tr key={device.id} onClick={()=>setIdDevice(device.id)}>
                    <td>{device.id}</td>
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
            <div className="Button"><button onClick={delog}>Delog</button></div>
        </div>
    </div>);
}

export default User;