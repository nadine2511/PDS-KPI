package fr.esiag.sim.dao;

	import java.util.ArrayList;
import java.util.List;

	import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	import fr.esiag.sim.jdbc.JDBCConnection;
import fr.esiag.sim.jdbc.JDBCException;
import fr.esiag.sim.model.Operator;

	public class OperatorDAOImpl implements AbstractDAO<Operator> {
		
		private static final Logger logger = LoggerFactory.getLogger(OperatorDAOImpl.class);

		@Override
		public List<Operator> list() {
			
			    JDBCConnection bddrq = new JDBCConnection();
			
			    List<List<String>> operatorList;
				String request = "SELECT * from operator;";
				
				try {
					operatorList = bddrq.resultSelectQuery(request);
					List<Operator> operatorListe = new ArrayList<Operator>();
					
					for (List<String> element : operatorList) {
						
						int i = 0 ;
						
						Operator operator = new Operator();
						
						for (String value : element) {
							
							switch(i)
							{
							case 0:
								operator.setIdOperator(Integer.valueOf(value));
								break;
							case 1:
								operator.setFirstNameOP(value);
								break;
							case 2:
								operator.setLastNameOP(value);
								break;
							case 3:
								operator.setIdSector(Integer.valueOf(value));
								break;	
							case 4:
								operator.setLoginOperator(value);
								break;
							case 5:
								operator.setPasswordOp(value);
								break;
							}
							
							i++;
						}
						
						operatorListe.add(operator);
					}
					return operatorListe;
				} catch (JDBCException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;	
			
		}

}
