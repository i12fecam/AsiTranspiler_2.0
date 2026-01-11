package Internals.Errors;
import static Internals.Errors.ErrorLevelEnum.*;
public enum ErrorEnum {
    FALTA_BLOQUE_NECESARIO(FATAL_ERROR,"Falta bloque/s necesarios para el objetivo definido (%s)"),
    INSTRUCCION_MISMO_NOMBRE(FATAL_ERROR,"Ya existe otra instrucción con el mismo nombre (%s)"),
    VARIABLE_MISMO_NOMBRE(FATAL_ERROR,"Ya existe otra variable con el mismo nombre (%s)"),
    TAMANYO_VECTOR_INVALIDO(FATAL_ERROR,"El tamaño del vector definido es inválido (%s)"),
    INICIALIZACION_VECTOR_INVALIDA(FATAL_ERROR,"El numero de valores inicializados no coinciden con el tamaño del vector"),
    ETIQUETA_MISMO_NOMBRE(FATAL_ERROR,"Ya existe otra etiqueta con el mismo nombre (%s)"),
    MICROINSTRUCCION_NO_RECONOCIDA(FATAL_ERROR,"No se ha podido reconocer la instrucción (%s)"),
    MICROINSTRUCCION_INVALIDA(FATAL_ERROR,"La microinstrucción utilizada es inválida en este contexto (%s)"),
    BANDERA_NO_RECONOCIDA(FATAL_ERROR,"No se ha podido reconocer la bandera (%s)");
    public final ErrorLevelEnum level;
    public final String msgFormat;
    ErrorEnum(ErrorLevelEnum level, String msg){
        this.level = level;
        this.msgFormat = msg;
    }
}
