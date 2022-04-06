public class RootContext {
	
	private RootStrategy strategy;
	
	public void setRootMethod(RootStrategy strategy) {
		this.strategy = strategy;
	}

	public void rootExpresion(String expresion,double a, double b, double t,int iter){
		this.strategy.root(expresion,a,b,t,iter);
	}
}
