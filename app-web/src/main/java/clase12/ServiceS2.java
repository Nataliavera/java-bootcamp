package clase12;

public class ServiceS2 implements IService {

	@Override
	public Dato consultar() {
		String res = "id0001nombrecarlos    saldo01550";

//		SUBSTRING(START, END) INCLUYE START, EXCLUYE END 0,10 >0.9
		String idStr = res.substring(2,6);
		String nomStr = res.substring(12,22);
//		nomStr = nomStr.trim();
		String saldo = res.substring(res.length()-5,res.length());
		
		return new Dato(Long.parseLong(idStr), nomStr);
	}

}
