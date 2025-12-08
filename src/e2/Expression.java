package e2;

/*Es el "componente" del patrón composite, así podemos tratar a TODAS las entradas
  como expresiones, tratanto a todas por igual (polimorfismo). */

public interface Expression {

    double evaluate();
    String toPostfix();
}
