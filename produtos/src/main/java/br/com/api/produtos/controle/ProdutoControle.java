package br.com.api.produtos.controle;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos") // Define um prefixo para todas as rotas
@CrossOrigin("*") // Permite requisições de qualquer origem (útil para frontend separado)
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @GetMapping
    public String rota() {
        return "API funcionando";
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
        return ps.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) { // ✅ Correção aqui!
        return ps.cadastrar(pm);
    }

   @PutMapping("/alterar")
public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm) {
    return ps.cadastrarAlterar(pm,"alterar"); // ✅ Corrigido erro de digitação
}

@DeleteMapping("/remover/{codigo}")
public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
    return ps.remover(codigo); // ✅ Corrigido erro de digitação
}

    }

