package fecha;

/**
 * Clase fecha con los atributos dia mes y año, con un constructor vacío y otro
 * con todos los atributos y con los métodos fechaCorrecta, esBisiesto y
 * diaSiguiente
 */
public class Fecha {
	public static final int DIEZ = 10;
	/**
	 * Atributo dia de la fecha
	 */
	private int dia; // d�a
	/**
	 * Atributo mes de la fecha
	 */
	private int mes; // mes
	/**
	 * Atributo año de la fecha
	 */
	private int anio; // a�o

	/**
	 * Constructor vacío
	 */
	public Fecha() {

	}

	/**
	 * Constructor con los tres atributos de la clase
	 * 
	 * @param dia  dia de la fecha que se quiere crear
	 * @param mes  mes de la fecha que se quiere crear
	 * @param anio año de la fecha que se quiere crear
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	/**
	 * Método que comprueba si una fecha es correcta (Por ej que el mes no sea 15)
	 * 
	 * @return true si tanto dia como mes y año son correctos, false si alguno no lo
	 *         es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método para comprobar si un año es bisiesto
	 * 
	 * @return true si el año es bisiesto, false si no lo es
	 */
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	/**
	 * Método para aumentar en un día la fecha con la que se invoca al método
	 */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	/**
	 * Método para pasar la fecha a String en el formato dd/mm/aa
	 * 
	 * @return fecha en forma de String
	 */
	public String toString() {
		String fecha;
		if (dia < DIEZ && mes < DIEZ) {
			fecha = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < DIEZ && mes >= DIEZ) {
			fecha = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= DIEZ && mes < DIEZ) {
			fecha = dia + "-0" + mes + "-" + anio;
		} else {
			fecha = dia + "-" + mes + "-" + anio;
		}
		return fecha;
	}

}
