'use strict';

let form = document.forms["create"];
createNewUser()

function createNewUser() {
    form.addEventListener("submit", ev => {
        ev.preventDefault();
        let roles = [];
        for (let i = 0; i < form.roles.options.length; i++) {
            if (form.roles.options[i].selected) roles.push({
                id: form.roles.options[i].value,
                role: "ROLE_" + form.roles.options[i].text
            });
        }
        fetch("apiAuth/users", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: form.username.value,
                password: form.password.value,
                yob: form.yob.value,
                country: form.country.value,
                roles: roles
            })
        })
            .then(response => response.text())
            .then(data => {
                console.log('Response from server:', data);
                form.reset();
                $('#home-tab').click();
                getTableUser();

            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
}



