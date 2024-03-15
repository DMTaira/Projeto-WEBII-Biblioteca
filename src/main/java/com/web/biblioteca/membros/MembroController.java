package com.web.biblioteca.membros;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/membros")
@ControllerAdvice
public class MembroController {

        private MembroService service ;
        //injecao de dependencia
        public MembroController(MembroService service) {
            this.service = service;
        }

    @PostMapping
        public ResponseEntity salvarMembro(@Valid @RequestBody MembroRequest membro) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarMembro(membro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<MembroDto>> getAllMembros(){

            return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")

    public ResponseEntity getMembroPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarMembroPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro ao buscar membro pelo id: " + id);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity putMembro(@PathVariable Long id, @RequestBody MembroRequest membroRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.alterarMembro(id,membroRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: " + e);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMembroporId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteMembroPorId(id));
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
