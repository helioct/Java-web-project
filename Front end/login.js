function login(){

    let mail = document.querySelector('#email');
    let password = document.querySelector('#password');
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8081/api/v1/login";
  
    xhr.open("POST", url, true);
  
    xhr.setRequestHeader("Content-Type", "application/json");

        var flag=0;
        xhr.onreadystatechange = function () { 
            if (xhr.readyState === 4 && xhr.status === 200) {

                var object = JSON.parse(this.responseText);
                
                    if(object.tipo==1){
                        console.log(this.responseText ); 
                        alert("Login succesful"); 
                        window.location.href = "MainPageUser.html";
                    }else{
                        console.log(this.responseText); 
                        alert("Login succesful"); 
                        window.location.href = "MainPageManager.html";
                    }
        
            } else if(xhr.status===404 && flag==0){
                    flag+=1;
                    alert("Invalid credentials");
                }       
        }; 

    var data = JSON.stringify({ "mail": mail.value, "password": password.value });       
    xhr.send(data);
  }