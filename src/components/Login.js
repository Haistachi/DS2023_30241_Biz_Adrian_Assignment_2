import {useState} from "react";
import Error from "./Error";

function Login(props)
{
    const [error, setError]= useState(false);
    function login()
    {
        isError();
    }
    function register()
    {
        isError();
    }
    function isError()
    {
        setError(true);
    }
    function closeError()
    {
        setError(false);
    }

    return(<div className={'modal'}><h1>Energy Consum Login</h1>
    <div>
        <h2>Username</h2>
        <h2>Password</h2>
        <div className="Button" onClick={login}><button className='btn'>Login</button></div>
        <div className="Button" onClick={register}><button className='btn'>Register</button></div>
    </div>
        {error && <Error onClick={closeError}/>}
        </div>);
}
export default Login;