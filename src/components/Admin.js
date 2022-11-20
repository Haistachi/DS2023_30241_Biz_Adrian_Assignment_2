function Admin(props)
{
    function createUser(){}
    function deleteUser(){}
    function updateUser(){}
    function searchUser(){}
    function createDevice(){}
    function deleteDevice(){}
    function updateDevice(){}
    function searchDevice(){}

    return(<div><h1>Bine ai venit admin {props.name}</h1>
        <div>
            <h2>Users</h2>
            <div className="Button" onClick={createUser}><button>Create</button></div>
            <div className="Button" onClick={deleteUser}><button>Delete</button></div>
            <div className="Button" onClick={updateUser}><button>Update</button></div>
            <div className="Button" onClick={searchUser}><button>Search</button></div>
        </div>
        <div>
            <h2>Devices</h2>
            <div className="Button" onClick={createDevice}><button>Create</button></div>
            <div className="Button" onClick={deleteDevice}><button>Delete</button></div>
            <div className="Button" onClick={updateDevice}><button>Update</button></div>
            <div className="Button" onClick={searchDevice}><button>Search</button></div>
        </div>
    </div>);
}
export default Admin;