function Error(props)
{
    return (<div className={'modal'}><h1>Eroare. Nu mai fi bulangiu! De ce esti bulangiu?</h1>
        <div className={'btn'} onClick={props.onClick}><button className='btn'>Nu mai fac boss</button></div>
    </div>);
}
export default Error;