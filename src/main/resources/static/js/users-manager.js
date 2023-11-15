let loadUsersButton = document.getElementById('loadAllUsers');

loadUsersButton.addEventListener('click',loadUsersHandler);

function loadUsersHandler(){

    let tbodyElement = document.getElementById('users-table');

    tbodyElement.innerHTML = '';;

    fetch('http://localhost:8080/api/users-all')
        .then(response => response.json())
        .then(json => json.forEach(user => {

            let row = document.createElement('tr');
            let emailCol = document.createElement('td');
            let firstNameCol = document.createElement('td');
            let lastNameCol = document.createElement('td');
            let makeAdminCol = document.createElement('td');

            emailCol.textContent=user.email;
            firstNameCol.textContent=user.firstName;
            lastNameCol.textContent=user.lastName;

            let makeAdminButton = document.createElement('button');
            makeAdminButton.innerHTML='Make Admin';
            makeAdminButton.dataset.id=user.id;
            makeAdminButton.setAttribute('style', 'padding: 5px');
            makeAdminButton.addEventListener('click',makeAdminHandler)

            makeAdminCol.appendChild(makeAdminButton);

            row.appendChild(emailCol);
            row.appendChild(firstNameCol);
            row.appendChild(lastNameCol);
            row.appendChild(makeAdminCol);


            tbodyElement.appendChild(row);

        }))
}

function makeAdminHandler(){
    alert('MAKE ADMIN')
}