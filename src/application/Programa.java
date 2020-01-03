package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy) ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("check-out date (dd/mm/yyyy) ");
			Date checkout = sdf.parse(sc.next());

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

			reservation.updatesDate(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Data inválida");
		}
		catch(DomainExceptions e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}
		catch(RuntimeException e) { // Com esse catch, eu trato todas as exceções do tipo RunTimeException
			System.out.println("Erro!");
		}

	}

}
