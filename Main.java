public class Main {

	public static void main(String[] args) {
		
		String expresion = "x-4";

		System.out.println("\n----------------------------------------");
		System.out.println("Ejemplo de Patron Strategy");
		System.out.println("----------------------------------------\n");

		RootContext context;
        context = new RootContext();
		context.setRootMethod(new MetodoBiseccion());
		context.rootExpresion(expresion,3,6,1e-32,1000000);

        System.out.println("\n----------------------------------------\n");

		context.setRootMethod(new MetodoRegulaFalsi());
		context.rootExpresion(expresion,0,6,1e-32,1000000);

        System.out.println("\n----------------------------------------\n");

		context.setRootMethod(new MetodoSecante());
		context.rootExpresion(expresion,0,3,1e-32,1000000);
	}
}
