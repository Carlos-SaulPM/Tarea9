package unam.fesaragon.estructuradatos.codigoJava;

import unam.fesaragon.estructuradatos.ADT.ADTStack;

public class CodigoJava {
    private String codigoJavaEnString;
    private String urlArchivo;
    private ADTStack<Character> pilaLlavesOParentesis;

    public CodigoJava(String urlArchivo) {
        this.urlArchivo = urlArchivo;
        pilaLlavesOParentesis = new ADTStack<>();
    }

    public CodigoJava() {
        pilaLlavesOParentesis = new ADTStack<>();
    }

    public void ejecutarCodigo() {
        // Lectura de código
        // Comprobación de errores
        codigoJavaEnString = "{{()}}";
        boolean estaBalanceado = cargarPilaBalanceo(codigoJavaEnString);
        System.out.println((estaBalanceado)? "Esta balanceado": "No esta balanceado");
    }

    private boolean cargarPilaBalanceo(String codigo) {
        boolean estaBalanceado = true;
        for (Character caracter : codigo.toCharArray()) {
            if (caracter == '{' || caracter == '(') {
                pilaLlavesOParentesis.push(caracter);
            } else if (caracter == '}' || caracter == ')') {
                if (pilaLlavesOParentesis.isEmpty()) {
                    estaBalanceado = false;
                    break;
                }
                char caracterApertura = pilaLlavesOParentesis.pop();
                if ((caracter == '}' && caracterApertura != '{') || (caracter == ')' && caracterApertura != '(')) {
                    estaBalanceado = false;
                    break;
                }
            }
        }

        return estaBalanceado;
    }
}
