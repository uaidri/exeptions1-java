package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

public class Reservation {
	
	private Integer roomNumber;
	Date checkOut;
	Date checkIn;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}



	public Integer getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}



	public Date getCheckOut() {
		return checkOut;
	}

	

	public Date getCheckIn() {
		return checkIn;
	}
	

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return " Reservation dates for update must be future dates";

		}
		if (!checkOut.after(checkIn)) {
			return " Check-out date must be after check-in data";

		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}



	@Override
	public String toString() {
		return "Room " + roomNumber +
				", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+" nights";
	}




}
