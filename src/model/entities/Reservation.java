package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainExceptions {
		if (!checkout.after(checkin)) {
			throw new DomainExceptions(" check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime(); // Vou achar a diferença que existe entre as datas em
															// milesegundos.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Esse tipo enumerado converte a quantidade de
																	// milesegundos em dias.

	}

	public void updatesDate(Date checkin, Date checkout) throws DomainExceptions   {
		Date now = new Date(); // Pegar a data de agora

		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("reservation date for update must be future dates.");
		}
		if (!checkout.after(checkin)) {
			throw new DomainExceptions(" check-out date must be after check-in date");
		}

		this.checkin = checkin;
		this.checkout = checkout;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " nights.";
	}

}
