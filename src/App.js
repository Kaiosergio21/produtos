import logo from './logo.svg';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';
import React, { useState,useEffect } from 'react';


function App() {

  const [btnCadastrar,setBtnCadastrar ] = useState(true);
  const[produtos,setProdutos] = useState([]);

  useEffect(() => {

    fetch("http://localhost:8080/produtos/listar")
    .then(retorno=>retorno.json())
    .then (retorno_convertido => setProdutos(retorno_convertido));

  },[]);

  return (  
              <div >

               <p>{JSON.stringify(produtos)}</p>
                <Formulario botao = {btnCadastrar}/>
                <Tabela/>
               

              </div>

  );
}

export default App;
