package fecha;

/**
 * Clase fecha con los atributos dia mes y año, con un constructor vacío y otro
 * con todos los atributos y con los métodos fechaCorrecta, esBisiesto y
 * diaSiguiente
 */
public class Fecha {
	/**
	 * Atributo dia de la fecha
	 */
	private int d; // d�a
	/**
	 * Atributo mes de la fecha
	 */
	private int m; // mes
	/**
	 * Atributo año de la fecha
	 */
	private int a; // a�o

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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Método que comprueba si una fecha es correcta (Por ej que el mes no sea 15)
	 * 
	 * @return true si tanto dia como mes y año son correctos, false si alguno no lo
	 *         es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método para comprobar si un año es bisiesto
	 * 
	 * @return true si el año es bisiesto, false si no lo es
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Método para aumentar en un día la fecha con la que se invoca al método
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método para pasar la fecha a String en el formato dd/mm/aa
	 * 
	 * @return fecha en forma de String
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
