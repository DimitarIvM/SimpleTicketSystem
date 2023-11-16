let loadUsersButton = document.getElementById('loadAllProducts');

loadUsersButton.addEventListener('click',loadProductsHandler);
loadUsersButton.setAttribute('style', 'padding: 5px');

function loadProductsHandler(){

    let tbodyElement = document.getElementById('products-table');

    tbodyElement.innerHTML = '';

    fetch('http://localhost:8080/api/products-all')
        .then(response => response.json())
        .then(json => json.forEach(product => {

            let row = document.createElement('tr');
            let productName = document.createElement('td');
            let serialNumber = document.createElement('td');
            let partNumber = document.createElement('td');


                productName.textContent=product.productName;
            serialNumber.textContent=product.partNumber;
            partNumber.textContent=product.lastName;




            row.appendChild(productName);
            row.appendChild(serialNumber);
            row.appendChild(partNumber);



            tbodyElement.appendChild(row);

        }))
}
