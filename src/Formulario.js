function Formulario({botao}){

    return(
        <form>
             <input type="text" placeholder="Nome" className="form-Control"></input>
             <input type="text" placeholder="Marca" className="form-Control"></input>

            {botao
            ?

            <input type="button" value="Cadatrar" className="btn btn-primary" ></input>

            :


          <div>


             <input type="button" value="Alterar" className="btn btn-warning" ></input>
             <input type="button" value="Remover" className="btn btn-danger" ></input>
             <input type="button" value="Cancelar" className="btn btn-secondary" ></input>

             
          </div>
}
             
        </form>
    )
}

export default Formulario;