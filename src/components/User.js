function User(props)
{
    function statistic()
    {

    }
    function search()
    {

    }

    return(<div><h1>Bine ai venit user {props.name}</h1>
        <div>
            <h2>Your devices</h2>
            <div className="Button" onClick={statistic}><button>Statistic</button></div>
            <div className="Button" onClick={search}><button>Search</button></div>
        </div>
    </div>);
}

export default User;