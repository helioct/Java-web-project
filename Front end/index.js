function createCat(){ 
    
    let category_id = document.querySelector('#category_id'); 
    let description = document.querySelector('#description'); 
    
    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8080/api/v1/Categorias"; 

    // open a connection 
    xhr.open("POST", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    // Create a state change callback 
    xhr.onreadystatechange = function () { 
        if (xhr.readyState === 4 && xhr.status === 200) { 

            // Print received data from server 
            //result.innerHTML = this.responseText; 

        } 
    }; 

    // Converting JSON data to string 
    var data = JSON.stringify({ "id_categorias": category_id.value, "descripcion": description.value }); 
    alert("New category saved");

    // Sending data with the request 
    xhr.send(data); 
} 


function showAllCats(){ 

    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8080/api/v1/Categorias"; 

    // open a connection 
    xhr.open("GET", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    // Create a state change callback 
    xhr.onreadystatechange = function () { 
        if (xhr.readyState === 4 && xhr.status === 200) { 

            // Print received data from server 
            //result.innerHTML = this.responseText; 
            let list = JSON.parse(this.responseText);
            let main = "";
            let table_top = "<table style='margin-left: auto; margin-right: auto;' border='1'>";
            let table_bottom = "</table>";

            for(let i=0; i < list.length ; i ++){
                main += "<tr><td>" + list[i].id_categorias + "</td><td>" +  list[i].descripcion + "</td></tr>";
            }
            
            let headers = "<tr><th>Category id</th><th>Description</th></tr>";
            document.getElementById("table").innerHTML = table_top + headers + main + table_bottom;
        } 
    }; 

    xhr.send();
    
} 

function searchCatById(callback){ 

    let category_id = document.querySelector('#category_id2search').value;

    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8080/api/v1/Categorias/" + category_id; 

    // open a connection 
    xhr.open("GET", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    let returned_data;
    // Create a state change callback 
    xhr.onreadystatechange = function() { 
       
        if (xhr.readyState === 4 && xhr.status === 200) { 

            let resultado = JSON.parse(this.responseText);
            main = "<tr><td>" + resultado.id_categorias + "</td><td>" +  resultado.descripcion + "</td></tr>";
            let headers = "<tr><th>Category id</th><th>Description</th></tr>";
            let table_top = "<table style='margin-left: auto; margin-right: auto;' border='1'>";
            let table_bottom = "</table>";
            document.getElementById("table2").innerHTML = table_top + headers + main + table_bottom;            
        }
        else{
            document.getElementById("table2").innerHTML = "<h3 style='color:red'>NOT FOUND</h3>";
        }  
    };

    xhr.send();
}

function updateCat(){ 

    let category_id = document.querySelector('#category_id2update').value;
    let description = document.querySelector('#description2update');

    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8080/api/v1/Categorias/" + category_id; 

    // open a connection 
    xhr.open("PUT", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    // Converting JSON data to string 
    var data = JSON.stringify({"descripcion": description.value }); 
    alert("Category updated");

    // Sending data with the request 
    xhr.send(data); 
    
}


function deleteCat(){ 

    let category_id = document.querySelector('#category_id2delete').value;

    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8080/api/v1/Categorias/" + category_id; 

    // open a connection 
    xhr.open("DELETE", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    // Sending data with the request 
    xhr.send(); 
    alert("Deleted category with id " + category_id);
    
}
