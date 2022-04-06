import org.nfunk.jep.JEP;

public class MetodoBiseccion implements RootStrategy

{

    @Override
    public void root(String expresion,double a, double b, double t,int iter) {
        double x = Double.NaN;

        int contador;
        contador = 0;

        double evalA = evaluar(expresion,a);
        
        if (!Double.isNaN(evalA))
        {
            double evalB = evaluar(expresion,b);
            if ((evalA*evalB < 0))
            {
                do 
                {
                    x = (a+b)/2;
                    contador++;
                    evalA = evaluar(expresion, a);
                    evalB = evaluar(expresion, b);

                    if (evalA*evaluar(expresion, x) < 0)
                    {
                        b = x;
                    }else 
                    {
                        a = x;
                    }
                    
                }while((Math.abs(evaluar(expresion, x))>t) && contador < iter);
            }

            if (!Double.isNaN(x))
            {
                System.out.println("La raiz utilizando el metodo de la Biseccion es: ");
                System.out.print(x);
                System.out.println("\n");
            }else 
            {
                System.out.println("No se encontró una raiz en el intervalo dado\n");
            }
        }

    }
    
    @Override
    public double evaluar(String expresion, double x)
    {
        JEP f = new JEP();
        f.addStandardFunctions();
        f.addStandardConstants();
        f.addVariable("x", x);
        f.parseExpression(expresion);

        return f.getValue();
    }

}