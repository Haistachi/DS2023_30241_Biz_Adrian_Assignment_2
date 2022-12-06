function showError(message) {console.log(message);}

function getDevices(callback)
{
    fetch("http://localhost:8080/device", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    }).then((response) => {
        if (response.status === 200) return response.json();
    }).then((response) => {
        if (!response){
            showError("Admin get devices fail");
            response.json().then(err => callback(null, response.status,  err));}
        else {response.json().then(json => callback(json, response.status,null));}
    });
}

function findDevices(device, callback)
{
    fetch("http://localhost:8080/device", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    })
        .then((response) => {
            if (response.status === 200) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Find devices fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {response.json().then(json => callback(json, response.status,null));}
        });
}

function getDeviceById(device, callback)
{
    fetch("http://localhost:8080/device", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    })
        .then((response) => {
            if (response.status === 200) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Find devices fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {response.json().then(json => callback(json, response.status,null));}
        });
}

export default {
    getDevices,
    findDevices,
    getDeviceById
};