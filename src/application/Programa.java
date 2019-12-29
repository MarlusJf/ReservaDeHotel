package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy) ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("check-out date (dd/mm/yyyy) ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) { // Estou comparando se a data de saida é posterior a data de entrada.
			System.out.println("Error in reservation: check-out date must be after check-in date");
			System.out.println("Erro na reserva: a data do check-out deve ser posterior à data do check-in");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Room number: ");
			number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy) ");
			checkin = sdf.parse(sc.next());
			System.out.print("check-out date (dd/mm/yyyy) ");
			checkout = sdf.parse(sc.next());

			Date now = new Date(); // Pegar a data de agora
			
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: reservation date for update must be future dates.");
			} 
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: check-out date must be after check-in date");
				System.out.println("Erro na reserva: a data do check-out deve ser posterior à data do check-in");
			} else {
				reservation.updatesDate(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}

		}
	}

}
