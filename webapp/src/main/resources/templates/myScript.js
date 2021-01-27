function check(){
    var name=document.getElementById("user").value;
    var pass=document.getElementById("pass").value;
    console.log(name);
    console.log(pass);
    if( name=== "doni" && pass === "1234"){

        document.location.href = "https://127.0.0.1:9001";
        //document.open("text/html", "replace");
        /*document.write("<!DOCTYPE html> "+
        "<html>"+
        "<body>"+

        "</body>"+
        "</html>"
        );*/
        document.close();
    }else{
        alert("Wrong data");
    }

}
