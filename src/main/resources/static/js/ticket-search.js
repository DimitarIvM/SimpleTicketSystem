let searchButton = document.getElementById('loadTickets');
let searchElement = document.getElementById('searchBy');


searchButton.addEventListener('click',searchTickets);
searchButton.setAttribute('style', 'padding: 5px');

function searchTickets(){

    let tbodyElement = document.getElementById('tickets-table');

    tbodyElement.innerHTML = '';
    let snToSearch = searchElement.value;
    fetch('http://localhost:8080/api/tickets/' + snToSearch)
        .then(response => response.json())
        .then(data  => {

            let row = document.createElement('tr');
            let subject = document.createElement('td');
            let client = document.createElement('td');



            subject.textContent = data[0];





            row.appendChild(subject);




            tbodyElement.appendChild(row);

        }).catch(error => {
            console.error("error fetching data: ",error)
    });
}
