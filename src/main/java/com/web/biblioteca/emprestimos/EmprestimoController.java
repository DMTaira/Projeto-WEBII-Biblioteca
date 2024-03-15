package com.web.biblioteca.emprestimos;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emprestimos")
@ControllerAdvice
public class EmprestimoController {

    private EmprestimoService service ;
    public EmprestimoController(EmprestimoService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity incluirEmprestimo(@Valid @RequestBody EmprestimoRequest request){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarEmprestimo(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<EmprestimoDto>> getAllEmprestimos(){

        return ResponseEntity.ok().body(service.getAll());

    }
    @GetMapping("{id}")
    public ResponseEntity getEmprestimoPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarEmprestimoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro ID: " + id);
        }
    }

    @PutMapping ("/devolver/{id}")
    public ResponseEntity putDevolver(@PathVariable Long id, @RequestBody EmprestimoRequest EmprestimoRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.devolverEmprestimo(id,EmprestimoRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: " + e);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", java.time.LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}