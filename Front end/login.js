function login(){

    //console.log ("Hello");
    let mail = document.querySelector('#email');
    let password = document.querySelector('#password');
    // Creating a XHR object
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8081/api/v1/login";
  
    // open a connection
    xhr.open("POST", url, true);
  
    // Set the request header i.e. which type of content you are sending
    xhr.setRequestHeader("Content-Type", "application/json");
    // Create a state change callback
        // Create a state change callback

        var flag=0;
        xhr.onreadystatechange = function () { 
            if (xhr.readyState === 4 && xhr.status === 200) {

                var object = JSON.parse(this.responseText);
                
                    if(object.tipo==1){
                        console.log(this.responseText ); 
                        alert("Login succesful"); 
                        window.location.href = "MainPageUser.html";
                        //MainPage User
                    }else{
                        console.log(this.responseText); 
                        alert("Login succesful"); 
                        window.location.href = "MainPageManager.html";
                        //MainPage Manager
                    }
        
            } else if(xhr.status===404 && flag==0){
                    flag+=1;
                    alert("Invalid credentials");
                }       
        }; 

    // Converting JSON data to string
    
    var data = JSON.stringify({ "mail": mail.value, "password": password.value });        
    // Sending data with the request
   xhr.send(data);

  
  }