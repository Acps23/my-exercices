function getData(url) {
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            populateTable(data);
            postData(data, "http://127.0.0.1:5500/index.html");
        })
        .catch((error) => console.error(error));
}
function populateTable(data) {
  const table = document.querySelector("#customer-table");
    data.forEach((customer) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
        `;
        table.appendChild(row);
    })
}
getData("http://localhost:8080/javabank5/api/customer");
function postData(data, url) {
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then((response) => response.json())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}








/* 
const apiEndpoint = 'http://localhost:8080/javabank1/customer/list';

// Use Fetch to get the customers from the API
fetch(apiEndpoint)
  .then(response => {
    // Check if the response was successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    // Parse the response as JSON
    return response.json();
  })
  .then(data => {
    // Use the data to populate the table
    populateTable(data);
  })
  .catch(error => {
    console.error('Error fetching customers:', error);
  });

// Function to populate the table with customer data
function populateTable(customers) {
  const tableBody = document.querySelector('tbody');
  // Clear any existing table rows
  tableBody.innerHTML = '';

  // Loop through each customer and add a table row
  customers.forEach(customer => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${customer.firstName}</td>
      <td>${customer.lastName}</td>
      <td>${customer.email}</td>
      <td>${customer.phone}</td>
    `;
    tableBody.appendChild(row);
  });
} */