import org.nfunk.jep.JEP;

public class MetodoRegulaFalsi implements RootStrategy {

    @Override
    public void root(String expresion, double a, double b, double t, int iter) {
        
        double evalA = evaluar(expresion,a);
        double evalB = evaluar(expresion,b);
        double c,counter=0;
        if(evalA*evalB > 0)
        {
            System.out.println("No se encontró una raiz en el intervalo dado\n");
        }
        else 
        {
            while(counter<iter)
            {
                c = ((evaluar(expresion,b)*a)-(evaluar(expresion,a)*b))/(evaluar(expresion,b)-evaluar(expresion,a));
                if (evaluar(expresion,c) <= t){
                    System.out.println("La raiz utilizando el metodo Regula Falsi es: ");
                    System.out.print(c);
                    System.out.println("\n");
                    counter = iter;
                    return;
                }
                if (evaluar(expresion,a)*evaluar(expresion,c) < 0)
                {
                    b = c;
                }
                else 
                {
                    a = c;
                }
                counter++;
            }
            System.out.println("No se encontró una raiz en ");
            System.out.print(counter);
            System.out.println(" iteraciones\n");
        }
        
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
