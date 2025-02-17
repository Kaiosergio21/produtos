package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    public ResponseEntity<?> cadastrar(ProdutoModelo pm) { // Correção do tipo do parâmetro
        RespostaModelo rm = new RespostaModelo(); // Criando instância dentro do método

        if (pm.getNome() == null || pm.getNome().trim().isEmpty()) {
            rm.setMensagem("O nome é obrigatório");
            return ResponseEntity.badRequest().body(rm);
        }

        ProdutoModelo produtoSalvo = pr.save(pm);
        return ResponseEntity.ok(produtoSalvo);
    }

    public Iterable<ProdutoModelo> listar() {
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao) {
        RespostaModelo rm = new RespostaModelo();
    
        if (pm.getNome() == null || pm.getNome().trim().isEmpty()) {
            rm.setMensagem("O nome é obrigatório");
            return ResponseEntity.badRequest().body(rm);
        }else if(pm.getMarca() == null || pm.getMarca().trim().isEmpty()){
           
            rm.setMensagem("O marca é obrigatório");
            return ResponseEntity.badRequest().body(rm);

        }
    
        ProdutoModelo produtoSalvo = pr.save(pm);
        return ResponseEntity.ok(produtoSalvo);
    }

   
    public ResponseEntity<RespostaModelo> remover(long codigo) {
        RespostaModelo resposta = new RespostaModelo();
        
        // Verifica se o produto existe
        if (!pr.existsById(codigo)) {
            resposta.setMensagem("Produto não encontrado!");
            return ResponseEntity.badRequest().body(resposta);
        }
    
        // Remove o produto do banco de dados
        pr.deleteById(codigo);
        
        // Retorna uma resposta com a mensagem de sucesso
        resposta.setMensagem("Produto foi deletado!");
        return ResponseEntity.ok(resposta);
    }
    
   
}
