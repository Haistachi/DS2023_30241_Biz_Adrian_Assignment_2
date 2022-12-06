function showError(message) {console.log(message);}
function getPersons(callback)
{
    fetch("http://localhost:8080/person", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    }).then((response) => {
        if (response.status === 200) return response.json();
    }).then((response) => {
        if (!response){
            showError("Admin get persons fail");
            response.json().then(err => callback(null, response.status,  err));}
        else {response.json().then(json => callback(json, response.status,null));}
    });
}

function insertPersons(user, callback)
{
    fetch("http://localhost:8080/person", {
        headers: {
            "Content-Type": "application/json"},
        method: "post",
        body: JSON.stringify({"username" : user.name, "userPassword": user.pass, "rol": user.user})
    })
        .then((response) => {
            if (response.status === 201) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Admin fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {
                response.json().then(json => callback(json, response.status,null));
            }
        });
}

function findPersons(user, callback)
{
    fetch("http://localhost:8080/person", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    })
        .then((response) => {
            if (response.status === 200) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Find fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {response.json().then(json => callback(json, response.status,null));}
        });
}

function getPersonById(user, callback)
{
    fetch("http://localhost:8080/person", {
        headers: {
            "Content-Type": "application/json"},
        method: "get",
    })
        .then((response) => {
            if (response.status === 200) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Find fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {response.json().then(json => callback(json, response.status,null));}
        });
}

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

function insertDevice(device, callback)
{
    fetch("http://localhost:8080/device", {
        headers: {
            "Content-Type": "application/json"},
        method: "post",
        body: JSON.stringify({"person" : device.person,
            "description": device.description, "address": device.address, "consumption": device.consumption})})
        .then((response) => {
            if (response.status === 201) return response.text();
        })
        .then((response) => {
            if (!response){
                showError("Add device fail");
                response.json().then(err => callback(null, response.status,  err));}
            else {
                response.json().then(json => callback(json, response.status,null));
            }
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

function findOwnerDevices(owner, callback)
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
                showError("Find owned devices fail");
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
    getDeviceById,
    insertDevice,
    getPersonById,
    findPersons,
    findOwnerDevices,
    insertPersons,
    getPersons
};