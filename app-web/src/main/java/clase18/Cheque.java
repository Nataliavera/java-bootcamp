package clase18;

import java.util.Date;

public class Cheque implements Comparable<Cheque> {

	private String cmc7;
	private String banco;
	private Date fechaPago;

	public Cheque(String cmc7, String banco) {
		super();
		this.cmc7 = cmc7;
		this.banco = banco;
	}

	public Cheque(String cmc7, String banco, Date fechaPago) {
		super();
		this.cmc7 = cmc7;
		this.banco = banco;
		this.fechaPago = fechaPago;
	}

//	== 0 LOS DOS OBJETOS SON IGUALES 
//	>0 : this.atr > b.atr
//	<: this.art < b.atr

	public String getCmc7() {
		return cmc7;
	}

	public void setCmc7(String cmc7) {
		this.cmc7 = cmc7;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public int compareTo(Cheque b) {

		int resta = 0;

		if (b == null) {
			resta = 0;
		} else {
//		COMPARAR UN MISMO OBJETO
			if (this == b) {
				resta = 0;
			}

//		if(b.cmc7.compareTo(this.cmc7)== 0) {
//			return this.banco.compareTo(b.banco);
//		}
			resta = b.cmc7.compareTo(this.cmc7);

//		TOMO EL CMC7 PARA INDICAR  QUE DOS CHQUES SON IGUALES SI Y SOLO SI THIS.CMC7 = B.CMC7
//			PUEDO HACER COMPARATO CON DOS STRING

			resta = (resta == 0) ? this.banco.compareTo(b.banco) : resta;
		}

		return resta;
	}

	@Override
	public String toString() {
		return "Cheque [cmc7=" + cmc7 + ", banco=" + banco + ", fechaPago=" + fechaPago + "]";
	}

}
