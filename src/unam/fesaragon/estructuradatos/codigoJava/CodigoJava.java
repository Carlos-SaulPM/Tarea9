package unam.fesaragon.estructuradatos.codigoJava;

import unam.fesaragon.estructuradatos.ADT.ADTStack;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class CodigoJava {
    private String codigoJavaEnString;
    private String urlArchivo;
    private ADTStack<Character> pilaLlavesOParentesis;

    public CodigoJava(String urlArchivo) {
        this.urlArchivo = urlArchivo;
        try {
        this.codigoJavaEnString = new String(Files.readAllBytes(Paths.get(urlArchivo)));
        }catch (IOException e){System.out.println(e);}
        pilaLlavesOParentesis = new ADTStack<>();
    }

    public CodigoJava() {
        pilaLlavesOParentesis = new ADTStack<>();
    }

    public void ejecutarCodigo() {
        //Comprobación de errores con el código cargado
        boolean estaBalanceado = cargarPilaBalanceo(codigoJavaEnString);
        System.out.println((estaBalanceado) ? "Está balanceado": "No está balanceado");
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
