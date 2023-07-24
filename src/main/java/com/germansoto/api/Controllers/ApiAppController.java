package com.germansoto.api.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.germansoto.api.entity.Platos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiAppController {

    private final ObjectMapper objectMapper;

    public ApiAppController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/plato/{numeroDePlato}")
    public ResponseEntity<?> consultarPlato(@PathVariable Integer numeroDePlato) {
        List<Platos> plato = null;

        switch (numeroDePlato) {
            case 1:
                plato = crearPlato(1, "Menú Dos", 12.4, "Comida crudi-vegana");
                break;
            case 2:
                plato = crearPlato(2, "Menú Dos", 12.7, "Comida vegana");
                break;
            case 3:
                plato = crearPlato(3, "Menú Tres", 10.5, "Comida pizza-vegana");
                break;
            case 4:
                plato = crearPlato(4, "Menú Cuatro", 8.0, "Comida asado-vegano");
                break;
            case 5:
                plato = crearPlato(5, "Menú Cinco", 15.0, "Helado vegana");
                break;
            default:
                String mensajeError = "El número de plato ingresado no es válido.";
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), mensajeError);
                String jsonResponse;
                try {
                    jsonResponse = objectMapper.writeValueAsString(errorResponse);
                } catch (Exception e) {
                    jsonResponse = "{\"status\": 400, \"message\": \"El número de plato ingresado no es válido.\"}";
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
        }
        return ResponseEntity.ok(plato);
    }

    private List<Platos> crearPlato(int id, String nombre, double precio, String descripcion) {
        List<Platos> plato = new ArrayList<>();
        plato.add(new Platos(id, nombre, precio, descripcion));
        return plato;
    }

    // Clase para representar el objeto de error
    private static class ErrorResponse {
        private int status;
        private String message;

        public ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        // Getters y setters (opcional) para la serialización JSON
    }
}
