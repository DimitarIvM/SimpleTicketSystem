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

          data.forEach( subject =>{



                  let row = document.createElement('tr');
                  let sub = document.createElement('td');

                  sub.innerHTML =subject;

                  row.appendChild(sub);




                  tbodyElement.appendChild(row);
          });



        }).catch(error => {
            console.error("error fetching data: ",error)
    });
}
