function createProduct(){ 
    
    let product_id = document.querySelector('#product_id'); 
    let description = document.querySelector('#description');
    let price = document.querySelector('#price');
    let category_id = document.querySelector('#category_id');
    let stock = document.querySelector('#stock');
    let image_path = document.querySelector('#image_path');

    let image_name = image_path.value.split('fakepath\\')[1];
     
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos"; 

    xhr.open("POST", url, true); 

    xhr.setRequestHeader("Content-Type", "application/json"); 
    
    let xhr_1 = new XMLHttpRequest(); 
    let url_1 = "http://localhost:8080/api/v1/Categorias/" + category_id.value; 

    xhr_1.open("GET", url_1, true); 

    xhr_1.setRequestHeader("Content-Type", "application/json"); 

     
    xhr_1.onreadystatechange = function () { 
       
        if (xhr_1.readyState === 4 && xhr_1.status === 200) { 

            let categoria = JSON.parse(this.responseText);
            var data = JSON.stringify({ "id_productos": product_id.value, "descripcion": description.value, "precio": price.value, categoria,
                                 "existencia": stock.value, "image_url" : image_name }); 
            xhr.send(data); 
        } 
    }; 

    xhr_1.send();
    alert("New product saved");
} 

function showAllProducts(){ 

    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos"; 

    xhr.open("GET", url, true);
    xhr.setRequestHeader("Content-Type", "application/json"); 
    xhr.onreadystatechange = function () { 
        if (xhr.readyState === 4 && xhr.status === 200) { 

            let list = JSON.parse(this.responseText);
            let main = "";

            for(let i=0; i < list.length ; i ++){
                main += "<tr><td>" + list[i].id_producto + "</td><td>" +  list[i].descripccion + "</td>"
                + "<td>" +  list[i].precio + "</td>" + "<td>" +  list[i].categoria.id_categorias + "</td>"
                + "<td>" +  list[i].existencia + "</td>" + "<td>" +  list[i].image_url + "</td></tr>";
            }

            let table_top = "<table style='margin-left: auto; margin-right: auto;' border='1'>";
            let table_bottom = "</table>";
            let headers = "<tr><th>Product id</th><th>Name</th><th>Price</th><th>Category id</th><th>Stock</th><th>Image url</th></tr>";

            document.getElementById("table").innerHTML = table_top + headers + main + table_bottom;
        } 
    }; 

    xhr.send();
    
} 

function searchProductById(){ 

    let product_id = document.querySelector('#product_id2search').value;
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos/" + product_id; 

    xhr.open("GET", url, true); 
    xhr.setRequestHeader("Content-Type", "application/json"); 
    xhr.onreadystatechange = function () { 
       
        if (xhr.readyState === 4 && xhr.status === 200) { 

            let resultado = JSON.parse(this.responseText);
            main = "<tr><td>" + resultado.id_producto + "</td><td>" +  resultado.descripccion + "</td>"
                + "<td>" +  resultado.precio + "</td>" + "<td>" +  resultado.categoria.id_categorias + "</td>"
                + "<td>" +  resultado.existencia + "</td>" + "<td>" +  resultado.image_url + "</td></tr>";

            let table_top = "<table style='margin-left: auto; margin-right: auto;' border='1'>";
            let table_bottom = "</table>";
            let headers = "<tr><th>Product id</th><th>Name</th><th>Price</th><th>Category id</th><th>Stock</th><th>Image url</th></tr>";
            document.getElementById("table1").innerHTML = table_top + headers + main + table_bottom;
        }

        else{
            document.getElementById("table1").innerHTML = "<h3 style='color:red'>NOT FOUND</h3>";
        }
    }; 
    
    xhr.send();
    
}

function updateProduct(){ 

    let product_id = document.querySelector('#product_id2update').value;
    let description = document.querySelector('#description2update');
    let price = document.querySelector('#price2update');
    let category_id = document.querySelector('#category_id2update');
    let stock = document.querySelector('#stock2update');
    let image_url = document.querySelector('#image_path2update');
    let image_name = image_url.value.split('fakepath\\')[1];

    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos/" + product_id; 

    xhr.open("PUT", url, true); 
    xhr.setRequestHeader("Content-Type", "application/json");
    let xhr_1 = new XMLHttpRequest(); 
    let url_1 = "http://localhost:8080/api/v1/Categorias/" + category_id.value; 
    xhr_1.open("GET", url_1, true); 
    xhr_1.setRequestHeader("Content-Type", "application/json"); 
    xhr_1.onreadystatechange = function () { 
       
        if (xhr_1.readyState === 4 && xhr_1.status === 200) { 

            let categoria = JSON.parse(this.responseText);
            var data = JSON.stringify({ "id_productos": product_id.value, "descripcion": description.value,
                                 "precio": price.value, 
                                 "categoria":{"id_categorias":category_id.value,"descripcion":categoria.descripcion},
                                 "existencia": stock.value, "image_url" : image_name });
            xhr.send(data); 
        } 
    }; 

    xhr_1.send();
}

function deleteProduct(){ 

    let product_id = document.querySelector('#product_id2delete').value;
    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos/" + product_id; 

    xhr.open("DELETE", url, true); 
    xhr.setRequestHeader("Content-Type", "application/json"); 
    xhr.send(); 
    alert("Deleted product with id " + product_id);
    
}

function deleteProductStock(){
    let product_id = document.querySelector('#product_id2remove').value;


    let xhr = new XMLHttpRequest(); 
    let url = "http://localhost:8082/api/v1/Productos/" + product_id; 

    xhr.open("PUT", url, true); 
    xhr.setRequestHeader("Content-Type", "application/json");

    let xhr_1 = new XMLHttpRequest(); 
    let url_1 = "http://localhost:8082/api/v1/Productos/" + product_id; 

    xhr_1.open("GET", url_1, true); 
    xhr_1.setRequestHeader("Content-Type", "application/json"); 
    xhr_1.onreadystatechange = function () { 
       
        if (xhr_1.readyState === 4 && xhr_1.status === 200) { 

            let resultado = JSON.parse(this.responseText);
            var data = JSON.stringify({ "id_productos": resultado.id_productos, "descripcion": resultado.descripccion,
                                 "precio": resultado.precio, 
                                 "categoria":{"id_categorias" : resultado.categoria.id_categorias,
                                 "descripcion": resultado.categoria.descripcion},
                                 "existencia": 0, "image_url" : resultado.image_url });
            xhr.send(data); 
        } 
    }; 
    
    xhr_1.send();

}