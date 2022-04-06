import org.nfunk.jep.JEP;

public class MetodoSecante implements RootStrategy {

    @Override
    public void root(String expresion, double a, double b, double t, int iter) {
        double x = a;
        double e = Math.abs(evaluar(expresion,x));
        double counter = 0;

        while((e>t) && (counter<iter))
        {
            counter++;
            x = b-(evaluar(expresion,b)*(b-a))/((evaluar(expresion,b)-evaluar(expresion,a))+1e-32);
            b = a;
            a = x;
            e = Math.abs(evaluar(expresion,x));
        }

        System.out.println("La raiz utilizando el metodo de la Secante es: ");
        System.out.print(x);
        System.out.println("\n");

        
    }

    @Override
    public double evaluar(String expresion, double x) {
        JEP f = new JEP();
        f.addStandardFunctions();
        f.addStandardConstants();
        f.addVariable("x", x);
        f.parseExpression(expresion);

        return f.getValue();
    }
    
}
