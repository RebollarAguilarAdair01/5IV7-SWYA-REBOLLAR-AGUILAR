var mysql = require('mysql');
var connection = mysql.createConnection({
   host: 'localhost',
   user: 'rebollar',
   password: 'rebollar',
   database: 'pescaderia_1',
   port: 3306
});
connection.connect(function(error){
   if(error){
      throw error;
   }else{
      console.log('Conexion correcta.');
   }
});

function Crear(){
   var usuario = document.getElementById("usuario").value;
   var contraseña = document.getElementById("contraseña").value;
   var query = connection.query("INSERT into usuarios(usuario,contraseña) VALUES(?,?)", [usuario,contraseña]);
   
    
   
   }

   var query = connection.query("INSERT into usuarios(usuario,contraseña) VALUES('jesus','209')", function(error,result,fields){
      if(error){
         throw error;
      }else{
         console.log(result);
      }
    }
   );
connection.end();