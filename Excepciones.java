package com.mycompany.actmaria;
/**
 *
 * @author Mishelle Nuñez
 */

// Excepción para datos vacíos o inválidos
 class DatosInvalidosException extends IllegalArgumentException {
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}

// Excepción para precios inválidos
 class PrecioInvalidoException extends DatosInvalidosException {
    public PrecioInvalidoException() {
        super("El precio debe ser mayor a cero");
    }
}

// Excepción para IDs duplicados
 class DatosDuplicadosException extends Exception {
    public DatosDuplicadosException(String mensaje) {
        super(mensaje);
    }
}
// Excepción para formato de ID incorrecto
 class FormatoIdInvalidoException extends DatosInvalidosException {
    public FormatoIdInvalidoException() {
        super("Formato de ID invalido. Use CAT-001");
    }
}

