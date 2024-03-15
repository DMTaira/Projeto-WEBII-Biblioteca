
package com.web.biblioteca.livros;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@ControllerAdvice
public class LivroController {

    private LivroService service ;
    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity incluirLivro(@Valid @RequestBody LivroRequest request){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarLivro(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<LivroDto>> getAllLivros(){
        return ResponseEntity.ok().body(service.getAll());

    }
    @GetMapping("{id}")
    public ResponseEntity getLivroPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarLivroPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Livro não cadastrado ID: " + id);
        }
    }

    @PutMapping ("{id}")

    public ResponseEntity putLivro(@PathVariable Long id, @RequestBody LivroRequest livroRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.alterarLivro(id,livroRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: " + e);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteLivroPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteLivroPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: " + e);
        }
    }

//   
//    import org.springframework.http.HttpStatus;
//      import org.springframework.http.ResponseEntity;
//
//    @PostMapping()  ROSIVAN
//    public ResponseEntity<?> postUsuario(@RequestBody Usuario usuario) {
//        try {
//            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createUsuario(usuario));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar usuário!");
//        }
//    }

}